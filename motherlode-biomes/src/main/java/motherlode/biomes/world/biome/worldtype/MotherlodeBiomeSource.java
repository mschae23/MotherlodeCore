package motherlode.biomes.world.biome.worldtype;

import net.minecraft.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import motherlode.biomes.world.biome.layer.MotherlodeBiomeLayers;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.util.BiomeLayerSampler;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MotherlodeBiomeSource extends BiomeSource {
    public static final Codec<MotherlodeBiomeSource> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.LONG.fieldOf("seed").stable().forGetter(biomeSource -> biomeSource.seed),
            MotherlodeBiomeSourceConfig.CODEC.fieldOf("config").forGetter(biomeSource -> biomeSource.config),
            RegistryLookupCodec.of(Registry.BIOME_KEY).stable().forGetter(biomeSource -> biomeSource.biomeRegistry)
        ).apply(instance, instance.stable(MotherlodeBiomeSource::new)));

    private static final Logger LOGGER = LogManager.getLogger();

    private final long seed;
    private final MotherlodeBiomeSourceConfig config;
    private final BiomeLayerSampler<RegistryKey<Biome>> sampler;
    private final Registry<Biome> biomeRegistry;

    public MotherlodeBiomeSource(long seed, MotherlodeBiomeSourceConfig config, Registry<Biome> biomeRegistry) {
        super(config.getBiomes(biomeRegistry));
        this.seed = seed;
        this.biomeRegistry = biomeRegistry;
        this.config = config;

        BiomeLayerSampler<ClimateCategory> climateLayer = MotherlodeBiomeLayers.buildClimateLayer(seed,
            MotherlodeBiomeLayers.buildContinentLayer(
                seed,
                this.config.getContinentConfig()
            ),
            this.config.getClimateConfig()
        );

        BiomeLayerSampler<Integer> noiseLayer = MotherlodeBiomeLayers.buildNoiseLayer(seed,
            climateLayer);

        this.sampler = MotherlodeBiomeLayers.buildBiomeLayer(seed,
            MotherlodeBiomeLayers.buildBiomeLayoutLayer(seed,
                climateLayer,
                MotherlodeBiomeLayers.buildHillLayer(seed,
                    noiseLayer
                ),
                this.config.getBiomeCategories(),
                this.config.getOceanBiomes(),
                this.config.getBiomeLayout(),
                this.config.getBiomeSizeConfig().getBiomeScale(),
                this.config.getOceanCategory()
            ),
            MotherlodeBiomeLayers.buildRiverLayer(seed,
                noiseLayer,
                this.config.getBiomeSizeConfig().getBiomeScale()
            ),
            MotherlodeBiomeLayers.buildOceanLayer(seed,
                this.config.getBiomeSizeConfig().getOceanClimateSize()
            ),
            this.config.getBiomeCategories(),
            this.config.getRivers(),
            this.config.getBiomeSizeConfig().getBiomeAndRiverScale(),
            this.config.getOceanCategory(),
            this.config.getOceanBiomes()
        );
    }

    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Environment(EnvType.CLIENT)
    public BiomeSource withSeed(long seed) {
        return new MotherlodeBiomeSource(seed, this.config, this.biomeRegistry);
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        RegistryKey<Biome> key = this.sampler.sample(biomeX, biomeZ);
        if (key == null) {
            throw new IllegalStateException("No biome emitted by layers");
        } else {
            Biome biome = this.biomeRegistry.get(key);
            if (biome == null) {
                if (SharedConstants.isDevelopment) {
                    throw Util.throwOrPause(new IllegalStateException("Unknown biome id: " + key.getValue()));
                } else {
                    LOGGER.warn("Unknown biome id: " + key.getValue());
                    return this.biomeRegistry.get(BiomeKeys.OCEAN);
                }
            } else {
                return biome;
            }
        }
    }
}

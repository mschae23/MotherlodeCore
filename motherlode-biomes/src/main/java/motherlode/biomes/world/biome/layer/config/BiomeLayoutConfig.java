package motherlode.biomes.world.biome.layer.config;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BaseBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.EdgeBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.InnerBiomeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ShoreBiomesConfig;
import de.martenschaefer.morecustomworldgen.util.RegistryKeys;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class BiomeLayoutConfig {
    public static final Codec<BiomeLayoutConfig> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            BaseBiomesConfig.CODEC.fieldOf("base_biomes").forGetter(BiomeLayoutConfig::getBaseBiomes),
            InnerBiomeConfig.CODEC.listOf().fieldOf("large_inner_biomes").forGetter(BiomeLayoutConfig::getLargeInnerBiomes),
            EdgeBiomesConfig.CODEC.fieldOf("biome_edges").forGetter(BiomeLayoutConfig::getBiomeEdges),
            HillBiomesConfig.CODEC.fieldOf("hill_biomes").forGetter(BiomeLayoutConfig::getHillBiomes),
            InnerBiomeConfig.CODEC.listOf().fieldOf("patch_inner_biomes").forGetter(BiomeLayoutConfig::getPatchInnerBiomes),
            ShoreBiomesConfig.CODEC.fieldOf("shore_biomes").forGetter(BiomeLayoutConfig::getShoreBiomes),
            RegistryKeys.BIOME_LIST_CODEC.fieldOf("shallow_ocean_biomes").forGetter(BiomeLayoutConfig::getShallowOceanBiomes),
            RegistryKeys.BIOME_CODEC.fieldOf("forest_biome").forGetter(BiomeLayoutConfig::getForestBiome),
            RegistryKeys.BIOME_CODEC.fieldOf("plains_biome").forGetter(BiomeLayoutConfig::getPlainsBiome),
            InnerBiomeConfig.CODEC.listOf().fieldOf("spot_inner_biomes").forGetter(BiomeLayoutConfig::getSpotInnerBiomes)
        ).apply(instance, instance.stable(BiomeLayoutConfig::new))
    );

    private final BaseBiomesConfig baseBiomes;
    private final List<InnerBiomeConfig> largeInnerBiomes;
    private final EdgeBiomesConfig biomeEdges;
    private final HillBiomesConfig hillBiomes;
    private final List<InnerBiomeConfig> patchInnerBiomes;
    private final ShoreBiomesConfig shoreBiomes;
    private final List<RegistryKey<Biome>> shallowOceanBiomes;
    private final RegistryKey<Biome> forestBiome;
    private final RegistryKey<Biome> plainsBiome;
    private final List<InnerBiomeConfig> spotInnerBiomes;

    public BiomeLayoutConfig(BaseBiomesConfig baseBiomes, List<InnerBiomeConfig> largeInnerBiomes, EdgeBiomesConfig biomeEdges, HillBiomesConfig hillBiomes, List<InnerBiomeConfig> patchInnerBiomes, ShoreBiomesConfig shoreBiomes, List<RegistryKey<Biome>> shallowOceanBiomes, RegistryKey<Biome> forestBiome, RegistryKey<Biome> plainsBiome, List<InnerBiomeConfig> spotInnerBiomes) {
        this.baseBiomes = baseBiomes;
        this.largeInnerBiomes = largeInnerBiomes;
        this.biomeEdges = biomeEdges;
        this.hillBiomes = hillBiomes;
        this.patchInnerBiomes = patchInnerBiomes;
        this.shoreBiomes = shoreBiomes;
        this.shallowOceanBiomes = shallowOceanBiomes;
        this.forestBiome = forestBiome;
        this.plainsBiome = plainsBiome;
        this.spotInnerBiomes = spotInnerBiomes;
    }

    public BaseBiomesConfig getBaseBiomes() {
        return this.baseBiomes;
    }

    public List<InnerBiomeConfig> getLargeInnerBiomes() {
        return this.largeInnerBiomes;
    }

    public EdgeBiomesConfig getBiomeEdges() {
        return this.biomeEdges;
    }

    public HillBiomesConfig getHillBiomes() {
        return this.hillBiomes;
    }

    public List<InnerBiomeConfig> getPatchInnerBiomes() {
        return this.patchInnerBiomes;
    }

    public ShoreBiomesConfig getShoreBiomes() {
        return this.shoreBiomes;
    }

    public List<RegistryKey<Biome>> getShallowOceanBiomes() {
        return this.shallowOceanBiomes;
    }

    public RegistryKey<Biome> getForestBiome() {
        return this.forestBiome;
    }

    public RegistryKey<Biome> getPlainsBiome() {
        return this.plainsBiome;
    }

    public List<InnerBiomeConfig> getSpotInnerBiomes() {
        return this.spotInnerBiomes;
    }

    public List<Supplier<Biome>> getBiomes(Registry<Biome> biomeRegistry) {
        List<Supplier<Biome>> biomes = this.getBaseBiomes().getBiomes(biomeRegistry);
        biomes.addAll(InnerBiomeConfig.getBiomes(this.getLargeInnerBiomes(), biomeRegistry));
        biomes.addAll(this.getBiomeEdges().getBiomes(biomeRegistry));
        biomes.addAll(this.getHillBiomes().getBiomes(biomeRegistry));
        biomes.addAll(InnerBiomeConfig.getBiomes(this.getPatchInnerBiomes(), biomeRegistry));
        biomes.addAll(this.getShoreBiomes().getBiomes(biomeRegistry));
        biomes.addAll(InnerBiomeConfig.getBiomes(this.getSpotInnerBiomes(), biomeRegistry));

        return biomes;
    }
}

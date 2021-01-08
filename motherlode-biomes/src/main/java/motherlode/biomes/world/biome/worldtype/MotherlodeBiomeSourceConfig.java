package motherlode.biomes.world.biome.worldtype;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import motherlode.biomes.world.biome.layer.config.BiomeLayoutConfig;
import motherlode.biomes.world.biome.layer.config.ClimateConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeSizeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ContinentConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.OceanBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.RiverConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class MotherlodeBiomeSourceConfig {
    public static final Codec<MotherlodeBiomeSourceConfig> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            BiomeCategory.CODEC.listOf().fieldOf("biome_categories").forGetter(MotherlodeBiomeSourceConfig::getBiomeCategories),
            ContinentConfig.CODEC.fieldOf("continents").forGetter(MotherlodeBiomeSourceConfig::getContinentConfig),
            ClimateConfig.CODEC.fieldOf("climates").forGetter(MotherlodeBiomeSourceConfig::getClimateConfig),
            BiomeLayoutConfig.CODEC.fieldOf("biome_layout").forGetter(MotherlodeBiomeSourceConfig::getBiomeLayout),
            BiomeSizeConfig.CODEC.fieldOf("biome_size").forGetter(MotherlodeBiomeSourceConfig::getBiomeSizeConfig),
            Codec.STRING.fieldOf("ocean_category").forGetter(MotherlodeBiomeSourceConfig::getOceanCategory),
            RiverConfig.CODEC.fieldOf("rivers").forGetter(MotherlodeBiomeSourceConfig::getRivers),
            OceanBiomesConfig.CODEC.fieldOf("ocean_biomes").forGetter(MotherlodeBiomeSourceConfig::getOceanBiomes)
        ).apply(instance, instance.stable(MotherlodeBiomeSourceConfig::new)));

    private final List<BiomeCategory> biomeCategories;
    private final ContinentConfig continents;
    private final ClimateConfig climates;
    private final BiomeLayoutConfig biomeLayout;
    private final BiomeSizeConfig biomeSize;
    private final String oceanCategory;
    private final RiverConfig rivers;
    private final OceanBiomesConfig oceanBiomes;

    public MotherlodeBiomeSourceConfig(List<BiomeCategory> biomeCategories, ContinentConfig continents, ClimateConfig climates, BiomeLayoutConfig biomeLayout, BiomeSizeConfig biomeSize, String oceanCategory, RiverConfig rivers, OceanBiomesConfig oceanBiomes) {
        this.biomeCategories = biomeCategories;
        this.continents = continents;
        this.climates = climates;
        this.biomeLayout = biomeLayout;
        this.biomeSize = biomeSize;
        this.oceanCategory = oceanCategory;
        this.rivers = rivers;
        this.oceanBiomes = oceanBiomes;
    }

    public List<BiomeCategory> getBiomeCategories() {
        return this.biomeCategories;
    }

    public ContinentConfig getContinentConfig() {
        return this.continents;
    }

    public ClimateConfig getClimateConfig() {
        return this.climates;
    }

    public BiomeLayoutConfig getBiomeLayout() {
        return this.biomeLayout;
    }

    public BiomeSizeConfig getBiomeSizeConfig() {
        return this.biomeSize;
    }

    public String getOceanCategory() {
        return this.oceanCategory;
    }

    public RiverConfig getRivers() {
        return this.rivers;
    }

    public OceanBiomesConfig getOceanBiomes() {
        return this.oceanBiomes;
    }

    public Stream<Supplier<Biome>> getBiomes(Registry<Biome> biomeRegistry) {
        List<Supplier<Biome>> biomes = this.getBiomeLayout().getBiomes(biomeRegistry);
        biomes.addAll(this.rivers.getBiomes(biomeRegistry));
        biomes.addAll(this.oceanBiomes.getBiomes(biomeRegistry));

        return biomes.stream();
    }
}

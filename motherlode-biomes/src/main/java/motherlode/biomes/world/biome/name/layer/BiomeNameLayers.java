package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.BiomeNameLayer;
import motherlode.biomes.world.biome.name.BiomeNameParentedLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.ContinentCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ClimateConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ContinentConfig;

public final class BiomeNameLayers {
    private BiomeNameLayers() {
    }

    public static BiomeNameLayer<ContinentCategory> buildContinentLayer(ContinentConfig config, LayerRandomnessSource random) {
        ScaleLayer<ContinentCategory> normalScaleLayer = ScaleLayer.normal();
        ScaleLayer<ContinentCategory> fuzzyScaleLayer = ScaleLayer.fuzzy();

        BiomeNameLayer<ContinentCategory> continents = new ContinentBiomeNameLayer(config.getContinentChance(), config.shouldGenerateOriginContinent()).withSalt(1L);
        continents = continents.andThen(fuzzyScaleLayer, 2000L);
        continents = continents.andThen(IncreaseEdgeCurvatureContinentBiomeNameLayer.INSTANCE, 1L);
        continents = continents.andThen(normalScaleLayer, 2001L);
        continents = continents.andThen(IncreaseEdgeCurvatureContinentBiomeNameLayer.INSTANCE, 2L);
        continents = continents.andThen(IncreaseEdgeCurvatureContinentBiomeNameLayer.INSTANCE, 50L);
        continents = continents.andThen(IncreaseEdgeCurvatureContinentBiomeNameLayer.INSTANCE, 70L);
        continents = continents.andThen(new AddIslandLayer(config.getIslandChance()), 2L);

        return continents;
    }

    public static BiomeNameLayer<ClimateCategory> buildClimateLayer(BiomeNameLayer<ContinentCategory> continentLayer, ClimateConfig config) {
        ScaleLayer<ClimateCategory> normalScaleLayer = ScaleLayer.normal();

        BiomeNameLayer<ClimateCategory> climates = continentLayer.convert(new AddBaseClimatesBiomeNameLayer(config), 2L);
        climates = climates.andThen(IncreaseEdgeCurvatureClimateBiomeNameLayer.INSTANCE, 3L);
        climates = climates.andThen(ClimateBiomeNameLayers.AddTemperateBiomesLayer.INSTANCE, 2L);
        climates = climates.andThen(ClimateBiomeNameLayers.AddCoolBiomesLayer.INSTANCE, 2L);
        climates = climates.andThen(ClimateBiomeNameLayers.AddSpecialBiomesLayer.INSTANCE, 3L);
        climates = stack(2002L, normalScaleLayer, climates, config.getClimateSize());
        climates = climates.andThen(IncreaseEdgeCurvatureClimateBiomeNameLayer.INSTANCE, 4L);
        climates = climates.andThen(new AddRareIslandLayer(config.getRareIslandChance()), 5L);
        climates = climates.andThen(AddDeepOceanLayer.INSTANCE, 4L);

        climates = stack(1000L, normalScaleLayer, climates, 0);

        return climates;
    }

    public static BiomeNameLayer<Integer> buildNoiseLayer(BiomeNameLayer<ClimateCategory> climateLayer, int biomeSize) {
        ScaleLayer<Integer> normalScaleLayer = ScaleLayer.normal();

        BiomeNameLayer<Integer> noise = climateLayer.convert(SimpleNoiseBiomeNameLayer.INSTANCE, 100L);
        noise = stack(1000L, normalScaleLayer, noise, 2);
        noise = stack(1000L, normalScaleLayer, noise, biomeSize);

        return noise;
    }

    private static <T> BiomeNameLayer<T> stack(long salt, BiomeNameParentedLayer<T> layerToStack, BiomeNameLayer<T> parent, int count) {
        BiomeNameLayer<T> layer = parent;

        for (int i = 0; i < count; i++) {
            layer = layer.andThen(layerToStack, salt + (long) i);
        }

        return layer;
    }
}

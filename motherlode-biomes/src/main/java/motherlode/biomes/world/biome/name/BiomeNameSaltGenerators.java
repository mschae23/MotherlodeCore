package motherlode.biomes.world.biome.name;

import java.util.function.IntFunction;
import motherlode.biomes.world.biome.name.layer.BiomeNameLayers;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.CustomLayeredPresets;

public class BiomeNameSaltGenerators {
    public static final IntFunction<BiomeNameLayer<Integer>> DEFAULT = seed -> BiomeNameLayers.buildNoiseLayer(
        BiomeNameLayers.buildClimateLayer(
            BiomeNameLayers.buildContinentLayer(CustomLayeredPresets.VANILLA_CONTINENTS,
                new LayerRandomnessSourceImpl(seed)),
            CustomLayeredPresets.VANILLA_CLIMATES
        ),
        4
    );

    public static final IntFunction<BiomeNameLayer<Integer>> LARGE_BIOMES = seed -> BiomeNameLayers.buildNoiseLayer(
        BiomeNameLayers.buildClimateLayer(
            BiomeNameLayers.buildContinentLayer(CustomLayeredPresets.VANILLA_CONTINENTS,
                new LayerRandomnessSourceImpl(seed)),
            CustomLayeredPresets.VANILLA_CLIMATES
        ),
        6
    );
}

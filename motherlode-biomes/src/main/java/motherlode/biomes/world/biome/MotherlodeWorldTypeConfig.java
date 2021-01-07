package motherlode.biomes.world.biome;

import net.minecraft.world.biome.BiomeKeys;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.CustomLayeredPresets;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BaseBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeLayoutConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeSizeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeWeightEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ContinentConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.CustomLayeredBiomeSourceConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.InnerBiomeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.RiverConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ShoreBiomesConfig;
import com.google.common.collect.ImmutableList;

public final class MotherlodeWorldTypeConfig {
    private MotherlodeWorldTypeConfig() {
    }

    public static final ContinentConfig MOTHERLODE_CONTINENTS = new ContinentConfig(
        10, true, 23
    );

    public static final BaseBiomesConfig MOTHERLODE_BASE_BIOMES = new BaseBiomesConfig(
        ImmutableList.of( // Dry biomes
            new BiomeWeightEntry(
                BiomeKeys.DESERT,
                3
            ),
            new BiomeWeightEntry(
                BiomeKeys.SAVANNA,
                2
            ),
            new BiomeWeightEntry(
                BiomeKeys.PLAINS,
                1
            )
        ),
        ImmutableList.of( // Temperate biomes
            new BiomeWeightEntry(
                BiomeKeys.FOREST,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.DARK_FOREST,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.MOUNTAINS,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.PLAINS,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.BIRCH_FOREST,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.SWAMP,
                1
            )
        ),
        ImmutableList.of( // Cool biomes
            new BiomeWeightEntry(
                BiomeKeys.FOREST,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.MOUNTAINS,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.TAIGA,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.PLAINS,
                1)
        ),
        ImmutableList.of( // Snowy biomes
            new BiomeWeightEntry(
                BiomeKeys.SNOWY_TUNDRA,
                3
            ),
            new BiomeWeightEntry(
                BiomeKeys.SNOWY_TAIGA,
                1
            )
        ),
        ImmutableList.of( // Special dry biomes
            new BiomeWeightEntry(
                BiomeKeys.WOODED_BADLANDS_PLATEAU,
                2
            ),
            new BiomeWeightEntry(
                BiomeKeys.BADLANDS_PLATEAU,
                1
            )
        ),
        ImmutableList.of( // Special temperate biomes
            new BiomeWeightEntry(
                BiomeKeys.JUNGLE,
                1
            )
        ),
        ImmutableList.of( // Special cool biomes
            new BiomeWeightEntry(
                BiomeKeys.GIANT_TREE_TAIGA,
                1
            )
        ),
        ImmutableList.of( // Special snowy biomes
        ),
        ImmutableList.of( // Rare island biomes
            new BiomeWeightEntry(
                BiomeKeys.MUSHROOM_FIELDS,
                1
            )
        ),
        BiomeKeys.PLAINS
    );

    public static final BiomeLayoutConfig MOTHERLODE_BIOME_LAYOUT = new BiomeLayoutConfig(
        CustomLayeredPresets.VANILLA_BASE_BIOMES,
        ImmutableList.of(
            new InnerBiomeConfig(
                BiomeKeys.JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE,
                10
            )
        ),
        CustomLayeredPresets.VANILLA_EDGE_BIOMES,
        CustomLayeredPresets.VANILLA_HILL_BIOMES,
        ImmutableList.of(
            new InnerBiomeConfig(
                BiomeKeys.PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS,
                57
            )
        ),
        new ShoreBiomesConfig(
            ImmutableList.of(
            ),
            CustomLayeredPresets.VANILLA_SHORE_BIOME_OVERRIDES,
            BiomeKeys.BEACH
        ),
        ImmutableList.of(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN
        ),
        BiomeKeys.FOREST,
        BiomeKeys.PLAINS
    );

    public static final BiomeSizeConfig MOTHERLODE_BIOME_SIZE = new BiomeSizeConfig(
        4, 1, 7
    );

    public static final CustomLayeredBiomeSourceConfig MOTHERLODE_WORLD_TYPE_CONFIG = new CustomLayeredBiomeSourceConfig(
        CustomLayeredPresets.VANILLA_CATEGORIES,
        MOTHERLODE_CONTINENTS,
        CustomLayeredPresets.VANILLA_CLIMATES,
        MOTHERLODE_BIOME_LAYOUT,
        MOTHERLODE_BIOME_SIZE,
        "ocean",
        new RiverConfig(
            true,
            CustomLayeredPresets.VANILLA_RIVER_OVERRIDES,
            BiomeKeys.RIVER),
        CustomLayeredPresets.VANILLA_OCEAN_BIOMES
    );
}

package motherlode.biomes.world.biome.worldtype;

import java.util.List;
import net.minecraft.world.biome.BiomeKeys;
import motherlode.biomes.world.MotherlodeBiomes;
import motherlode.biomes.world.biome.layer.config.BiomeLayoutConfig;
import motherlode.biomes.world.biome.layer.config.ClimateConfig;
import motherlode.biomes.world.biome.layer.config.HillBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.CustomLayeredPresets;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BaseBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeSizeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeWeightEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ContinentConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.EdgeBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.HillBiomesConfig.HillBiomeEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.HillBiomesConfig.SpecialHillBiomeEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.InnerBiomeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.RiverConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ShoreBiomesConfig;
import com.google.common.collect.ImmutableList;

public final class MotherlodeWorldTypeConfig {
    private MotherlodeWorldTypeConfig() {
    }

    public static final List<BiomeCategory> MOTHERLODE_BIOME_CATEGORIES = ImmutableList.of(
        new BiomeCategory(BiomeKeys.BEACH, "beach"),
        new BiomeCategory(BiomeKeys.SNOWY_BEACH, "beach"),
        new BiomeCategory(BiomeKeys.DESERT, "desert"),
        new BiomeCategory(BiomeKeys.DESERT_HILLS, "desert"),
        new BiomeCategory(BiomeKeys.DESERT_LAKES, "desert"),
        new BiomeCategory(BiomeKeys.GRAVELLY_MOUNTAINS, "mountains"),
        new BiomeCategory(BiomeKeys.MODIFIED_GRAVELLY_MOUNTAINS, "mountains"),
        new BiomeCategory(BiomeKeys.MOUNTAIN_EDGE, "mountains"),
        new BiomeCategory(BiomeKeys.MOUNTAINS, "mountains"),
        new BiomeCategory(BiomeKeys.WOODED_MOUNTAINS, "mountains"),
        new BiomeCategory(BiomeKeys.BIRCH_FOREST, "forest"),
        new BiomeCategory(BiomeKeys.BIRCH_FOREST_HILLS, "forest"),
        new BiomeCategory(BiomeKeys.DARK_FOREST, "forest"),
        new BiomeCategory(BiomeKeys.DARK_FOREST_HILLS, "forest"),
        new BiomeCategory(BiomeKeys.FLOWER_FOREST, "forest"),
        new BiomeCategory(BiomeKeys.FOREST, "forest"),
        new BiomeCategory(BiomeKeys.TALL_BIRCH_FOREST, "forest"),
        new BiomeCategory(BiomeKeys.TALL_BIRCH_HILLS, "forest"),
        new BiomeCategory(BiomeKeys.ICE_SPIKES, "icy"),
        new BiomeCategory(BiomeKeys.SNOWY_MOUNTAINS, "icy"),
        new BiomeCategory(BiomeKeys.SNOWY_TUNDRA, "icy"),
        new BiomeCategory(BiomeKeys.BAMBOO_JUNGLE, "jungle"),
        new BiomeCategory(BiomeKeys.BAMBOO_JUNGLE_HILLS, "jungle"),
        new BiomeCategory(BiomeKeys.JUNGLE, "jungle"),
        new BiomeCategory(BiomeKeys.JUNGLE_EDGE, "jungle"),
        new BiomeCategory(BiomeKeys.JUNGLE_HILLS, "jungle"),
        new BiomeCategory(BiomeKeys.MODIFIED_JUNGLE, "jungle"),
        new BiomeCategory(BiomeKeys.MODIFIED_JUNGLE_EDGE, "jungle"),
        new BiomeCategory(BiomeKeys.BADLANDS, "badlands"),
        new BiomeCategory(BiomeKeys.ERODED_BADLANDS, "badlands"),
        new BiomeCategory(BiomeKeys.MODIFIED_BADLANDS_PLATEAU, "badlands"),
        new BiomeCategory(BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU, "badlands"),
        new BiomeCategory(BiomeKeys.BADLANDS_PLATEAU, "badlands_plateau"),
        new BiomeCategory(BiomeKeys.WOODED_BADLANDS_PLATEAU, "badlands_plateau"),
        new BiomeCategory(BiomeKeys.MUSHROOM_FIELDS, "mushroom_fields"),
        new BiomeCategory(BiomeKeys.MUSHROOM_FIELD_SHORE, "mushroom_fields"),
        new BiomeCategory(BiomeKeys.STONE_SHORE, "none"),
        new BiomeCategory(BiomeKeys.OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.WARM_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.LUKEWARM_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.COLD_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.FROZEN_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.DEEP_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.DEEP_WARM_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.DEEP_LUKEWARM_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.DEEP_COLD_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.DEEP_FROZEN_OCEAN, "ocean"),
        new BiomeCategory(BiomeKeys.PLAINS, "plains"),
        new BiomeCategory(BiomeKeys.SUNFLOWER_PLAINS, "plains"),
        new BiomeCategory(BiomeKeys.FROZEN_RIVER, "river"),
        new BiomeCategory(BiomeKeys.RIVER, "river"),
        new BiomeCategory(BiomeKeys.SAVANNA, "savanna"),
        new BiomeCategory(BiomeKeys.SAVANNA_PLATEAU, "savanna"),
        new BiomeCategory(BiomeKeys.SHATTERED_SAVANNA, "savanna"),
        new BiomeCategory(BiomeKeys.SHATTERED_SAVANNA_PLATEAU, "savanna"),
        new BiomeCategory(BiomeKeys.SWAMP, "swamp"),
        new BiomeCategory(BiomeKeys.SWAMP_HILLS, "swamp"),
        new BiomeCategory(BiomeKeys.GIANT_SPRUCE_TAIGA, "taiga"),
        new BiomeCategory(BiomeKeys.GIANT_SPRUCE_TAIGA_HILLS, "taiga"),
        new BiomeCategory(BiomeKeys.GIANT_TREE_TAIGA, "taiga"),
        new BiomeCategory(BiomeKeys.GIANT_TREE_TAIGA_HILLS, "taiga"),
        new BiomeCategory(BiomeKeys.SNOWY_TAIGA, "taiga"),
        new BiomeCategory(BiomeKeys.SNOWY_TAIGA_HILLS, "taiga"),
        new BiomeCategory(BiomeKeys.SNOWY_TAIGA_MOUNTAINS, "taiga"),
        new BiomeCategory(BiomeKeys.TAIGA, "taiga"),
        new BiomeCategory(BiomeKeys.TAIGA_HILLS, "taiga"),
        new BiomeCategory(BiomeKeys.TAIGA_MOUNTAINS, "taiga"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_TUNDRA, "icy"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_TUNDRA_HILLS, "icy"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_FOREST, "arctic_forest"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_FOREST_HILLS, "arctic_forest"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_FOREST_MOUNTAINS, "arctic_forest"),
        new BiomeCategory(MotherlodeBiomes.MOUNTAINS, "mountains"),
        new BiomeCategory(MotherlodeBiomes.MOUNTAINS_EDGE, "mountains"),
        new BiomeCategory(MotherlodeBiomes.MOUNTAIN_FOREST, "mountains"),
        new BiomeCategory(MotherlodeBiomes.EXTREME_MOUNTAINS, "mountains"),
        new BiomeCategory(MotherlodeBiomes.GRAVEL_MOUNTAINS, "mountains"),
        new BiomeCategory(MotherlodeBiomes.EXTREME_GRAVEL_MOUNTAINS, "mountains"),
        new BiomeCategory(MotherlodeBiomes.MOUNTAIN_PEAK, "mountains"),
        new BiomeCategory(MotherlodeBiomes.GRAVEL_MOUNTAIN_PEAK, "mountains"),
        new BiomeCategory(MotherlodeBiomes.BOREAL_FOREST, "boreal_forest"),
        new BiomeCategory(MotherlodeBiomes.BOREAL_FOREST_HILLS, "boreal_forest"),
        new BiomeCategory(MotherlodeBiomes.BOREAL_FOREST_MOUNTAINS, "boreal_forest"),
        new BiomeCategory(MotherlodeBiomes.PLAINS, "plains"),
        new BiomeCategory(MotherlodeBiomes.MEADOW, "plains"),
        new BiomeCategory(MotherlodeBiomes.DECIDUOUS_FOREST, "forest"),
        new BiomeCategory(MotherlodeBiomes.DECIDUOUS_FOREST_HILLS, "forest")
    );

    public static final ContinentConfig MOTHERLODE_CONTINENTS = new ContinentConfig(
        10, true, 23
    );

    public static final ClimateConfig MOTHERLODE_CLIMATES = new ClimateConfig(
        2, 1, 3,
        6,
        3,
        100
    );

    public static final BaseBiomesConfig MOTHERLODE_BASE_BIOMES = new BaseBiomesConfig(
        ImmutableList.of(// Dry biomes
            new BiomeWeightEntry(
                BiomeKeys.DESERT,
                3
            ),
            new BiomeWeightEntry(
                BiomeKeys.SAVANNA,
                2
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.PLAINS,
                1
            )
        ),
        ImmutableList.of(// Temperate biomes
            new BiomeWeightEntry(
                BiomeKeys.FOREST,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.DARK_FOREST,
                1
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.PLAINS,
                1
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.DECIDUOUS_FOREST,
                1
            ),
            new BiomeWeightEntry(
                BiomeKeys.SWAMP,
                1
            )
        ),
        ImmutableList.of(// Cool biomes
            new BiomeWeightEntry(
                BiomeKeys.FOREST,
                1
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.MOUNTAINS,
                1
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.BOREAL_FOREST,
                1
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.PLAINS,
                1)
        ),
        ImmutableList.of(// Snowy biomes
            new BiomeWeightEntry(
                MotherlodeBiomes.ARCTIC_TUNDRA,
                3
            ),
            new BiomeWeightEntry(
                MotherlodeBiomes.ARCTIC_FOREST,
                1
            )
        ),
        ImmutableList.of(// Special dry biomes
            new BiomeWeightEntry(
                BiomeKeys.WOODED_BADLANDS_PLATEAU,
                2
            ),
            new BiomeWeightEntry(
                BiomeKeys.BADLANDS_PLATEAU,
                1
            )
        ),
        ImmutableList.of(// Special temperate biomes
            new BiomeWeightEntry(
                BiomeKeys.JUNGLE,
                1
            )
        ),
        ImmutableList.of(// Special cool biomes
        /* new BiomeWeightEntry(
               BiomeKeys.GIANT_TREE_TAIGA,
               1
        ) */
        ),
        ImmutableList.of(// Special snowy biomes
        ),
        ImmutableList.of(// Rare island biomes
            new BiomeWeightEntry(
                BiomeKeys.MUSHROOM_FIELDS,
                1
            )
        ),
        MotherlodeBiomes.PLAINS
    );

    public static final List<SpecialHillBiomeEntry> MOTHERLODE_SPECIAL_HILL_BIOMES = ImmutableList.of(
        // new SpecialHillBiomeEntry(MotherlodeBiomes.PLAINS, BiomeKeys.SUNFLOWER_PLAINS),
        new SpecialHillBiomeEntry(BiomeKeys.DESERT, BiomeKeys.DESERT_LAKES),
        new SpecialHillBiomeEntry(MotherlodeBiomes.MOUNTAINS, MotherlodeBiomes.GRAVEL_MOUNTAINS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.EXTREME_MOUNTAINS, MotherlodeBiomes.EXTREME_GRAVEL_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
        new SpecialHillBiomeEntry(MotherlodeBiomes.BOREAL_FOREST, MotherlodeBiomes.BOREAL_FOREST_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.SWAMP, BiomeKeys.SWAMP_HILLS),
        new SpecialHillBiomeEntry(BiomeKeys.JUNGLE, BiomeKeys.MODIFIED_JUNGLE),
        new SpecialHillBiomeEntry(BiomeKeys.JUNGLE_EDGE, BiomeKeys.MODIFIED_JUNGLE_EDGE),
        new SpecialHillBiomeEntry(BiomeKeys.DARK_FOREST, BiomeKeys.DARK_FOREST_HILLS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.ARCTIC_FOREST, MotherlodeBiomes.ARCTIC_FOREST_MOUNTAINS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.ARCTIC_FOREST_HILLS, BiomeKeys.FROZEN_OCEAN),
        new SpecialHillBiomeEntry(BiomeKeys.GIANT_TREE_TAIGA, BiomeKeys.GIANT_SPRUCE_TAIGA),
        new SpecialHillBiomeEntry(BiomeKeys.GIANT_TREE_TAIGA_HILLS, BiomeKeys.GIANT_SPRUCE_TAIGA_HILLS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.MOUNTAIN_FOREST, MotherlodeBiomes.EXTREME_GRAVEL_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.SAVANNA, BiomeKeys.SHATTERED_SAVANNA),
        new SpecialHillBiomeEntry(BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SHATTERED_SAVANNA_PLATEAU),
        new SpecialHillBiomeEntry(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS),
        new SpecialHillBiomeEntry(BiomeKeys.WOODED_BADLANDS_PLATEAU, BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU),
        new SpecialHillBiomeEntry(BiomeKeys.BADLANDS_PLATEAU, BiomeKeys.MODIFIED_BADLANDS_PLATEAU)
    );

    public static final List<HillBiomeEntry> MOTHERLODE_NORMAL_HILL_BIOMES = ImmutableList.of(
        new HillBiomeEntry(BiomeKeys.DESERT, BiomeKeys.DESERT_HILLS),
        new HillBiomeEntry(BiomeKeys.FOREST, BiomeKeys.WOODED_HILLS),
        new HillBiomeEntry(MotherlodeBiomes.DECIDUOUS_FOREST, MotherlodeBiomes.DECIDUOUS_FOREST_HILLS),
        new HillBiomeEntry(BiomeKeys.DARK_FOREST, MotherlodeBiomes.PLAINS),
        new HillBiomeEntry(MotherlodeBiomes.BOREAL_FOREST, MotherlodeBiomes.BOREAL_FOREST_HILLS),
        new HillBiomeEntry(BiomeKeys.GIANT_TREE_TAIGA, BiomeKeys.GIANT_TREE_TAIGA_HILLS),
        new HillBiomeEntry(MotherlodeBiomes.ARCTIC_FOREST, MotherlodeBiomes.ARCTIC_FOREST_HILLS),
        new HillBiomeEntry(MotherlodeBiomes.ARCTIC_TUNDRA, MotherlodeBiomes.ARCTIC_TUNDRA_HILLS),
        new HillBiomeEntry(BiomeKeys.JUNGLE, BiomeKeys.JUNGLE_HILLS),
        new HillBiomeEntry(BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.BAMBOO_JUNGLE_HILLS),
        new HillBiomeEntry(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN),
        new HillBiomeEntry(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN),
        new HillBiomeEntry(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN),
        new HillBiomeEntry(BiomeKeys.FROZEN_RIVER, BiomeKeys.DEEP_FROZEN_OCEAN),
        new HillBiomeEntry(MotherlodeBiomes.MOUNTAINS, MotherlodeBiomes.EXTREME_MOUNTAINS),
        new HillBiomeEntry(BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU),
        new HillBiomeEntry("badlands_plateau", BiomeKeys.BADLANDS)
    );

    public static final HillBiomesConfig MOTHERLODE_HILL_BIOMES = new HillBiomesConfig(
        ImmutableList.of(
        ),
        19,
        MOTHERLODE_SPECIAL_HILL_BIOMES,
        MOTHERLODE_NORMAL_HILL_BIOMES,
        CustomLayeredPresets.VANILLA_COMPLEX_HILL_BIOMES
    );

    public static final EdgeBiomesConfig MOTHERLODE_EDGE_BIOMES = new EdgeBiomesConfig(
        ImmutableList.of(// Ignored categories
        ),
        ImmutableList.of(
            new EdgeBiomesConfig.CategoryEdgeBiome(
                BiomeKeys.WOODED_BADLANDS_PLATEAU,
                BiomeKeys.BADLANDS
            ),
            new EdgeBiomesConfig.CategoryEdgeBiome(
                BiomeKeys.BADLANDS_PLATEAU,
                BiomeKeys.BADLANDS
            ),
            new EdgeBiomesConfig.CategoryEdgeBiome(
                BiomeKeys.GIANT_TREE_TAIGA,
                MotherlodeBiomes.BOREAL_FOREST
            )
        ),
        ImmutableList.of(
            new EdgeBiomesConfig.EdgeBiome(
                BiomeKeys.DESERT,
                ImmutableList.of(
                    MotherlodeBiomes.ARCTIC_TUNDRA,
                    MotherlodeBiomes.ARCTIC_TUNDRA_HILLS,
                    MotherlodeBiomes.ARCTIC_FOREST_MOUNTAINS
                ),
                MotherlodeBiomes.MOUNTAIN_FOREST
            ),
            new EdgeBiomesConfig.EdgeBiome(
                BiomeKeys.DESERT,
                ImmutableList.of(
                    MotherlodeBiomes.ARCTIC_FOREST,
                    MotherlodeBiomes.ARCTIC_FOREST_HILLS
                ),
                MotherlodeBiomes.BOREAL_FOREST
            ),
            new EdgeBiomesConfig.EdgeBiome(
                BiomeKeys.SWAMP,
                ImmutableList.of(
                    BiomeKeys.DESERT,
                    MotherlodeBiomes.ARCTIC_TUNDRA,
                    MotherlodeBiomes.ARCTIC_TUNDRA_HILLS,
                    MotherlodeBiomes.ARCTIC_FOREST,
                    MotherlodeBiomes.ARCTIC_FOREST_HILLS
                ),
                MotherlodeBiomes.PLAINS
            ),
            new EdgeBiomesConfig.EdgeBiome(
                BiomeKeys.SWAMP,
                ImmutableList.of(
                    BiomeKeys.JUNGLE,
                    BiomeKeys.BAMBOO_JUNGLE
                ),
                BiomeKeys.JUNGLE_EDGE
            )
        )
    );

    public static final List<ShoreBiomesConfig.Override> MOTHERLODE_SHORE_BIOME_OVERRIDES = ImmutableList.of(
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                BiomeKeys.MUSHROOM_FIELDS
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
                BiomeKeys.OCEAN,
                BiomeKeys.WARM_OCEAN,
                BiomeKeys.LUKEWARM_OCEAN,
                BiomeKeys.COLD_OCEAN,
                BiomeKeys.FROZEN_OCEAN
            ),
            BiomeKeys.MUSHROOM_FIELD_SHORE,
            false,
            true,
            false
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                BiomeKeys.BAMBOO_JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE_HILLS,
                BiomeKeys.JUNGLE,
                BiomeKeys.JUNGLE_HILLS,
                BiomeKeys.JUNGLE_EDGE,
                BiomeKeys.MODIFIED_JUNGLE,
                BiomeKeys.MODIFIED_JUNGLE_EDGE
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
                BiomeKeys.BAMBOO_JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE_HILLS,
                BiomeKeys.JUNGLE,
                BiomeKeys.JUNGLE_HILLS,
                BiomeKeys.JUNGLE_EDGE,
                BiomeKeys.MODIFIED_JUNGLE,
                BiomeKeys.MODIFIED_JUNGLE_EDGE,
                BiomeKeys.FOREST,
                MotherlodeBiomes.BOREAL_FOREST,
                MotherlodeBiomes.BOREAL_FOREST_HILLS
            ),
            BiomeKeys.JUNGLE_EDGE,
            true,
            true,
            true
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                MotherlodeBiomes.MOUNTAINS,
                MotherlodeBiomes.MOUNTAIN_FOREST
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
            ),
            BiomeKeys.STONE_SHORE,
            false,
            true,
            true
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                MotherlodeBiomes.MOUNTAINS
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
                MotherlodeBiomes.MOUNTAINS,
                MotherlodeBiomes.MOUNTAINS_EDGE,
                MotherlodeBiomes.MOUNTAIN_FOREST,
                MotherlodeBiomes.EXTREME_MOUNTAINS,
                MotherlodeBiomes.GRAVEL_MOUNTAINS,
                MotherlodeBiomes.EXTREME_GRAVEL_MOUNTAINS,
                MotherlodeBiomes.MOUNTAIN_PEAK,
                MotherlodeBiomes.GRAVEL_MOUNTAIN_PEAK
            ),
            MotherlodeBiomes.MOUNTAINS_EDGE,
            true,
            false,
            false
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                BiomeKeys.SNOWY_BEACH,
                BiomeKeys.FROZEN_RIVER,
                MotherlodeBiomes.ARCTIC_TUNDRA,
                MotherlodeBiomes.ARCTIC_TUNDRA_HILLS,
                BiomeKeys.ICE_SPIKES,
                MotherlodeBiomes.ARCTIC_FOREST,
                MotherlodeBiomes.ARCTIC_FOREST_HILLS,
                MotherlodeBiomes.ARCTIC_FOREST_MOUNTAINS,
                BiomeKeys.FROZEN_OCEAN
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
            ),
            BiomeKeys.SNOWY_BEACH,
            false
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                BiomeKeys.BADLANDS,
                BiomeKeys.WOODED_BADLANDS_PLATEAU
            ),
            ImmutableList.of(
                BiomeKeys.OCEAN,
                BiomeKeys.WARM_OCEAN,
                BiomeKeys.LUKEWARM_OCEAN,
                BiomeKeys.COLD_OCEAN,
                BiomeKeys.FROZEN_OCEAN,
                BiomeKeys.DEEP_OCEAN,
                BiomeKeys.DEEP_WARM_OCEAN,
                BiomeKeys.DEEP_LUKEWARM_OCEAN,
                BiomeKeys.DEEP_COLD_OCEAN,
                BiomeKeys.DEEP_FROZEN_OCEAN
            ),
            ImmutableList.of(
                BiomeKeys.BADLANDS,
                BiomeKeys.WOODED_BADLANDS_PLATEAU,
                BiomeKeys.BADLANDS_PLATEAU,
                BiomeKeys.ERODED_BADLANDS,
                BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU,
                BiomeKeys.MODIFIED_BADLANDS_PLATEAU
            ),
            BiomeKeys.DESERT,
            true,
            false,
            false
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                BiomeKeys.RIVER
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
            ),
            BiomeKeys.RIVER,
            false,
            false,
            false
        ),
        new ShoreBiomesConfig.Override(
            ImmutableList.of(
                BiomeKeys.SWAMP
            ),
            ImmutableList.of(
            ),
            ImmutableList.of(
            ),
            BiomeKeys.SWAMP,
            false,
            false,
            false
        )
    );

    public static final BiomeLayoutConfig MOTHERLODE_BIOME_LAYOUT = new BiomeLayoutConfig(
        MOTHERLODE_BASE_BIOMES,
        ImmutableList.of(
            new InnerBiomeConfig(
                BiomeKeys.JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE,
                10
            ),
            new InnerBiomeConfig(
                MotherlodeBiomes.MOUNTAINS,
                MotherlodeBiomes.MOUNTAIN_FOREST,
                19
            )
        ),
        MOTHERLODE_EDGE_BIOMES,
        MOTHERLODE_HILL_BIOMES,
        ImmutableList.of(
            new InnerBiomeConfig(
                MotherlodeBiomes.PLAINS,
                MotherlodeBiomes.MEADOW,
                19
            ),
            new InnerBiomeConfig(
                MotherlodeBiomes.ARCTIC_TUNDRA,
                BiomeKeys.ICE_SPIKES,
                14
            )
        ),
        new ShoreBiomesConfig(
            ImmutableList.of(
            ),
            MOTHERLODE_SHORE_BIOME_OVERRIDES,
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
        BiomeKeys.PLAINS,
        ImmutableList.of(
            new InnerBiomeConfig(
                MotherlodeBiomes.EXTREME_MOUNTAINS,
                MotherlodeBiomes.MOUNTAIN_PEAK,
                5
            ),
            new InnerBiomeConfig(
                MotherlodeBiomes.EXTREME_GRAVEL_MOUNTAINS,
                MotherlodeBiomes.GRAVEL_MOUNTAIN_PEAK,
                5
            )
        )
    );

    public static final BiomeSizeConfig MOTHERLODE_BIOME_SIZE = new BiomeSizeConfig(
        1, 1, 7
    );

    public static final List<RiverConfig.Override> MOTHERLODE_RIVER_OVERRIDES = ImmutableList.of(
        new RiverConfig.Override(
            ImmutableList.of(
                MotherlodeBiomes.ARCTIC_TUNDRA,
                MotherlodeBiomes.ARCTIC_TUNDRA_HILLS,
                MotherlodeBiomes.ARCTIC_FOREST,
                MotherlodeBiomes.ARCTIC_FOREST_HILLS
            ),
            BiomeKeys.FROZEN_RIVER
        ),
        new RiverConfig.Override(
            ImmutableList.of(
                BiomeKeys.MUSHROOM_FIELDS,
                BiomeKeys.MUSHROOM_FIELD_SHORE
            ),
            BiomeKeys.MUSHROOM_FIELD_SHORE
        )
    );

    public static final MotherlodeBiomeSourceConfig MOTHERLODE_WORLD_TYPE_CONFIG = new MotherlodeBiomeSourceConfig(
        MOTHERLODE_BIOME_CATEGORIES,
        MOTHERLODE_CONTINENTS,
        MOTHERLODE_CLIMATES,
        MOTHERLODE_BIOME_LAYOUT,
        MOTHERLODE_BIOME_SIZE,
        "ocean",
        new RiverConfig(
            true,
            MOTHERLODE_RIVER_OVERRIDES,
            BiomeKeys.RIVER),
        CustomLayeredPresets.VANILLA_OCEAN_BIOMES
    );
}

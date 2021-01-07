package motherlode.biomes.world.biome;

import java.util.List;
import net.minecraft.world.biome.BiomeKeys;
import motherlode.biomes.world.MotherlodeBiomes;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.CustomLayeredPresets;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BaseBiomesConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeLayoutConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeSizeConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeWeightEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ContinentConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.CustomLayeredBiomeSourceConfig;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.HillBiomesConfig;
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
        new BiomeCategory(MotherlodeBiomes.ARCTIC_TUNDRA_MOUNTAINS, "icy"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_FOREST, "arctic_forest"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_FOREST_HILLS, "arctic_forest"),
        new BiomeCategory(MotherlodeBiomes.ARCTIC_FOREST_MOUNTAINS, "arctic_forest")
    );

    public static final ContinentConfig MOTHERLODE_CONTINENTS = new ContinentConfig(
        10, true, 23
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
                BiomeKeys.PLAINS,
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
        ImmutableList.of(// Cool biomes
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
            new BiomeWeightEntry(
                BiomeKeys.GIANT_TREE_TAIGA,
                1
            )
        ),
        ImmutableList.of(// Special snowy biomes
        ),
        ImmutableList.of(// Rare island biomes
            new BiomeWeightEntry(
                BiomeKeys.MUSHROOM_FIELDS,
                1
            )
        ),
        BiomeKeys.PLAINS
    );

    public static final List<SpecialHillBiomeEntry> MOTHERLODE_SPECIAL_HILL_BIOMES = ImmutableList.of(
        new SpecialHillBiomeEntry(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS),
        new SpecialHillBiomeEntry(BiomeKeys.DESERT, BiomeKeys.DESERT_LAKES),
        new SpecialHillBiomeEntry(BiomeKeys.MOUNTAINS, BiomeKeys.GRAVELLY_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
        new SpecialHillBiomeEntry(BiomeKeys.TAIGA, BiomeKeys.TAIGA_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.SWAMP, BiomeKeys.SWAMP_HILLS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.ARCTIC_TUNDRA, MotherlodeBiomes.ARCTIC_TUNDRA_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.JUNGLE, BiomeKeys.MODIFIED_JUNGLE),
        new SpecialHillBiomeEntry(BiomeKeys.JUNGLE_EDGE, BiomeKeys.MODIFIED_JUNGLE_EDGE),
        new SpecialHillBiomeEntry(BiomeKeys.BIRCH_FOREST, BiomeKeys.TALL_BIRCH_FOREST),
        new SpecialHillBiomeEntry(BiomeKeys.BIRCH_FOREST_HILLS, BiomeKeys.TALL_BIRCH_HILLS),
        new SpecialHillBiomeEntry(BiomeKeys.DARK_FOREST, BiomeKeys.DARK_FOREST_HILLS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.ARCTIC_FOREST, MotherlodeBiomes.ARCTIC_FOREST_MOUNTAINS),
        new SpecialHillBiomeEntry(MotherlodeBiomes.ARCTIC_FOREST_HILLS, BiomeKeys.FROZEN_OCEAN),
        new SpecialHillBiomeEntry(BiomeKeys.GIANT_TREE_TAIGA, BiomeKeys.GIANT_SPRUCE_TAIGA),
        new SpecialHillBiomeEntry(BiomeKeys.GIANT_TREE_TAIGA_HILLS, BiomeKeys.GIANT_SPRUCE_TAIGA_HILLS),
        new SpecialHillBiomeEntry(BiomeKeys.WOODED_MOUNTAINS, BiomeKeys.MODIFIED_GRAVELLY_MOUNTAINS),
        new SpecialHillBiomeEntry(BiomeKeys.SAVANNA, BiomeKeys.SHATTERED_SAVANNA),
        new SpecialHillBiomeEntry(BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SHATTERED_SAVANNA_PLATEAU),
        new SpecialHillBiomeEntry(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS),
        new SpecialHillBiomeEntry(BiomeKeys.WOODED_BADLANDS_PLATEAU, BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU),
        new SpecialHillBiomeEntry(BiomeKeys.BADLANDS_PLATEAU, BiomeKeys.MODIFIED_BADLANDS_PLATEAU)
    );

    public static final List<HillBiomeEntry> MOTHERLODE_NORMAL_HILL_BIOMES = ImmutableList.of(
        new HillBiomeEntry(BiomeKeys.DESERT, BiomeKeys.DESERT_HILLS),
        new HillBiomeEntry(BiomeKeys.FOREST, BiomeKeys.WOODED_HILLS),
        new HillBiomeEntry(BiomeKeys.BIRCH_FOREST, BiomeKeys.BIRCH_FOREST_HILLS),
        new HillBiomeEntry(BiomeKeys.DARK_FOREST, BiomeKeys.PLAINS),
        new HillBiomeEntry(BiomeKeys.TAIGA, BiomeKeys.TAIGA_HILLS),
        new HillBiomeEntry(BiomeKeys.GIANT_TREE_TAIGA, BiomeKeys.GIANT_TREE_TAIGA_HILLS),
        new HillBiomeEntry(MotherlodeBiomes.ARCTIC_FOREST, MotherlodeBiomes.ARCTIC_FOREST_HILLS),
        new HillBiomeEntry(MotherlodeBiomes.ARCTIC_TUNDRA, MotherlodeBiomes.ARCTIC_TUNDRA_HILLS),
        new HillBiomeEntry(BiomeKeys.JUNGLE, BiomeKeys.JUNGLE_HILLS),
        new HillBiomeEntry(BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.BAMBOO_JUNGLE_HILLS),
        new HillBiomeEntry(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN),
        new HillBiomeEntry(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN),
        new HillBiomeEntry(BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN),
        new HillBiomeEntry(BiomeKeys.FROZEN_RIVER, BiomeKeys.DEEP_FROZEN_OCEAN),
        new HillBiomeEntry(BiomeKeys.MOUNTAINS, BiomeKeys.WOODED_MOUNTAINS),
        new HillBiomeEntry(BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU),
        new HillBiomeEntry("badlands_plateau", BiomeKeys.BADLANDS)
    );

    public static final HillBiomesConfig MOTHERLODE_HILL_BIOMES = new HillBiomesConfig(
        ImmutableList.of(
        ),
        MOTHERLODE_SPECIAL_HILL_BIOMES,
        MOTHERLODE_NORMAL_HILL_BIOMES,
        CustomLayeredPresets.VANILLA_COMPLEX_HILL_BIOMES
    );

    public static final BiomeLayoutConfig MOTHERLODE_BIOME_LAYOUT = new BiomeLayoutConfig(
        MOTHERLODE_BASE_BIOMES,
        ImmutableList.of(
            new InnerBiomeConfig(
                BiomeKeys.JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE,
                10
            )
        ),
        CustomLayeredPresets.VANILLA_EDGE_BIOMES,
        MOTHERLODE_HILL_BIOMES,
        ImmutableList.of(
            new InnerBiomeConfig(
                BiomeKeys.PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS,
                57
            ),
            new InnerBiomeConfig(
                MotherlodeBiomes.ARCTIC_TUNDRA,
                BiomeKeys.ICE_SPIKES,
                27
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
        MOTHERLODE_BIOME_CATEGORIES,
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

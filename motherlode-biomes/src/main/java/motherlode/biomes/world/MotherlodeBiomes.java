package motherlode.biomes.world;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import motherlode.base.Motherlode;
import motherlode.biomes.MotherlodeModule;
import motherlode.biomes.world.biome.ArcticForestBiome;
import motherlode.biomes.world.biome.ArcticTundraBiome;
import motherlode.biomes.world.biome.BorealForestBiome;
import motherlode.biomes.world.biome.DeciduousForestBiome;
import motherlode.biomes.world.biome.LakeBiome;
import motherlode.biomes.world.biome.MeadowBiome;
import motherlode.biomes.world.biome.MountainsBiome;
import motherlode.biomes.world.biome.OasisBiome;
import motherlode.biomes.world.biome.PlainsBiome;
import motherlode.biomes.world.biome.RuinedEdgeBiome;
import motherlode.biomes.world.biome.RuinedFlatsBiome;

public class MotherlodeBiomes {
    public static final RegistryKey<Biome> RUINED_FLATS = register("ruined_flats", RuinedFlatsBiome.create());
    public static final RegistryKey<Biome> RUINED_EDGE = register("ruined_edge", RuinedEdgeBiome.create());

    public static final RegistryKey<Biome> ARCTIC_TUNDRA = register("arctic_tundra", ArcticTundraBiome.create(0.125f, 0.05f, false));
    public static final RegistryKey<Biome> ARCTIC_TUNDRA_HILLS = register("arctic_tundra_hills", ArcticTundraBiome.create(0.45f, 0.3f, true));

    public static final RegistryKey<Biome> ARCTIC_FOREST = register("arctic_forest", ArcticForestBiome.create(0.2f, 0.2f, false, true));
    public static final RegistryKey<Biome> ARCTIC_FOREST_HILLS = register("arctic_forest_hills", ArcticForestBiome.create(0.45f, 0.3f, true, false));
    public static final RegistryKey<Biome> ARCTIC_FOREST_MOUNTAINS = register("arctic_forest_mountains", ArcticForestBiome.create(0.5f, 0.5f, true, false));

    public static final RegistryKey<Biome> MOUNTAINS = register("mountains", MountainsBiome.create(1.0f, 0.3f, ConfiguredSurfaceBuilders.MOUNTAIN, false));
    public static final RegistryKey<Biome> MOUNTAINS_EDGE = register("mountains_edge", MountainsBiome.create(0.75f, 0.2f, ConfiguredSurfaceBuilders.MOUNTAIN, true));
    public static final RegistryKey<Biome> MOUNTAIN_FOREST = register("mountain_forest", MountainsBiome.create(1.0f, 0.25f, ConfiguredSurfaceBuilders.MOUNTAIN, true));
    public static final RegistryKey<Biome> EXTREME_MOUNTAINS = register("extreme_mountains", MountainsBiome.create(1.3f, 0.8f, ConfiguredSurfaceBuilders.MOUNTAIN, false));
    public static final RegistryKey<Biome> GRAVEL_MOUNTAINS = register("gravel_mountains", MountainsBiome.create(0.9f, 0.3f, ConfiguredSurfaceBuilders.GRAVELLY_MOUNTAIN, false));
    public static final RegistryKey<Biome> EXTREME_GRAVEL_MOUNTAINS = register("extreme_gravel_mountains", MountainsBiome.create(1.2f, 0.7f, ConfiguredSurfaceBuilders.GRAVELLY_MOUNTAIN, false));
    public static final RegistryKey<Biome> MOUNTAIN_PEAK = register("mountain_peak", MountainsBiome.create(1.45f, 1.35f, ConfiguredSurfaceBuilders.MOUNTAIN, false));
    public static final RegistryKey<Biome> GRAVEL_MOUNTAIN_PEAK = register("gravel_mountain_peak", MountainsBiome.create(1.35f, 1.3f, ConfiguredSurfaceBuilders.GRAVELLY_MOUNTAIN, false));

    public static final RegistryKey<Biome> BOREAL_FOREST = register("boreal_forest", BorealForestBiome.create(0.2f, 0.2f, false));
    public static final RegistryKey<Biome> BOREAL_FOREST_HILLS = register("boreal_forest_hills", BorealForestBiome.create(0.45f, 0.3f, false));
    public static final RegistryKey<Biome> BOREAL_FOREST_MOUNTAINS = register("boreal_forest_mountains", BorealForestBiome.create(0.4f, 0.4f, true));

    public static final RegistryKey<Biome> PLAINS = register("plains", PlainsBiome.create(0.125f, 0.025f));

    public static final RegistryKey<Biome> MEADOW = register("meadow", MeadowBiome.create(0.125f, 0.03f));

    public static final RegistryKey<Biome> DECIDUOUS_FOREST = register("deciduous_forest", DeciduousForestBiome.create(0.1f, 0.2f));
    public static final RegistryKey<Biome> DECIDUOUS_FOREST_HILLS = register("deciduous_forest_hills", DeciduousForestBiome.create(0.45f, 0.3f));

    public static final RegistryKey<Biome> WARM_LAKE = register("warm_lake", LakeBiome.create(-0.9f, 0.1f, LakeBiome.Type.WARM));
    public static final RegistryKey<Biome> LAKE = register("lake", LakeBiome.create(-0.9f, 0.1f, LakeBiome.Type.NORMAL));
    public static final RegistryKey<Biome> COLD_LAKE = register("cold_lake", LakeBiome.create(-0.9f, 0.1f, LakeBiome.Type.COLD));

    public static final RegistryKey<Biome> OASIS = register("oasis", OasisBiome.create(0.12f, 0.04f));

    @SuppressWarnings("deprecation")
    public static void init() {
        OverworldBiomes.addContinentalBiome(RUINED_FLATS, OverworldClimate.TEMPERATE, 2);
        OverworldBiomes.setRiverBiome(RUINED_FLATS, RUINED_EDGE);
        OverworldBiomes.addEdgeBiome(RUINED_FLATS, RUINED_EDGE, 500);
    }

    private static RegistryKey<Biome> register(String name, Biome biome) {
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, Motherlode.id(MotherlodeModule.MODID, name));
        Registry.register(BuiltinRegistries.BIOME, key.getValue(), biome);
        return key;
    }
}

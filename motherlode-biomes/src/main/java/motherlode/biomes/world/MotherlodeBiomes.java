package motherlode.biomes.world;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import motherlode.base.Motherlode;
import motherlode.biomes.MotherlodeModule;
import motherlode.biomes.world.biome.ArcticForestBiome;
import motherlode.biomes.world.biome.ArcticTundraBiome;
import motherlode.biomes.world.biome.RuinedEdgeBiome;
import motherlode.biomes.world.biome.RuinedFlatsBiome;

public class MotherlodeBiomes {
    public static final RegistryKey<Biome> RUINED_FLATS = register("ruined_flats", RuinedFlatsBiome.create());
    public static final RegistryKey<Biome> RUINED_EDGE = register("ruined_edge", RuinedEdgeBiome.create());

    public static final RegistryKey<Biome> ARCTIC_TUNDRA = register("arctic_tundra", ArcticTundraBiome.create(0.125f, 0.05f, false));
    public static final RegistryKey<Biome> ARCTIC_TUNDRA_HILLS = register("arctic_tundra_hills", ArcticTundraBiome.create(0.45f, 0.3f, true));
    public static final RegistryKey<Biome> ARCTIC_TUNDRA_MOUNTAINS = register("arctic_tundra_mountains", ArcticTundraBiome.create(0.3f, 0.4f, true));

    public static final RegistryKey<Biome> ARCTIC_FOREST = register("arctic_forest", ArcticForestBiome.create(0.2f, 0.2f, false, true));
    public static final RegistryKey<Biome> ARCTIC_FOREST_HILLS = register("arctic_forest_hills", ArcticForestBiome.create(0.45f, 0.3f, false, false));
    public static final RegistryKey<Biome> ARCTIC_FOREST_MOUNTAINS = register("arctic_forest_mountains", ArcticForestBiome.create(0.3f, 0.4f, true, false));

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

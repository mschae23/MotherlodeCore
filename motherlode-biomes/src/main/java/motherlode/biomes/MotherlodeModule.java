package motherlode.biomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.api.ModInitializer;
import motherlode.base.Motherlode;
import motherlode.biomes.world.MotherlodeBiomeConfiguredFeatures;
import motherlode.biomes.world.MotherlodeBiomeFeatures;
import motherlode.biomes.world.MotherlodeBiomes;
import motherlode.biomes.world.MotherlodeStructures;
import motherlode.biomes.world.biome.worldtype.MotherlodeBiomeSource;
import org.apache.logging.log4j.Level;

public class MotherlodeModule implements ModInitializer {
    public static final String MODID = "motherlode-biomes";

    @Override
    public void onInitialize() {
        MotherlodeBiomesBlocks.init();
        MotherlodeBiomeFeatures.init();
        MotherlodeBiomeConfiguredFeatures.register();
        MotherlodeStructures.init();
        MotherlodeBiomes.init();

        Registry.register(Registry.BIOME_SOURCE, id("motherlode"), MotherlodeBiomeSource.CODEC);
    }

    public static void log(Level level, CharSequence message) {
        Motherlode.log(level, "Motherlode Biomes", message);
    }

    public static void log(Level level, Object message) {
        Motherlode.log(level, "Motherlode Biomes", String.valueOf(message));
    }

    public static Identifier id(String name) {
        return Motherlode.id(MODID, name);
    }
}

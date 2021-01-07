package motherlode.biomes.world;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import motherlode.biomes.MotherlodeModule;
import motherlode.biomes.world.feature.MarshFeature;

/**
 * @author Indigo Amann
 */
public class MotherlodeBiomeFeatures {
    public static final Feature<DefaultFeatureConfig> MARSH = register("marsh", new MarshFeature(DefaultFeatureConfig.CODEC));

    public static void init() {
    }

    public static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registry.FEATURE, MotherlodeModule.id(name), feature);
    }

    public static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(String name, F surfaceBuilder) {
        return Registry.register(Registry.SURFACE_BUILDER, MotherlodeModule.id(name), surfaceBuilder);
    }
}

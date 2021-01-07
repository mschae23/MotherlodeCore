package motherlode.biomes.world;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountNoiseDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import motherlode.base.Motherlode;
import motherlode.base.api.worldgen.FeatureTarget;
import motherlode.biomes.MotherlodeBiomesBlocks;
import motherlode.biomes.MotherlodeModule;

public class MotherlodeBiomeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPROUTS = registerKey("sprouts", Feature.RANDOM_PATCH.configure(new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(MotherlodeBiomesBlocks.SPROUTS.getDefaultState()), SimpleBlockPlacer.INSTANCE).tries(96).build()).decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 5, 10))));

    private static <FC extends FeatureConfig, F extends Feature<FC>> RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name, ConfiguredFeature<FC, F> feature) {
        return Motherlode.getFeaturesManager().registerConfiguredFeatureKey(MotherlodeModule.id(name), feature);
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> register(String name, ConfiguredFeature<FC, F> feature) {
        return Motherlode.getFeaturesManager().registerConfiguredFeature(MotherlodeModule.id(name), feature);
    }

    @SuppressWarnings("deprecation")
    public static void register() {
        Motherlode.getFeaturesManager().addFeature(FeatureTarget.of(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION), SPROUTS);
    }
}

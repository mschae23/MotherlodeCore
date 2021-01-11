package motherlode.biomes.world;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.CountNoiseDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import motherlode.base.Motherlode;
import motherlode.base.api.worldgen.FeatureTarget;
import motherlode.biomes.MotherlodeBiomesBlocks;
import motherlode.biomes.MotherlodeModule;
import com.google.common.collect.ImmutableList;

public class MotherlodeBiomeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPROUTS = registerKey("sprouts", Feature.RANDOM_PATCH.configure(new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(MotherlodeBiomesBlocks.SPROUTS.getDefaultState()), SimpleBlockPlacer.INSTANCE).tries(96).build()).decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 5, 10))));

    public static final ConfiguredFeature<?, ?> GIANT_TREES = register("giant_trees", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(ConfiguredFeatures.MEGA_SPRUCE.withChance(0.025641026F), ConfiguredFeatures.MEGA_PINE.withChance(0.30769232F), ConfiguredFeatures.PINE.withChance(0.33333334F)), ConfiguredFeatures.SPRUCE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).applyChance(2).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1F, 3))));
    public static final ConfiguredFeature<?, ?> GIANT_SPRUCE_TREES = register("giant_spruce_trees", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(ConfiguredFeatures.MEGA_SPRUCE.withChance(0.33333334F), ConfiguredFeatures.PINE.withChance(0.33333334F)), ConfiguredFeatures.SPRUCE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).applyChance(2).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 5))));

    public static final ConfiguredFeature<?, ?> PALM_TREE = register("palm_tree", Feature.TREE.configure(new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.JUNGLE_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.JUNGLE_LEAVES.getDefaultState()), new AcaciaFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new ForkingTrunkPlacer(5, 2, 2), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
    public static final ConfiguredFeature<?, ?> OASIS_TREES = register("oasis_trees", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(PALM_TREE.withChance(0.8F)), ConfiguredFeatures.OAK)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.2F, 2))));

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

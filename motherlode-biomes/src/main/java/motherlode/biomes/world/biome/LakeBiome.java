package motherlode.biomes.world.biome;

import java.util.function.UnaryOperator;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import motherlode.biomes.mixin.DefaultBiomeCreatorAccessor;

public class LakeBiome {
    public static Biome create(float depth, float scale, Type type) {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        type.getSpawns().apply(builder);

        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        builder2.surfaceBuilder(type.getSurfaceBuilder());
        DefaultBiomeFeatures.addOceanStructures(builder2);
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_OCEAN);
        DefaultBiomeFeatures.addOceanCarvers(builder2);
        DefaultBiomeFeatures.addDefaultLakes(builder2);
        DefaultBiomeFeatures.addAmethystGeodes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addWaterBiomeOakTrees(builder2);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addDefaultGrass(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addSprings(builder2);
        type.getGeneration().apply(builder2);
        DefaultBiomeFeatures.addFrozenTopLayer(builder2);

        return new Biome.Builder()
        .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.OCEAN)
            .depth(depth).scale(scale)
            .temperature(0.5f).downfall(0.5f)
            .effects(new BiomeEffects.Builder()
                .waterColor(type.getWaterColor())
                .waterFogColor(type.getWaterFogColor())
                .fogColor(12638463)
                .skyColor(DefaultBiomeCreatorAccessor.getSkyColor(0.5f))
                .moodSound(BiomeMoodSound.CAVE)
                .build()
            )
        .spawnSettings(builder.build())
        .generationSettings(builder2.build())
        .build();
    }

    public enum Type {
        WARM(ConfiguredSurfaceBuilders.FULL_SAND, generation -> generation
            .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.WARM_OCEAN_VEGETATION)
            .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_WARM)
            .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEA_PICKLE), spawns ->  {
                spawns.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.PUFFERFISH, 15, 1, 3));
                DefaultBiomeFeatures.addWarmOceanMobs(spawns, 10, 4);
                return spawns;
            }, 4445678, 270131),
        NORMAL(ConfiguredSurfaceBuilders.GRASS, generation -> {
            generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_NORMAL);
            DefaultBiomeFeatures.addSeagrassOnStone(generation);
            DefaultBiomeFeatures.addKelp(generation);
            return generation;
        }, spawns ->  {
            DefaultBiomeFeatures.addOceanMobs(spawns, 1, 4, 10);
            spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.DOLPHIN, 1, 1, 2));
            return spawns;
        }, 4159204, 329011),
        COLD(ConfiguredSurfaceBuilders.GRASS, generation -> {
            generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_COLD);
            DefaultBiomeFeatures.addSeagrassOnStone(generation);
            DefaultBiomeFeatures.addKelp(generation);
            return generation;
        }, spawns ->  {
            DefaultBiomeFeatures.addOceanMobs(spawns, 3, 4, 15);
            spawns.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 15, 1, 5));
            return spawns;
        }, 4020182, 329011);

        private final ConfiguredSurfaceBuilder<TernarySurfaceConfig> surfaceBuilder;
        private final UnaryOperator<GenerationSettings.Builder> generation;
        private final UnaryOperator<SpawnSettings.Builder> spawns;
        private final int waterColor;
        private final int waterFogColor;

        Type(ConfiguredSurfaceBuilder<TernarySurfaceConfig> surfaceBuilder,
        UnaryOperator<GenerationSettings.Builder> generation,
        UnaryOperator<SpawnSettings.Builder> spawns,
        int waterColor, int waterFogColor) {
            this.surfaceBuilder = surfaceBuilder;
            this.generation = generation;
            this.spawns = spawns;
            this.waterColor = waterColor;
            this.waterFogColor = waterFogColor;
        }

        public ConfiguredSurfaceBuilder<TernarySurfaceConfig> getSurfaceBuilder() {
            return this.surfaceBuilder;
        }

        public UnaryOperator<GenerationSettings.Builder> getGeneration() {
            return this.generation;
        }

        public UnaryOperator<SpawnSettings.Builder> getSpawns() {
            return this.spawns;
        }

        public int getWaterColor() {
            return this.waterColor;
        }

        public int getWaterFogColor() {
            return this.waterFogColor;
        }
    }
}
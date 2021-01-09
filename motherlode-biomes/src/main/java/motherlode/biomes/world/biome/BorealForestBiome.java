package motherlode.biomes.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import motherlode.biomes.mixin.DefaultBiomeCreatorAccessor;
import motherlode.biomes.world.MotherlodeBiomeConfiguredFeatures;

public class BorealForestBiome {
    public static Biome create(float depth, float scale, boolean mountains) {
        SpawnSettings.Builder builder1 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(builder1);
        builder1.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 4, 4));
        builder1.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
        builder1.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));
        if (!mountains) builder1.playerSpawnFriendly();

        DefaultBiomeFeatures.addBatsAndMonsters(builder1);
        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        builder2.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        if (!mountains) {
            builder2.structureFeature(ConfiguredStructureFeatures.VILLAGE_TAIGA);
            builder2.structureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST);
        }

        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder2);
        builder2.structureFeature(mountains ? ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN : ConfiguredStructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addDefaultLakes(builder2);
        DefaultBiomeFeatures.addAmethystGeodes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addLargeFerns(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addTaigaTrees(builder2);

        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, MotherlodeBiomeConfiguredFeatures.GIANT_TREES);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, MotherlodeBiomeConfiguredFeatures.GIANT_SPRUCE_TREES);

        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addTaigaGrass(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addSprings(builder2);
        DefaultBiomeFeatures.addSweetBerryBushes(builder2);
        DefaultBiomeFeatures.addFrozenTopLayer(builder2);

        return new Biome.Builder()
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.TAIGA)
            .depth(depth).scale(scale)
            .temperature(0.25f).downfall(0.8F)
            .effects(new BiomeEffects.Builder()
                .waterColor(4159204)
                .waterFogColor(329011)
                .fogColor(12638463)
                .skyColor(DefaultBiomeCreatorAccessor.getSkyColor(0.25f))
                .moodSound(BiomeMoodSound.CAVE)
                .build()
            ).spawnSettings(builder1.build())
            .generationSettings(builder2.build())
            .build();
    }
}

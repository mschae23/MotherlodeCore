package motherlode.biomes.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import net.minecraft.sound.BiomeMoodSound;
import motherlode.biomes.mixin.DefaultBiomeCreatorAccessor;
import motherlode.biomes.world.MotherlodeBiomeConfiguredFeatures;

public class OasisBiome {
    public static Biome create(float depth, float scale) {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addDesertMobs(builder);
      
        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        builder2.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        builder2.structureFeature(ConfiguredStructureFeatures.VILLAGE_DESERT);
        builder2.structureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST);
        builder2.structureFeature(ConfiguredStructureFeatures.DESERT_PYRAMID);
        DefaultBiomeFeatures.addFossils(builder2);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder2);
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_DESERT);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addDesertLakes(builder2);
        DefaultBiomeFeatures.addAmethystGeodes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addDefaultGrass(builder2);
        DefaultBiomeFeatures.addDesertDeadBushes(builder2);

        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, MotherlodeBiomeConfiguredFeatures.OASIS_TREES);
        
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDesertVegetation(builder2);
        DefaultBiomeFeatures.addSprings(builder2);
        DefaultBiomeFeatures.addDesertFeatures(builder2);
        DefaultBiomeFeatures.addFrozenTopLayer(builder2);

        return new Biome.Builder()
            .precipitation(Biome.Precipitation.NONE)
            .category(Biome.Category.DESERT)
            .depth(depth).scale(scale)
            .temperature(2.0f).downfall(0.0f)
            .effects(new BiomeEffects.Builder()
                .waterColor(4159204)
                .waterFogColor(329011)
                .fogColor(12638463)
                .skyColor(DefaultBiomeCreatorAccessor.getSkyColor(2.0f))
                .moodSound(BiomeMoodSound.CAVE)
                .build()
            )
            .spawnSettings(builder.build())
            .generationSettings(builder2.build())
            .build();
    }
}
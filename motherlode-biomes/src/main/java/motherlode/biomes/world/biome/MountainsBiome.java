package motherlode.biomes.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import motherlode.biomes.mixin.DefaultBiomeCreatorAccessor;

public class MountainsBiome {
    public static Biome create(float depth, float scale, ConfiguredSurfaceBuilder<TernarySurfaceConfig> surfaceBuilder, boolean extraTrees) {
        SpawnSettings.Builder builder1 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(builder1);
        builder1.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.LLAMA, 5, 4, 6));
        DefaultBiomeFeatures.addBatsAndMonsters(builder1);

        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        builder2.surfaceBuilder(surfaceBuilder);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder2);
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addDefaultLakes(builder2);
        DefaultBiomeFeatures.addAmethystGeodes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        if (extraTrees) DefaultBiomeFeatures.addExtraMountainTrees(builder2);
        else DefaultBiomeFeatures.addMountainTrees(builder2);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addDefaultGrass(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addSprings(builder2);
        DefaultBiomeFeatures.addEmeraldOre(builder2);
        DefaultBiomeFeatures.addInfestedStone(builder2);
        DefaultBiomeFeatures.addFrozenTopLayer(builder2);

        return new Biome.Builder()
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.EXTREME_HILLS)
            .depth(depth).scale(scale)
            .temperature(0.2f).downfall(0.3f)
            .effects(new BiomeEffects.Builder()
                .waterColor(4159204)
                .waterFogColor(329011)
                .fogColor(12638463)
                .skyColor(DefaultBiomeCreatorAccessor.getSkyColor(0.2f))
                .moodSound(BiomeMoodSound.CAVE)
                .build()
            )
            .spawnSettings(builder1.build())
            .generationSettings(builder2.build())
            .build();
    }
}

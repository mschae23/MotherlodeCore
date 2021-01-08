package motherlode.biomes.world.biome;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import motherlode.biomes.mixin.DefaultBiomeCreatorAccessor;

public class DeciduousForestBiome {
    public static Biome create(float depth, float scale) {
        SpawnSettings.Builder builder1 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(builder1);
        DefaultBiomeFeatures.addBatsAndMonsters(builder1);

        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        builder2.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder2);
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addDefaultLakes(builder2);
        DefaultBiomeFeatures.addAmethystGeodes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addForestFlowers(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addTallBirchTrees(builder2);
        DefaultBiomeFeatures.addBirchTrees(builder2);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addForestGrass(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addSprings(builder2);
        DefaultBiomeFeatures.addFrozenTopLayer(builder2);

        return new Biome.Builder()
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.FOREST)
            .depth(depth).scale(scale)
            .temperature(0.6f).downfall(0.6f)
            .effects((new BiomeEffects.Builder())
                .waterColor(4159204)
                .waterFogColor(329011)
                .fogColor(12638463)
                .skyColor(DefaultBiomeCreatorAccessor.getSkyColor(0.6f))
                .moodSound(BiomeMoodSound.CAVE)
                .build()
            )
            .spawnSettings(builder1.build())
            .generationSettings(builder2.build())
            .build();
    }
}

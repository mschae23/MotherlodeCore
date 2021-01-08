package motherlode.biomes.world.biome.worldtype;

import java.util.function.BiFunction;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import motherlode.biomes.MotherlodeModule;

public class MotherlodeWorldType extends GeneratorType {
    public static final BiFunction<Registry<Biome>, Long, MotherlodeBiomeSource> PRESET = (registry, seed) ->
        new MotherlodeBiomeSource(seed,
            MotherlodeWorldTypeConfig.MOTHERLODE_WORLD_TYPE_CONFIG,
            registry);

    public MotherlodeWorldType() {
        super(MotherlodeModule.MODID + ".motherlode");
        GeneratorType.VALUES.add(this);
    }

    @Override
    protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> generatorSettingsRegistry, long seed) {
        return new NoiseChunkGenerator(PRESET.apply(biomeRegistry, seed), seed, () -> generatorSettingsRegistry.getOrThrow(ChunkGeneratorSettings.OVERWORLD));
    }
}

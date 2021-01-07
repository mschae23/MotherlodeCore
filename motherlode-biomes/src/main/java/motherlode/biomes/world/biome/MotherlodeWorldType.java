package motherlode.biomes.world.biome;

import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import motherlode.biomes.MotherlodeModule;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.CustomLayeredBiomeSource;
import com.mojang.datafixers.util.Pair;

public class MotherlodeWorldType extends GeneratorType {
    public static final CustomLayeredBiomeSource.Preset PRESET = new CustomLayeredBiomeSource.Preset(MotherlodeModule.id("motherlode"), (preset, registry, seed) ->
        new CustomLayeredBiomeSource(seed,
            MotherlodeWorldTypeConfig.MOTHERLODE_WORLD_TYPE_CONFIG,
            registry, Pair.of(registry, preset)));

    public MotherlodeWorldType() {
        super(MotherlodeModule.MODID + ".motherlode");
        GeneratorType.VALUES.add(this);
    }

    @Override
    protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> generatorSettingsRegistry, long seed) {
        return new NoiseChunkGenerator(PRESET.getBiomeSource(biomeRegistry, seed), seed, () -> generatorSettingsRegistry.getOrThrow(ChunkGeneratorSettings.OVERWORLD));
    }
}

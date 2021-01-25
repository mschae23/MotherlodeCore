package motherlode.biomes.world.biome.name;

import net.minecraft.world.biome.layer.util.CoordinateTransformer;

public interface BiomeNameConvertingLayer<T, T2> extends CoordinateTransformer {
    T sample(LayerRandomnessSource random, BiomeNameLayer<T2> parent, int x, int y);
}
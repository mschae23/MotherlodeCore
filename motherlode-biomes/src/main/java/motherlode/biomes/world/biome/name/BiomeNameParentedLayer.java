package motherlode.biomes.world.biome.name;

import net.minecraft.world.biome.layer.util.CoordinateTransformer;

public interface BiomeNameParentedLayer<T> extends CoordinateTransformer {
  T sample(LayerRandomnessSource random, BiomeNameLayer<T> parent, int x, int y);
}

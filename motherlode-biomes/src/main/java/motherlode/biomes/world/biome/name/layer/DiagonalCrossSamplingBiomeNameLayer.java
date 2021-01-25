package motherlode.biomes.world.biome.name.layer;

import net.minecraft.world.biome.layer.util.NorthWestCoordinateTransformer;
import motherlode.biomes.world.biome.name.BiomeNameLayer;
import motherlode.biomes.world.biome.name.BiomeNameParentedLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;

public interface DiagonalCrossSamplingBiomeNameLayer<T> extends BiomeNameParentedLayer<T>, NorthWestCoordinateTransformer {
    T sample(LayerRandomnessSource random, T sw, T se, T ne, T nw, T center);

    @Override
    default T sample(LayerRandomnessSource random, BiomeNameLayer<T> parent, int x, int z) {
        return this.sample(random, parent.sample(random, this.transformX(x), this.transformZ(z + 2)), parent.sample(random, this.transformX(x + 2), this.transformZ(z + 2)), parent.sample(random, this.transformX(x + 2), this.transformZ(z)), parent.sample(random, this.transformX(x), this.transformZ(z)), parent.sample(random, this.transformX(x + 1), this.transformZ(z + 1)));
    }
}

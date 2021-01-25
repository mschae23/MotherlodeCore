package motherlode.biomes.world.biome.name;

import net.minecraft.world.biome.layer.util.IdentityCoordinateTransformer;

public interface IdentityBiomeNameParentedLayer<T> extends BiomeNameParentedLayer<T>, IdentityCoordinateTransformer {
    T sample(LayerRandomnessSource random, T value);

    @Override
    default T sample(LayerRandomnessSource random, BiomeNameLayer<T> parent, int x, int z) {
        return this.sample(random, parent.sample(random, this.transformX(x), this.transformZ(z)));
    }
}

package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.BiomeNameLayer;
import motherlode.biomes.world.biome.name.BiomeNameParentedLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;

public class ScaleLayer<T> implements BiomeNameParentedLayer<T> {
    @Override
    public int transformX(int x) {
        return x >> 1;
    }

    @Override
    public int transformZ(int z) {
        return z >> 1;
    }

    @Override
    public T sample(LayerRandomnessSource random, BiomeNameLayer<T> parent, int x, int z) {
        T i = parent.sample(random, this.transformX(x), this.transformZ(z));
        random.initSeed(x >> 1 << 1, z >> 1 << 1);
        int j = x & 1;
        int k = z & 1;
        if (j == 0 && k == 0) {
            return i;
        } else {
            T l = parent.sample(random, this.transformX(x), this.transformZ(z + 1));
            T m = random.choose(i, l);
            if (j == 0) { // k == 1
                return m;
            } else {
                T n = parent.sample(random, this.transformX(x + 1), this.transformZ(z));
                T o = random.choose(i, n);
                if (k == 0) { // j == 1
                    return o;
                } else {
                    T p = parent.sample(random, this.transformX(x + 1), this.transformZ(z + 1));
                    return this.sample(random, i, n, l, p);
                }
            }
        }
    }

    protected T sample(LayerRandomnessSource random, T i, T j, T k, T l) {
        if (j == k && k == l) {
            return j;
        } else if (i == j && i == k) {
            return i;
        } else if (i == j && i == l) {
            return i;
        } else if (i == k && i == l) {
            return i;
        } else if (i == j && k != l) {
            return i;
        } else if (i == k && j != l) {
            return i;
        } else if (i == l && j != k) {
            return i;
        } else if (j == k && i != l) {
            return j;
        } else if (j == l && i != k) {
            return j;
        } else {
            return k == l && i != j ? k : random.choose(i, j, k, l);
        }
    }

    public static <T> ScaleLayer<T> normal() {
        return new ScaleLayer<>();
    }

    public static <T> ScaleLayer<T> fuzzy() {
        return new ScaleLayer<T>() {
            protected T sample(LayerRandomnessSource random, T i, T j, T k, T l) {
                return random.choose(i, j, k, l);
            }
        };
    }
}

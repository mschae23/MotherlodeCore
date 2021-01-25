package motherlode.biomes.world.biome.name.layer;

import net.minecraft.world.biome.layer.util.IdentityCoordinateTransformer;
import motherlode.biomes.world.biome.name.BiomeNameConvertingLayer;
import motherlode.biomes.world.biome.name.BiomeNameLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;

public enum SimpleNoiseBiomeNameLayer implements BiomeNameConvertingLayer<Integer, ClimateCategory>, IdentityCoordinateTransformer {
    INSTANCE;

    @Override
    public Integer sample(LayerRandomnessSource random, BiomeNameLayer<ClimateCategory> parent, int x, int z) {
        return this.sample(random, parent.sample(random, this.transformX(x), this.transformZ(z)));
    }

    public int sample(LayerRandomnessSource random, ClimateCategory climate) {
        return random.nextInt(299999999) + 2;
    }
}

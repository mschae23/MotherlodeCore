package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;

public enum AddDeepOceanLayer implements CrossSamplingBiomeNameLayer<ClimateCategory> {
    INSTANCE;

    @Override
    public ClimateCategory sample(LayerRandomnessSource random, ClimateCategory n, ClimateCategory e, ClimateCategory s, ClimateCategory w, ClimateCategory center) {
        if (ClimateCategory.isShallowOcean(center)) {
            int i = 0;
            if (ClimateCategory.isShallowOcean(n)) {
                ++i;
            }

            if (ClimateCategory.isShallowOcean(e)) {
                ++i;
            }

            if (ClimateCategory.isShallowOcean(w)) {
                ++i;
            }

            if (ClimateCategory.isShallowOcean(s)) {
                ++i;
            }

            if (i > 3) {
                return ClimateCategory.DEEP_OCEAN;
            }
        }

        return center;
    }
}

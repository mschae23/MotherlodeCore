package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;

public enum IncreaseEdgeCurvatureClimateBiomeNameLayer implements DiagonalCrossSamplingBiomeNameLayer<ClimateCategory> {
    INSTANCE;

    @Override
    public ClimateCategory sample(LayerRandomnessSource random, ClimateCategory sw, ClimateCategory se, ClimateCategory ne, ClimateCategory nw, ClimateCategory center) {
        if (!ClimateCategory.isShallowOcean(center) || ClimateCategory.isShallowOcean(nw) && ClimateCategory.isShallowOcean(ne) && ClimateCategory.isShallowOcean(sw) && ClimateCategory.isShallowOcean(se)) {
            if (!ClimateCategory.isShallowOcean(center) && (ClimateCategory.isShallowOcean(nw) || ClimateCategory.isShallowOcean(sw) || ClimateCategory.isShallowOcean(ne) || ClimateCategory.isShallowOcean(se)) && random.nextInt(5) == 0) {
                if (ClimateCategory.isShallowOcean(nw)) {
                    return center == ClimateCategory.SNOWY ? ClimateCategory.SNOWY : nw;
                }

                if (ClimateCategory.isShallowOcean(sw)) {
                    return center == ClimateCategory.SNOWY ? ClimateCategory.SNOWY : sw;
                }

                if (ClimateCategory.isShallowOcean(ne)) {
                    return center == ClimateCategory.SNOWY ? ClimateCategory.SNOWY : ne;
                }

                if (ClimateCategory.isShallowOcean(se)) {
                    return center == ClimateCategory.SNOWY ? ClimateCategory.SNOWY : se;
                }
            }

            return center;
        } else {
            int i = 1;
            ClimateCategory j = ClimateCategory.DRY;
            if (!ClimateCategory.isShallowOcean(nw) && random.nextInt(i++) == 0) {
                j = nw;
            }

            if (!ClimateCategory.isShallowOcean(ne) && random.nextInt(i++) == 0) {
                j = ne;
            }

            if (!ClimateCategory.isShallowOcean(sw) && random.nextInt(i++) == 0) {
                j = sw;
            }

            if (!ClimateCategory.isShallowOcean(se) && random.nextInt(i++) == 0) {
                j = se;
            }

            if (random.nextInt(3) == 0) {
                return j;
            } else {
                return j == ClimateCategory.SNOWY ? ClimateCategory.SNOWY : center;
            }
        }
    }
}

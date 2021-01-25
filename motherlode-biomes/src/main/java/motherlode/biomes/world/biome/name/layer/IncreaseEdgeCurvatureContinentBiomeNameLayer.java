package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.ContinentCategory;

public enum IncreaseEdgeCurvatureContinentBiomeNameLayer implements DiagonalCrossSamplingBiomeNameLayer<ContinentCategory> {
    INSTANCE;

    @Override
    public ContinentCategory sample(LayerRandomnessSource random, ContinentCategory sw, ContinentCategory se, ContinentCategory ne, ContinentCategory nw, ContinentCategory center) {
        if (!(center == ContinentCategory.OCEAN) || (nw == ContinentCategory.OCEAN) && (ne == ContinentCategory.OCEAN) && (sw == ContinentCategory.OCEAN) && (se == ContinentCategory.OCEAN)) {
            if (!(center == ContinentCategory.OCEAN) && ((nw == ContinentCategory.OCEAN) || (sw == ContinentCategory.OCEAN) || (ne == ContinentCategory.OCEAN) || (se == ContinentCategory.OCEAN)) && random.nextInt(5) == 0) {
                if (nw == ContinentCategory.OCEAN) {
                    return nw;
                }

                if (sw == ContinentCategory.OCEAN) {
                    return sw;
                }

                if (ne == ContinentCategory.OCEAN) {
                    return ne;
                }

                return se;
            }

            return center;
        } else {
            int i = 1;
            ContinentCategory j = ContinentCategory.LAND;
            if (!(nw == ContinentCategory.OCEAN) && random.nextInt(i++) == 0) {
                j = nw;
            }

            if (!(ne == ContinentCategory.OCEAN) && random.nextInt(i++) == 0) {
                j = ne;
            }

            if (!(sw == ContinentCategory.OCEAN) && random.nextInt(i++) == 0) {
                j = sw;
            }

            if (!(se == ContinentCategory.OCEAN) && random.nextInt(i++) == 0) {
                j = se;
            }

            if (random.nextInt(3) == 0) {
                return j;
            } else {
                return center;
            }
        }
    }
}

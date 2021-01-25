package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;

public class AddRareIslandLayer implements DiagonalCrossSamplingBiomeNameLayer<ClimateCategory> {
    private final int chance;

    public AddRareIslandLayer(int chance) {
        this.chance = chance;
    }

    @Override
    public ClimateCategory sample(LayerRandomnessSource random, ClimateCategory sw, ClimateCategory se, ClimateCategory ne, ClimateCategory nw, ClimateCategory center) {
        return ClimateCategory.isShallowOcean(center) && ClimateCategory.isShallowOcean(nw) && ClimateCategory.isShallowOcean(sw) && ClimateCategory.isShallowOcean(ne) && ClimateCategory.isShallowOcean(se) && random.nextInt(this.chance) == 0 ? ClimateCategory.RARE_ISLAND : center;
    }
}

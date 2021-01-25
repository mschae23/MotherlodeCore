package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.ContinentCategory;

public class AddIslandLayer implements CrossSamplingBiomeNameLayer<ContinentCategory> {
    private final int islandChance;

    public AddIslandLayer(int islandChance) {
        this.islandChance = islandChance;
    }

    @Override
    public ContinentCategory sample(LayerRandomnessSource random, ContinentCategory n, ContinentCategory e, ContinentCategory s, ContinentCategory w, ContinentCategory center) {
        return center == ContinentCategory.OCEAN && n == ContinentCategory.OCEAN && e == ContinentCategory.OCEAN && w == ContinentCategory.OCEAN && s == ContinentCategory.OCEAN && random.nextInt(this.islandChance) == 0 ? ContinentCategory.LAND : center;
    }
}

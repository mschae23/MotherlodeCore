package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.BiomeNameLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.ContinentCategory;

public class ContinentBiomeNameLayer implements BiomeNameLayer<ContinentCategory> {
    private final int continentChance;
    private final boolean originContinent;

    public ContinentBiomeNameLayer(int continentChance, boolean originContinent) {
        this.continentChance = continentChance;
        this.originContinent = originContinent;
    }

    @Override
    public ContinentCategory sample(LayerRandomnessSource random, int x, int y) {
        if (this.originContinent && x == 0 && y == 0) {
            return ContinentCategory.LAND;
        } else {
            return random.nextInt(this.continentChance) == 0 ? ContinentCategory.LAND : ContinentCategory.OCEAN;
        }
    }
}

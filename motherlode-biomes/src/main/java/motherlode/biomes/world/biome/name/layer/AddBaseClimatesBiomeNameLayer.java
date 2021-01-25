package motherlode.biomes.world.biome.name.layer;

import net.minecraft.world.biome.layer.util.NorthWestCoordinateTransformer;
import motherlode.biomes.world.biome.name.BiomeNameConvertingLayer;
import motherlode.biomes.world.biome.name.BiomeNameLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.ContinentCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.ClimateConfig;

public class AddBaseClimatesBiomeNameLayer implements BiomeNameConvertingLayer<ClimateCategory, ContinentCategory>, NorthWestCoordinateTransformer {
    private final ClimateConfig config;

    public AddBaseClimatesBiomeNameLayer(ClimateConfig config) {
        this.config = config;
    }

    public ClimateCategory sample(LayerRandomnessSource random, ContinentCategory se) {
        if (se == ContinentCategory.OCEAN) {
            return ClimateCategory.OCEAN;
        } else {
            int i = random.nextInt(this.config.getWeightSum());
            if (i < this.config.getSnowyClimateWeight()) {
                return ClimateCategory.SNOWY;
            } else {
                return i < this.config.getSnowyClimateWeight() + this.config.getCoolClimateWeight() ?
                    ClimateCategory.COOL : ClimateCategory.DRY;
            }
        }
    }

    @Override
    public ClimateCategory sample(LayerRandomnessSource random, BiomeNameLayer<ContinentCategory> parent, int x, int z) {
        ContinentCategory i = parent.sample(random, this.transformX(x + 1), this.transformZ(z + 1));
        return this.sample(random, i);
    }
}

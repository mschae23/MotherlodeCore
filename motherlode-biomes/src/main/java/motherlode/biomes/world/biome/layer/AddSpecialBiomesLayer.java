package motherlode.biomes.world.biome.layer;

import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.layer.type.IdentitySamplingLayer;

public class AddSpecialBiomesLayer implements IdentitySamplingLayer<ClimateCategory> {
    private final int chance;

    public AddSpecialBiomesLayer(int chance) {
        this.chance = chance;
    }

    @Override
    public ClimateCategory sample(LayerRandomnessSource context, ClimateCategory value) {
        if (!ClimateCategory.isShallowOcean(value) && context.nextInt(this.chance) == 0) {
            switch (value) {
                case DRY:
                    return ClimateCategory.SPECIAL_DRY;
                case TEMPERATE:
                    return ClimateCategory.SPECIAL_TEMPERATE;
                case COOL:
                    return ClimateCategory.SPECIAL_COOL;
                case SNOWY:
                    return ClimateCategory.SPECIAL_SNOWY;
                default:
                    // Fall through
            }
        }

        return value;
    }
}

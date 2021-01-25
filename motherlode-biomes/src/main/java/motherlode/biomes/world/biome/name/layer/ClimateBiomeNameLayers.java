package motherlode.biomes.world.biome.name.layer;

import motherlode.biomes.world.biome.name.IdentityBiomeNameParentedLayer;
import motherlode.biomes.world.biome.name.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.category.vanilla.ClimateCategory;

public final class ClimateBiomeNameLayers {
    private ClimateBiomeNameLayers() {
    }

    public enum AddSpecialBiomesLayer implements IdentityBiomeNameParentedLayer<ClimateCategory> {
        INSTANCE;

        @Override
        public ClimateCategory sample(LayerRandomnessSource random, ClimateCategory value) {
            if (!ClimateCategory.isShallowOcean(value) && random.nextInt(13) == 0) {
                switch (value) {
                    case DRY:
                        return ClimateCategory.SPECIAL_DRY;
                    case TEMPERATE:
                        return ClimateCategory.SPECIAL_TEMPERATE;
                    case COOL:
                        return ClimateCategory.SPECIAL_COOL;
                    case SNOWY:
                        return ClimateCategory.SPECIAL_SNOWY;
                }
            }

            return value;
        }
    }

    public enum AddCoolBiomesLayer implements CrossSamplingBiomeNameLayer<ClimateCategory> {
        INSTANCE;

        @Override
        public ClimateCategory sample(LayerRandomnessSource context, ClimateCategory n, ClimateCategory e, ClimateCategory s, ClimateCategory w, ClimateCategory center) {
            return center != ClimateCategory.SNOWY
                || n != ClimateCategory.DRY
                && e != ClimateCategory.DRY
                && w != ClimateCategory.DRY
                && s != ClimateCategory.DRY
                && n != ClimateCategory.TEMPERATE
                && e != ClimateCategory.TEMPERATE
                && w != ClimateCategory.TEMPERATE
                && s != ClimateCategory.TEMPERATE ? center : ClimateCategory.COOL;
        }
    }

    public enum AddTemperateBiomesLayer implements CrossSamplingBiomeNameLayer<ClimateCategory> {
        INSTANCE;

        @Override
        public ClimateCategory sample(LayerRandomnessSource context, ClimateCategory n, ClimateCategory e, ClimateCategory s, ClimateCategory w, ClimateCategory center) {
            return center != ClimateCategory.DRY
                || n != ClimateCategory.COOL
                && e != ClimateCategory.COOL
                && w != ClimateCategory.COOL
                && s != ClimateCategory.COOL
                && n != ClimateCategory.SNOWY
                && e != ClimateCategory.SNOWY
                && w != ClimateCategory.SNOWY
                && s != ClimateCategory.SNOWY ? center : ClimateCategory.TEMPERATE;
        }
    }
}

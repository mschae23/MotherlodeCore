package motherlode.biomes.world.biome.layer.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class ClimateConfig {
    public static final Codec<ClimateConfig> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.INT.fieldOf("snowy_climate_weight").forGetter(ClimateConfig::getSnowyClimateWeight),
            Codec.INT.fieldOf("cool_climate_weight").forGetter(ClimateConfig::getCoolClimateWeight),
            Codec.INT.fieldOf("dry_climate_weight").forGetter(ClimateConfig::getDryClimateWeight),

            Codec.INT.fieldOf("special_biome_chance").forGetter(ClimateConfig::getSpecialBiomeChance),

            Codec.INT.fieldOf("climate_size").forGetter(ClimateConfig::getClimateSize),
            Codec.INT.fieldOf("rare_island_chance").forGetter(ClimateConfig::getRareIslandChance)
        ).apply(instance, instance.stable(ClimateConfig::new))
    );

    private final int snowyClimateWeight;
    private final int coolClimateWeight;
    private final int dryClimateWeight;

    private final int specialBiomeChance;

    private final int climateSize;
    private final int rareIslandChance;

    public ClimateConfig(int snowyClimateWeight, int coolClimateWeight, int dryClimateWeight, int specialBiomeChance, int climateSize, int rareIslandChance) {
        this.snowyClimateWeight = snowyClimateWeight;
        this.coolClimateWeight = coolClimateWeight;
        this.dryClimateWeight = dryClimateWeight;
        this.specialBiomeChance = specialBiomeChance;
        this.climateSize = climateSize;
        this.rareIslandChance = rareIslandChance;
    }

    public int getSnowyClimateWeight() {
        return this.snowyClimateWeight;
    }

    public int getCoolClimateWeight() {
        return this.coolClimateWeight;
    }

    public int getDryClimateWeight() {
        return this.dryClimateWeight;
    }

    public int getWeightSum() {
        return this.snowyClimateWeight + this.coolClimateWeight + dryClimateWeight;
    }

    public int getSpecialBiomeChance() {
        return this.specialBiomeChance;
    }

    public int getClimateSize() {
        return this.climateSize;
    }

    public int getRareIslandChance() {
        return this.rareIslandChance;
    }
}

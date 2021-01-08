package motherlode.biomes.world.biome.layer.config;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.BiomeCategory;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.HillBiomesConfig.ComplexHillBiomeEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.HillBiomesConfig.HillBiomeEntry;
import de.martenschaefer.morecustomworldgen.customlayeredbiomesource.biomesource.config.HillBiomesConfig.SpecialHillBiomeEntry;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class HillBiomesConfig {
    public static final Codec<HillBiomesConfig> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.STRING.listOf().fieldOf("ignored_categories").forGetter(HillBiomesConfig::getIgnoredCategories),
            Codec.INT.fieldOf("special_biome_chance").forGetter(HillBiomesConfig::getSpecialBiomeChance),
            SpecialHillBiomeEntry.CODEC.listOf().fieldOf("special_hill_biomes").forGetter(HillBiomesConfig::getSpecialHillBiomes),
            HillBiomeEntry.CODEC.listOf().fieldOf("hill_biomes").forGetter(HillBiomesConfig::getHillBiomes),
            ComplexHillBiomeEntry.CODEC.listOf().fieldOf("complex_hill_biomes").forGetter(HillBiomesConfig::getComplexHillBiomes)
        ).apply(instance, instance.stable(HillBiomesConfig::new))
    );

    private final List<String> ignoredCategories;
    private final int specialBiomeChance;
    private final List<SpecialHillBiomeEntry> specialHillBiomes;
    private final List<HillBiomeEntry> hillBiomes;
    private final List<ComplexHillBiomeEntry> complexHillBiomes;

    public HillBiomesConfig(List<String> ignoredCategories, int specialBiomeChance, List<SpecialHillBiomeEntry> specialHillBiomes, List<HillBiomeEntry> hillBiomes, List<ComplexHillBiomeEntry> complexHillBiomes) {
        this.ignoredCategories = ignoredCategories;
        this.specialBiomeChance = specialBiomeChance;
        this.specialHillBiomes = specialHillBiomes;
        this.hillBiomes = hillBiomes;
        this.complexHillBiomes = complexHillBiomes;
    }

    public List<String> getIgnoredCategories() {
        return this.ignoredCategories;
    }

    public int getSpecialBiomeChance() {
        return this.specialBiomeChance;
    }

    public List<SpecialHillBiomeEntry> getSpecialHillBiomes() {
        return this.specialHillBiomes;
    }

    public List<HillBiomeEntry> getHillBiomes() {
        return this.hillBiomes;
    }

    public List<ComplexHillBiomeEntry> getComplexHillBiomes() {
        return this.complexHillBiomes;
    }

    public RegistryKey<Biome> getSpecialHillBiome(RegistryKey<Biome> biome) {
        return this.getSpecialHillBiomes().stream()
            .filter(entry -> biome.getValue().equals(entry.getBiome().getValue()))
            .map(SpecialHillBiomeEntry::getSpecialHillBiome)
            .findAny()
            .orElse(biome);
    }

    public RegistryKey<Biome> getSpecialHillBiome(RegistryKey<Biome> biome, RegistryKey<Biome> defaultBiome) {
        return this.getSpecialHillBiomes().stream()
            .filter(entry -> biome.getValue().equals(entry.getBiome().getValue()))
            .map(SpecialHillBiomeEntry::getSpecialHillBiome)
            .findAny()
            .orElse(defaultBiome);
    }

    public RegistryKey<Biome> getHillBiome(LayerRandomnessSource context, List<BiomeCategory> categories, RegistryKey<Biome> biome) {
        return this.getHillBiomes().stream()
            .filter(entry ->
                entry.getBiome() != null ? biome.getValue().equals(entry.getBiome().getValue()) :
                    entry.getCategory() != null && entry.getCategory().equals(BiomeCategory.getCategory(categories, biome)))
            .map(HillBiomeEntry::getHillBiome)
            .findAny()
            .orElseGet(() -> getComplexHillBiome(context, biome));
    }

    public RegistryKey<Biome> getComplexHillBiome(LayerRandomnessSource context, RegistryKey<Biome> biome) {
        List<RegistryKey<Biome>> hillBiomes = this.getComplexHillBiomes().stream()
            .filter(entry -> contains(entry.getBiomes(), biome))
            .flatMap(entry -> entry.getHillBiomes().stream())
            .collect(Collectors.toList());

        if (hillBiomes.size() == 0) return biome;
        if (hillBiomes.size() == 1) return hillBiomes.get(0);

        return hillBiomes.get(context.nextInt(hillBiomes.size()));
    }

    public List<Supplier<Biome>> getBiomes(Registry<Biome> biomeRegistry) {
        List<Supplier<Biome>> specialHillBiomes = this.getSpecialHillBiomes().stream()
            .map(SpecialHillBiomeEntry::getSpecialHillBiome)
            .<Supplier<Biome>>map(hillBiome -> () -> biomeRegistry.getOrThrow(hillBiome))
            .collect(Collectors.toList());

        List<Supplier<Biome>> hillBiomes = this.getHillBiomes().stream()
            .map(HillBiomeEntry::getHillBiome)
            .<Supplier<Biome>>map(hillBiome -> () -> biomeRegistry.getOrThrow(hillBiome))
            .collect(Collectors.toList());

        List<Supplier<Biome>> complexHillBiomes = this.getComplexHillBiomes().stream()
            .flatMap(entry -> entry.getHillBiomes().stream())
            .<Supplier<Biome>>map(hillBiome -> () -> biomeRegistry.getOrThrow(hillBiome))
            .collect(Collectors.toList());

        hillBiomes.addAll(specialHillBiomes);
        hillBiomes.addAll(complexHillBiomes);

        return hillBiomes;
    }

    private static boolean contains(List<RegistryKey<Biome>> biomes, RegistryKey<Biome> biome) {
        for (RegistryKey<Biome> element : biomes) {
            if (biome.getValue().equals(element.getValue()))
                return true;
        }

        return false;
    }
}

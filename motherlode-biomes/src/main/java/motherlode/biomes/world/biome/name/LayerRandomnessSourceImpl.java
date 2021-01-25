package motherlode.biomes.world.biome.name;

import net.minecraft.world.biome.source.SeedMixer;

public class LayerRandomnessSourceImpl implements LayerRandomnessSource {
    private final long originalSeed;
    private final long worldSeed;
    private long localSeed;

    public LayerRandomnessSourceImpl(long seed, long salt) {
        this.worldSeed = addSalt(seed, salt);
        this.originalSeed = seed;
    }

    public LayerRandomnessSourceImpl(long seed) {
        this.worldSeed = seed;
        this.originalSeed = seed;
    }

    @Override
    public void initSeed(long x, long y) {
        long l = this.worldSeed;
        l = SeedMixer.mixSeed(l, x);
        l = SeedMixer.mixSeed(l, y);
        l = SeedMixer.mixSeed(l, x);
        l = SeedMixer.mixSeed(l, y);
        this.localSeed = l;
    }

    @Override
    public int nextInt(int bound) {
        int i = (int) Math.floorMod(this.localSeed >> 24, bound);
        this.localSeed = SeedMixer.mixSeed(this.localSeed, this.worldSeed);
        return i;
    }

    @Override
    public LayerRandomnessSource withSalt(long salt) {
        return new LayerRandomnessSourceImpl(this.originalSeed, salt);
    }

    private static long addSalt(long seed, long salt) {
        long l = SeedMixer.mixSeed(salt, salt);
        l = SeedMixer.mixSeed(l, salt);
        l = SeedMixer.mixSeed(l, salt);
        long m = SeedMixer.mixSeed(seed, l);
        m = SeedMixer.mixSeed(m, l);
        m = SeedMixer.mixSeed(m, l);
        return m;
    }
}

package motherlode.biomes.world.biome.name;

public interface LayerRandomnessSource {
  int nextInt(int bound);
  LayerRandomnessSource withSalt(long salt);
  void initSeed(long var1, long var3);

  default <T> T choose(T a, T b) {
    return this.nextInt(2) == 0 ? a : b;
  }

  default <T> T choose(T a, T b, T c, T d) {
    int i = this.nextInt(4);
    if (i == 0) {
      return a;
    } else if (i == 1) {
      return b;
    } else {
      return i == 2 ? c : d;
    }
  }
}

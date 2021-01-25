package motherlode.biomes.world.biome.name;

@FunctionalInterface
public interface BiomeNameLayer<T> {
  T sample(LayerRandomnessSource random, int x, int y);

  default BiomeNameLayer<T> andThen(BiomeNameParentedLayer<T> child, long salt) {
    return (random, x, y) -> child.sample(random.withSalt(salt), (random2, x2, y2) -> this.sample(random, x2, y2), x, y);
  }

  default <T2> BiomeNameLayer<T2> convert(BiomeNameConvertingLayer<T2, T> child, long salt) {
    return (random, x, y) -> child.sample(random.withSalt(salt), (random2, x2, y2) -> this.sample(random, x2, y2), x, y);
  }

  default BiomeNameLayer<T> withSalt(long salt) {
    return (random, x, y) -> this.sample(random.withSalt(salt), x, y);
  }
}

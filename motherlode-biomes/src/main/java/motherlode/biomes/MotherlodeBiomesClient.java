package motherlode.biomes;

import net.minecraft.client.color.world.BiomeColors;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import motherlode.biomes.world.biome.worldtype.MotherlodeWorldType;

public class MotherlodeBiomesClient implements ClientModInitializer {
    public static MotherlodeWorldType MOTHERLODE_WORLD_TYPE;

    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
            BiomeColors.getGrassColor(world, pos), MotherlodeBiomesBlocks.WATERPLANT);

        MOTHERLODE_WORLD_TYPE = new MotherlodeWorldType();
    }
}

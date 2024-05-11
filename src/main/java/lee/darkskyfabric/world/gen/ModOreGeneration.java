package lee.darkskyfabric.world.gen;

import lee.darkskyfabric.world.SkyPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public enum ModOreGeneration {
    ;

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, SkyPlacedFeatures.DARKORE_PLACED);

    }
}

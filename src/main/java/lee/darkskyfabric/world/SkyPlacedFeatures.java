package lee.darkskyfabric.world;


import lee.darkskyfabric.DarkSkyFabric;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public enum SkyPlacedFeatures {
    ;
    public static final RegistryKey<PlacedFeature> DARKORE_PLACED= SkyPlacedFeatures.registerKey("darkore_placed");

    public static void boostrap(final Registerable<PlacedFeature> context) {
        final var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        SkyPlacedFeatures.register(context, configuredFeatureRegistryEntryLookup.getOrThrow(SkyConfiguredFeatures.DARKORE_KEY),
                SkyOrePlacement.modifiersWithCount(2, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(20))));

    }

    public static RegistryKey<PlacedFeature> registerKey(final String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(DarkSkyFabric.MOD_ID, name));
    }

    private static void register(final Registerable<PlacedFeature> context, final RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 final List<PlacementModifier> modifiers) {
        context.register(DARKORE_PLACED, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

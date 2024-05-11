package lee.darkskyfabric.world;

import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public enum SkyOrePlacement {
    ;

    public static List<PlacementModifier> modifiers(final PlacementModifier countModifier, final PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(final int count, final PlacementModifier heightModifier) {
        return SkyOrePlacement.modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}

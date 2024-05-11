package lee.darkskyfabric.item;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class BasicShovel extends ShovelItem {
    public BasicShovel(final ToolMaterial toolMaterial, final Settings settings) {
        super(toolMaterial, settings.attributeModifiers(createAttributeModifiers(toolMaterial, 14, 0.0f)));

    }
}

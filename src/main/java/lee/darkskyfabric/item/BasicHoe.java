package lee.darkskyfabric.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class BasicHoe extends HoeItem {
    public BasicHoe(final ToolMaterial toolMaterial, final Settings settings) {
        super(toolMaterial, settings.attributeModifiers(createAttributeModifiers(toolMaterial, 14, 0.0f)));
    }
}

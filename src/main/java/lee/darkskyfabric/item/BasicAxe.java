package lee.darkskyfabric.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class BasicAxe extends AxeItem {
    public BasicAxe(final ToolMaterial toolMaterial, final Settings settings) {
        super(toolMaterial, settings.attributeModifiers(createAttributeModifiers(toolMaterial, 54, 2.0f)));

    }
}

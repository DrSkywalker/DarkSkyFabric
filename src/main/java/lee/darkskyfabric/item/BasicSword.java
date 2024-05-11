package lee.darkskyfabric.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BasicSword extends SwordItem {
    public BasicSword(final ToolMaterial toolMaterial, final Settings settings) {
        super(toolMaterial, settings.attributeModifiers(SwordItem.createAttributeModifiers(toolMaterial, 79, 8.0f)));
    }
}

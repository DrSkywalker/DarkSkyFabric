package lee.darkskyfabric.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BasicPickaxe extends PickaxeItem {
    public BasicPickaxe(final ToolMaterial material, final Settings settings) {
        super(material, settings.attributeModifiers(createAttributeModifiers(material, 14, 0.0f)));
    }
}

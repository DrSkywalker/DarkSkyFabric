package lee.darkskyfabric.item;


import lee.darkskyfabric.DarkSkyFabric;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum DarkItems {;
    // Items
    public static final Item DARKCHARM = DarkItems.registerItem("darkcharm", new Item(new Item.Settings()));
    // Tools
    public static final Item DARK_PICKAXE = DarkItems.registerItem("darkpickaxe", new BasicPickaxe(DarkToolMaterial.DARK, new Item.Settings()));
    public static final Item DARK_AXE = DarkItems.registerItem("darkaxe", new BasicAxe(DarkToolMaterial.DARK, new Item.Settings()));
    public static final Item DARK_SHOVEL = DarkItems.registerItem("darkshovel", new BasicShovel(DarkToolMaterial.DARK, new Item.Settings()));
    public static final Item DARK_SWORD = DarkItems.registerItem("darksword", new BasicSword(DarkToolMaterial.DARK, new Item.Settings()));
    public static final Item DARK_HOE = DarkItems.registerItem("darkhoe", new BasicHoe(DarkToolMaterial.DARK, new Item.Settings()));

    private static void addItemsToIngredientItemGroup(final FabricItemGroupEntries entries) {
        entries.add(DarkItems.DARKCHARM);
    }

    private static Item registerItem(final String name, final Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DarkSkyFabric.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DarkSkyFabric.LOGGER.info( "Registering Dark Items" + DarkSkyFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(DarkItems::addItemsToIngredientItemGroup);
    }

}

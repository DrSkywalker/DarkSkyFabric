package lee.darkskyfabric.item;

import lee.darkskyfabric.DarkSkyFabric;
import lee.darkskyfabric.block.DarkSkyBlock;
import lee.darkskyfabric.DarkSkyFabric;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public enum DarkSkyGroup
{
    ;
    public static final ItemGroup DARK_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier("darkskyfabric", "darkfabric_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.darkfabricgroup"))
                    .icon(() -> new ItemStack(DarkItems.DARKCHARM)).entries((displayContext, entries) -> {
                        entries.add(DarkItems.DARKCHARM);
                        entries.add(DarkSkyBlock.DARKORE);
                        entries.add(DarkSkyBlock.DARKBLOCK);
                        entries.add(DarkItems.DARK_PICKAXE);
                        entries.add(DarkItems.DARK_AXE);
                        entries.add(DarkItems.DARK_SHOVEL);
                        entries.add(DarkItems.DARK_SWORD);
                        entries.add(DarkItems.DARK_HOE);
                    }).build());

    public static void registerItemGroups(){
        DarkSkyFabric.LOGGER.info( "Registering Dark Item Groups" + DarkSkyFabric.MOD_ID);
    }
}

package lee.darkskyfabric.datagen;


import lee.darkskyfabric.block.DarkSkyBlock;
import lee.darkskyfabric.item.DarkItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(DarkSkyBlock.DARKORE);
        blockStateModelGenerator.registerSimpleCubeAll(DarkSkyBlock.DARKBLOCK);
    }

    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DarkItems.DARKCHARM, Models.GENERATED);
        itemModelGenerator.register(DarkItems.DARK_AXE, Models.HANDHELD);
        itemModelGenerator.register(DarkItems.DARK_HOE, Models.HANDHELD);
        itemModelGenerator.register(DarkItems.DARK_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(DarkItems.DARK_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(DarkItems.DARK_SWORD, Models.HANDHELD);
    }
}

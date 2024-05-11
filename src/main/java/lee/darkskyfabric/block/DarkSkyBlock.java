package lee.darkskyfabric.block;

import lee.darkskyfabric.DarkSkyFabric;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public enum DarkSkyBlock {
    ;
    public static final Block DARKORE = DarkSkyBlock.registerBlock("darkore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.create().strength(2.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block DARKBLOCK = DarkSkyBlock.registerBlock("darkblock",new Block(AbstractBlock.Settings.create().strength(3.0f).sounds(BlockSoundGroup.STONE).requiresTool()));

    private static Block registerBlock(final String name, final Block block) {
        DarkSkyBlock.registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DarkSkyFabric.MOD_ID, name), block);
    }

    private static Item registerBlockItem(final String name, final Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DarkSkyFabric.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DarkSkyFabric.LOGGER.info("Registering ModBlocks for " + DarkSkyFabric.MOD_ID);
    }
}

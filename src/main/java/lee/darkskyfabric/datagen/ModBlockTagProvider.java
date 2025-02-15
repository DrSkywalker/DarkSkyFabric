package lee.darkskyfabric.datagen;

import lee.darkskyfabric.block.DarkSkyBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(DarkSkyBlock.DARKBLOCK)
                .add(DarkSkyBlock.DARKORE);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                ;

        this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                ;

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(DarkSkyBlock.DARKBLOCK)
                .add(DarkSkyBlock.DARKORE);

        this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                ;
    }
}

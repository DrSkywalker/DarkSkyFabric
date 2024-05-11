package lee.darkskyfabric.datagen;

import lee.darkskyfabric.item.DarkItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {
        this.getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(DarkItems.DARK_AXE)
                .add(DarkItems.DARK_PICKAXE)
                .add(DarkItems.DARK_HOE)
                .add(DarkItems.DARK_SHOVEL);
        this.getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(DarkItems.DARK_AXE)
                .add(DarkItems.DARK_PICKAXE)
                .add(DarkItems.DARK_HOE)
                .add(DarkItems.DARK_SHOVEL);
        this.getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(DarkItems.DARK_AXE)
                .add(DarkItems.DARK_PICKAXE)
                .add(DarkItems.DARK_HOE)
                .add(DarkItems.DARK_SHOVEL)
                .add(DarkItems.DARK_SWORD);
        this.getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(DarkItems.DARK_SWORD);
        this.getOrCreateTagBuilder(ItemTags.AXES)
                .add(DarkItems.DARK_AXE);
        this.getOrCreateTagBuilder(ItemTags.HOES)
                .add(DarkItems.DARK_HOE);
        this.getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(DarkItems.DARK_PICKAXE);
        this.getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(DarkItems.DARK_SHOVEL);
        this.getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(DarkItems.DARK_AXE)
                .add(DarkItems.DARK_SWORD);
        this.getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(DarkItems.DARK_SWORD);
        this.getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(DarkItems.DARK_AXE)
                .add(DarkItems.DARK_SWORD);
    }

}

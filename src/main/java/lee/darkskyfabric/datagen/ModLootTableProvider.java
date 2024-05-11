package lee.darkskyfabric.datagen;

import lee.darkskyfabric.block.DarkSkyBlock;
import lee.darkskyfabric.item.DarkItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(final FabricDataOutput dataOutput, final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.addDrop(DarkSkyBlock.DARKORE, this.drops(DarkItems.DARKCHARM));
        this.addDrop(DarkSkyBlock.DARKBLOCK, this.drops(DarkSkyBlock.DARKBLOCK));

    }

}

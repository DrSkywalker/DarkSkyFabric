package lee.darkskyfabric.datagen;

import lee.darkskyfabric.block.DarkSkyBlock;
import lee.darkskyfabric.item.DarkItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(final RecipeExporter exporter) {
        //Dark Charm

        //Dark Block Inverse
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, DarkItems.DARKCHARM, RecipeCategory.DECORATIONS, DarkSkyBlock.DARKBLOCK);
        //Pickaxe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, DarkItems.DARK_PICKAXE, 1)
                .pattern("DDD")
                .pattern(" I ")
                .pattern(" I ")
                .input('D', DarkItems.DARKCHARM)
                .input('I', Items.STICK)
                .criterion(hasItem(DarkItems.DARKCHARM), conditionsFromItem(DarkItems.DARKCHARM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(DarkItems.DARK_PICKAXE)));
        //Axe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, DarkItems.DARK_AXE, 1)
                .pattern("DD ")
                .pattern("DI ")
                .pattern(" I ")
                .input('D', DarkItems.DARKCHARM)
                .input('I', Items.STICK)
                .criterion(hasItem(DarkItems.DARKCHARM), conditionsFromItem(DarkItems.DARKCHARM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(DarkItems.DARK_AXE)));
        //Shovel
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, DarkItems.DARK_SHOVEL, 1)
                .pattern(" D ")
                .pattern(" I ")
                .pattern(" I ")
                .input('D', DarkItems.DARKCHARM)
                .input('I', Items.STICK)
                .criterion(hasItem(DarkItems.DARKCHARM), conditionsFromItem(DarkItems.DARKCHARM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(DarkItems.DARK_SHOVEL)));
        //Sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, DarkItems.DARK_SWORD, 1)
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" I ")
                .input('D', DarkItems.DARKCHARM)
                .input('I', Items.STICK)
                .criterion(hasItem(DarkItems.DARKCHARM), conditionsFromItem(DarkItems.DARKCHARM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(DarkItems.DARK_SWORD)));
        //Hoe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, DarkItems.DARK_HOE, 1)
                .pattern("DD ")
                .pattern(" I ")
                .pattern(" I ")
                .input('D', DarkItems.DARKCHARM)
                .input('I', Items.STICK)
                .criterion(hasItem(DarkItems.DARKCHARM), conditionsFromItem(DarkItems.DARKCHARM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(DarkItems.DARK_HOE)));

    }
}

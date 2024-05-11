package lee.darkskyfabric;

import lee.darkskyfabric.block.DarkSkyBlock;
import lee.darkskyfabric.datagen.*;
import lee.darkskyfabric.item.DarkItems;
import lee.darkskyfabric.world.SkyConfiguredFeatures;
import lee.darkskyfabric.world.SkyPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.ImpossibleCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class DarkSkyFabricDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
		final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModWorldGen::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModAdvancementsProvider::new);
	}

	@Override
	public void buildRegistry(final RegistryBuilder registryBuilder){
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, SkyConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, SkyPlacedFeatures::boostrap);
	}

	static class ModAdvancementsProvider extends FabricAdvancementProvider {
		protected ModAdvancementsProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(output, registryLookup);

        }

		@Override
		public void generateAdvancement(final RegistryWrapper.WrapperLookup registryLookup, final Consumer<AdvancementEntry> consumer) {
			//Beginning Advancement
			final AdvancementEntry rootAdvancement = Advancement.Builder.create()
					.display(
							DarkItems.DARKCHARM, // The display icon
							Text.literal("The Dark Sky"), // The title
							Text.literal("The Journey Through The Darkness Begins"), // The description
							new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
							AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("darksky_table", Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions()))
					.build(consumer, "darksky" + "/root");

			final AdvancementEntry surrondDarkness = Advancement.Builder.create().parent(rootAdvancement)
					.display(
							DarkSkyBlock.DARKBLOCK,
							Text.literal("Where Am I?"), // The title
							Text.literal("The Darkness Consumes All."), // The description
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("dark_lost", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
					.build(consumer, "darksky" + "/whereami");

			final AdvancementEntry endlessNights = Advancement.Builder.create().parent(surrondDarkness)
					.display(
							Items.TORCH,
							Text.literal("Nice Try"), // The title
							Text.literal("Try Sleeping Through The Endless Night!"), // The description
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("dark_bed", TickCriterion.Conditions.createSleptInBed())
					.build(consumer, "darksky" + "/slept");

			final AdvancementEntry charmCollect = Advancement.Builder.create().parent(endlessNights)
					.display(
							DarkSkyBlock.DARKORE,
							Text.literal("First Dark Charm!"), // The title
							Text.literal("Found Your First Dark Charm!"), // The description
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("dark_collect", InventoryChangedCriterion.Conditions.items(DarkItems.DARKCHARM))
					.build(consumer, "darksky" + "/collectedcharm");

			final AdvancementEntry collectedTools = Advancement.Builder.create().parent(charmCollect)
					.display(
							DarkItems.DARK_PICKAXE,
							Text.literal("I'M Untouchable"), // The title
							Text.literal("Collected And Crafted All Dark Sky Tools"), // The description
							null, // children to parent advancements don't need a background set
							AdvancementFrame.CHALLENGE,
							true,
							true,
							false
					)
					.criterion("dark_tools5", InventoryChangedCriterion.Conditions.items(DarkItems.DARK_AXE))
					.criterion("dark_tools4", InventoryChangedCriterion.Conditions.items(DarkItems.DARK_HOE))
					.criterion("dark_tools3", InventoryChangedCriterion.Conditions.items(DarkItems.DARK_PICKAXE))
					.criterion("dark_tools2", InventoryChangedCriterion.Conditions.items(DarkItems.DARK_SHOVEL))
					.criterion("dark_tools1", InventoryChangedCriterion.Conditions.items(DarkItems.DARK_SWORD))
					.build(consumer, "darksky" + "/collectedtools");

			final AdvancementEntry endMaybe = Advancement.Builder.create().parent(collectedTools)
					.display(
							DarkItems.DARK_SWORD,
							Text.literal("IS THAT ALL?"), // The title
							Text.literal("More Content Coming Soon!"), // The description
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("dark_end_adv", Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions()))
					.build(consumer, "darksky" + "/skyend");
		}
		}
}
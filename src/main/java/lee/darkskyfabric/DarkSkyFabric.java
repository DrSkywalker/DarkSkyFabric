package lee.darkskyfabric;

import lee.darkskyfabric.block.DarkSkyBlock;
import lee.darkskyfabric.integrations.Config;
import lee.darkskyfabric.item.DarkItems;
import lee.darkskyfabric.item.DarkSkyGroup;
import lee.darkskyfabric.util.AdvancementGrantUtil;
import lee.darkskyfabric.util.SpawnModify;
import lee.darkskyfabric.util.UnloadWorld;
import lee.darkskyfabric.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DarkSkyFabric implements ModInitializer {
	//Mod Setup
	public static final String MOD_ID = "darkskyfabric";
	public static final Logger LOGGER = LoggerFactory.getLogger(DarkSkyFabric.MOD_ID);
	//Initalizer
	@Override
	public void onInitialize() {
		// Load the configuration first
		Config.load();
		// Register items, blocks, and item groups
		DarkItems.registerModItems();
		DarkSkyGroup.registerItemGroups();
		DarkSkyBlock.registerModBlocks();
		// Register world generation
		ModWorldGeneration.generateModWorldGen();
		// Register the advancement listener
		AdvancementListener.register();
		//Advancement
		AdvancementGrantUtil.registerAdvancementGrantEvent();
		// Register world events
		ServerWorldEvents.LOAD.register(new SpawnModify());
		ServerWorldEvents.UNLOAD.register(new UnloadWorld());

	}

}
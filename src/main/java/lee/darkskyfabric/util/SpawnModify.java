package lee.darkskyfabric.util;

import lee.darkskyfabric.integrations.Config;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.TimeCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;

public class SpawnModify implements  ServerWorldEvents.Load {
    public static boolean hasExecuted;
    @Override
    public void onWorldLoad(final MinecraftServer server, final ServerWorld world) {
        if(SpawnModify.hasExecuted){return;}
        if(Config.disable)
        {
            final ServerCommandSource commandSource = server.getCommandSource();
            TimeCommand.executeSet(commandSource, 18000);
            final GameRules rules = server.getGameRules();
            rules.get(GameRules.DO_DAYLIGHT_CYCLE).set(false, server);
        }
        SpawnModify.hasExecuted = true;
    }

}

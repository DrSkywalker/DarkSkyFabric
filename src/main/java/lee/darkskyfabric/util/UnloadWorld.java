package lee.darkskyfabric.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

public class UnloadWorld implements ServerWorldEvents.Unload{
    @Override
    public void onWorldUnload(final MinecraftServer server, final ServerWorld world) {
        SpawnModify.hasExecuted = false;
    }
}

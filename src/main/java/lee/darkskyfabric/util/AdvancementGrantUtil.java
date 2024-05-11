package lee.darkskyfabric.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public enum AdvancementGrantUtil {
    ;

    public static void registerAdvancementGrantEvent() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (final ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                final PlayerAdvancementTracker tracker = player.getAdvancementTracker();
                final AdvancementEntry rootAdvancement = server.getAdvancementLoader().get(new Identifier("darksky/root"));
                if (null != rootAdvancement && !tracker.getProgress(rootAdvancement).isDone()) {
                    tracker.grantCriterion(rootAdvancement, "darksky_table");
                }
            }
        });
    }
}
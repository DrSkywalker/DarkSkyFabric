package lee.darkskyfabric;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public enum AdvancementListener {
    ;
    private static final int DELAY_TICKS = 1000; // Number of ticks to wait
    private static final Identifier COLLECTED_TOOLS_ID = new Identifier("darksky/collectedtools");
    private static final Identifier END_MAYBE_ID = new Identifier("darksky/skyend");


    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private static final Logger LOGGER = LogManager.getLogger(DarkSkyFabric.LOGGER);

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (final ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                final PlayerAdvancementTracker tracker = player.getAdvancementTracker();
                final AdvancementEntry collectedTools = server.getAdvancementLoader().get(AdvancementListener.COLLECTED_TOOLS_ID);
                AdvancementEntry endMaybe = server.getAdvancementLoader().get(AdvancementListener.END_MAYBE_ID);

                    if (tracker.getProgress(collectedTools).isDone() && !tracker.getProgress(endMaybe).isDone()) {
                        AdvancementListener.executor.schedule(() -> {
                            AdvancementListener.LOGGER.info("Attempting to grant 'end' advancement");
                            tracker.grantCriterion(endMaybe, "dark_end_adv");
                        }, AdvancementListener.DELAY_TICKS, TimeUnit.MILLISECONDS);
                    }

            }
        });
    }
}
package lee.darkskyfabric.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.advancement.Advancement;
import net.minecraft.server.network.ServerPlayerEntity;

public interface AdvancementCompletedEvent {
    Event<AdvancementCompletedEvent> EVENT = EventFactory.createArrayBacked(AdvancementCompletedEvent.class,
            (listeners) -> (player, advancement) -> {
                for (AdvancementCompletedEvent listener : listeners) {
                    listener.onAdvancementCompleted(player, advancement);
                }
            });

    void onAdvancementCompleted(ServerPlayerEntity player, Advancement advancement);
}
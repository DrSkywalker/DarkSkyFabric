package lee.darkskyfabric.mixin;

import lee.darkskyfabric.events.AdvancementCompletedEvent;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.PlayerAdvancementTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementTrackerMixin {
    @Inject(method = "grantCriterion", at = @At("TAIL"))
    private void onAdvancementCompleted(final AdvancementEntry advancement, final String criterionName, final CallbackInfoReturnable<Boolean> cir){
        final PlayerAdvancementTrackerAccessor accessor = (PlayerAdvancementTrackerAccessor) this;
        AdvancementCompletedEvent.EVENT.invoker().onAdvancementCompleted(accessor.getOwner(), advancement.value());
    }
}
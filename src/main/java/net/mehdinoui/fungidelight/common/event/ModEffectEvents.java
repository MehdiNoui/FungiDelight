package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEffectEvents {
    @SubscribeEvent
    public static void onBreakSpeed(net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed event) {
        if (!event.getEntity().hasEffect(ModEffects.BURROWING.get())) {
            return;
        }
        if (event.getState().is(FungiDelightTags.BURROWABLE_BLOCKS)) {
            int amplifier = Objects.requireNonNull(event.getEntity().getEffect(ModEffects.BURROWING.get())).getAmplifier();
            float multiplier = 1.2F + (0.2F * amplifier);
            event.setNewSpeed(event.getOriginalSpeed() * multiplier);
        }
    }
}

package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.minecraft.tags.BlockTags;
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
        if (event.getState().is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            int amplifier = Objects.requireNonNull(event.getEntity().getEffect(ModEffects.BURROWING.get())).getAmplifier();
            float multiplier = 1.5F + (0.5F * amplifier);
            event.setNewSpeed(event.getOriginalSpeed() * multiplier);
        }
    }
}

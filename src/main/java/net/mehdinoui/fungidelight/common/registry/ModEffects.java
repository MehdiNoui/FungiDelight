package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.effect.BurrowingEffect;
import net.mehdinoui.fungidelight.common.effect.WeakStomachEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    // --- Deferred Register ---
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    // --- Effects Registry ---
    public static final DeferredHolder<MobEffect, MobEffect> BURROWING = EFFECTS.register("burrowing",
            BurrowingEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> WEAK_STOMACH = EFFECTS.register("weak_stomach",
            WeakStomachEffect::new);
}

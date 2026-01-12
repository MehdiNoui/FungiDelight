package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    // --- Deferred Register ---
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(Registries.POTION, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    // --- Potions Registry ---
    public static final DeferredHolder<Potion, Potion> BURROWING_POTION = POTIONS.register("burrowing",
            () -> new Potion(new MobEffectInstance(ModEffects.BURROWING, 3600)));
    public static final DeferredHolder<Potion, Potion> LONG_BURROWING_POTION = POTIONS.register("long_burrowing",
            () -> new Potion("burrowing", new MobEffectInstance(ModEffects.BURROWING, 9600)));
    public static final DeferredHolder<Potion, Potion> STRONG_BURROWING_POTION = POTIONS.register("strong_burrowing",
            () -> new Potion("burrowing", new MobEffectInstance(ModEffects.BURROWING, 1800, 1)));
}
package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    // --- Deferred Register ---
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    // --- Potions Registry ---
    public static final RegistryObject<Potion> BURROWING_POTION = POTIONS.register("burrowing",
            () -> new Potion(new MobEffectInstance(ModEffects.BURROWING.get(), 3600)));
    public static final RegistryObject<Potion> LONG_BURROWING_POTION = POTIONS.register("long_burrowing",
            () -> new Potion("burrowing", new MobEffectInstance(ModEffects.BURROWING.get(), 9600)));
    public static final RegistryObject<Potion> STRONG_BURROWING_POTION = POTIONS.register("strong_burrowing",
            () -> new Potion("burrowing", new MobEffectInstance(ModEffects.BURROWING.get(), 1800, 1)));
}
package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.effect.BurrowingEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    // --- Deferred Register ---
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    // --- Effects Registry ---
    public static final RegistryObject<MobEffect> BURROWING = EFFECTS.register("burrowing",
            BurrowingEffect::new);
}

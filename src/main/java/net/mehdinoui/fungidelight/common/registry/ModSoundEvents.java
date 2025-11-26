package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    // --- Deferred Register ---
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "fungidelight");
    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
    // --- Sounds Registry ---
    public static final RegistryObject<SoundEvent> PIG_HAPPY = SOUND_EVENTS.register("pig_happy",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FungiDelight.MOD_ID, "pig_happy")));
}
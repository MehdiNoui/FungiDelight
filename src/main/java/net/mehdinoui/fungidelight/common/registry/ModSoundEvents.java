package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    // --- Sounds Registry ---
    public static final DeferredHolder<SoundEvent, SoundEvent> PIG_HAPPY = SOUND_EVENTS.register("pig_happy",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "pig_happy")));
    public static final DeferredHolder<SoundEvent, SoundEvent> PIG_DIG = SOUND_EVENTS.register("pig_dig",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "pig_dig")));
    public static final DeferredHolder<SoundEvent, SoundEvent> PIG_DROP = SOUND_EVENTS.register("pig_drop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "pig_drop")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DOG_SNIFF_TRUFFLE = SOUND_EVENTS.register("dog_sniff_truffle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "dog_sniff_truffle")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DOG_FOUND_TRUFFLE = SOUND_EVENTS.register("dog_found_truffle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "dog_found_truffle")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DOG_ALERT_TRUFFLE = SOUND_EVENTS.register("dog_alert_truffle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "dog_alert_truffle")));
}
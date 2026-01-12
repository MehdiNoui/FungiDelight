package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.world.feature.HugeInkyCapFeature;
import net.mehdinoui.fungidelight.common.world.feature.HugeMorelFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFeatures {
    // --- Deferred Register for FEATURES ---
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, FungiDelight.MOD_ID);
    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
    // --- Features Registry ---
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> HUGE_MOREL_FEATURE =
            FEATURES.register("huge_morel_feature", () -> new HugeMorelFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> HUGE_INKY_CAP_FEATURE =
            FEATURES.register("huge_inky_cap_feature", () -> new HugeInkyCapFeature(NoneFeatureConfiguration.CODEC));

}

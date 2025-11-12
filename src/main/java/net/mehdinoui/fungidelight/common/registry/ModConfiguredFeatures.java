package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModConfiguredFeatures {
    // --- Configured feature key ---
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_MOREL_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "huge_morel_mushroom"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_INKY_CAP_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "huge_inky_cap_mushroom"));
    // --- Registering ---
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(
                HUGE_MOREL_MUSHROOM,
                new ConfiguredFeature<>(ModFeatures.HUGE_MOREL_FEATURE.get(), NoneFeatureConfiguration.INSTANCE));
        context.register(
                HUGE_INKY_CAP_MUSHROOM,
                new ConfiguredFeature<>(ModFeatures.HUGE_INKY_CAP_FEATURE.get(), NoneFeatureConfiguration.INSTANCE));

    }
}

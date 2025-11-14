package net.mehdinoui.fungidelight.common.registry;

import jdk.jfr.Registered;
import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class ModConfiguredFeatures {
    // --- Keys ---
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_INKY_CAP_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "huge_inky_cap_mushroom"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_MOREL_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "huge_morel_mushroom"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_INKY_CAP_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "patch_inky_cap_mushroom"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MOREL_MUSHROOM =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "patch_morel_mushroom"));

    // --- Register ---
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(
                HUGE_INKY_CAP_MUSHROOM,
                new ConfiguredFeature<>(ModFeatures.HUGE_INKY_CAP_FEATURE.get(), NoneFeatureConfiguration.INSTANCE));
        context.register(
                HUGE_MOREL_MUSHROOM,
                new ConfiguredFeature<>(ModFeatures.HUGE_MOREL_FEATURE.get(), NoneFeatureConfiguration.INSTANCE));
        context.register(
                PATCH_MOREL_MUSHROOM,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(96, 7, 3,
                                PlacementUtils.filtered(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                SimpleStateProvider.simple(ModBlocks.MOREL_MUSHROOM.get().defaultBlockState())
                                        ),
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE
                                )
                        )
                )
        );
        context.register(
                PATCH_INKY_CAP_MUSHROOM,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(96, 7, 3,
                                PlacementUtils.filtered(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                SimpleStateProvider.simple(ModBlocks.INKY_CAP_MUSHROOM.get().defaultBlockState())
                                        ),
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE
                                )
                        )
                )
        );
    }
}

package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    // --- Keys ---
    public static final ResourceKey<PlacedFeature> HUGE_INKY_CAP_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "huge_inky_cap_mushroom"));
    public static final ResourceKey<PlacedFeature> HUGE_MOREL_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "huge_morel_mushroom"));
    public static final ResourceKey<PlacedFeature> INKY_CAP_MUSHROOM_NORMAL_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "inky_cap_mushroom_normal"));
    public static final ResourceKey<PlacedFeature> MOREL_MUSHROOM_NORMAL_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "morel_mushroom_normal"));

    // --- Register ---
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        // --- Huge Mushrooms ---
        context.register(
                HUGE_INKY_CAP_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.HUGE_INKY_CAP_MUSHROOM),
                        List.of(
                                CountPlacement.of(1),
                                RarityFilter.onAverageOnceEvery(3),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
        context.register(
                HUGE_MOREL_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.HUGE_MOREL_MUSHROOM),
                        List.of(
                                CountPlacement.of(1),
                                RarityFilter.onAverageOnceEvery(3),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
        // --- Mushroom patches ---
        context.register(
                INKY_CAP_MUSHROOM_NORMAL_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.PATCH_INKY_CAP_MUSHROOM),
                        List.of(
                                RarityFilter.onAverageOnceEvery(8),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
        context.register(
                MOREL_MUSHROOM_NORMAL_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.PATCH_MOREL_MUSHROOM),
                        List.of(
                                RarityFilter.onAverageOnceEvery(4),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
    }
}

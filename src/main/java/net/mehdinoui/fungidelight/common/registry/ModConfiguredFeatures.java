package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;

import java.util.List;

import static vectorwing.farmersdelight.common.registry.ModBiomeFeatures.WILD_CROP;

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

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_INKY_CAP_MUSHROOM_COLONY_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "patch_inky_cap_mushroom_colony"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MOREL_MUSHROOM_COLONY_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FungiDelight.MOD_ID, "patch_morel_mushroom_colony"));

    // --- Helper Methods For Colony ---
    public static Holder<PlacedFeature> mushroomColonyFeature(BlockState block){
        return Holder.direct(new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                new RandomizedIntStateProvider(
                                        SimpleStateProvider.simple(block),
                                        "age",
                                        UniformInt.of(0, 3)
                                )
                        )
                )),
                List.of(
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(
                                        BlockPredicate.matchesBlocks(List.of(Blocks.AIR)),
                                        BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), List.of(Blocks.MYCELIUM))
                                )
                        )
                )
        ));
    }
    public static Holder<PlacedFeature> mushroomFeature(BlockState block){
        return Holder.direct(new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                SimpleStateProvider.simple(block)
                        )
                )),
                List.of(
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(
                                        BlockPredicate.matchesBlocks(List.of(Blocks.AIR)),
                                        BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), List.of(Blocks.MYCELIUM))
                                )
                        )
                )
        ));
    }

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
                        new RandomPatchConfiguration(36, 5, 3,
                                PlacementUtils.filtered(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                SimpleStateProvider.simple(ModBlocks.MOREL_MUSHROOM.get().defaultBlockState())
                                        ),
                                        BlockPredicate.allOf(
                                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                                BlockPredicate.matchesTag(new Vec3i(0, -1, 0), FungiDelightTags.MOREL_PLACEABLE_ON)
                                        )
                                )
                        )
                )
        );
        context.register(
                PATCH_INKY_CAP_MUSHROOM,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(46, 7, 3,
                                PlacementUtils.filtered(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                SimpleStateProvider.simple(ModBlocks.INKY_CAP_MUSHROOM.get().defaultBlockState())
                                        ),
                                        BlockPredicate.allOf(
                                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                                BlockPredicate.matchesTag(new Vec3i(0, -1, 0), FungiDelightTags.MOREL_PLACEABLE_ON)
                                        )
                                )
                        )
                )
        );
        context.register(
                PATCH_INKY_CAP_MUSHROOM_COLONY_KEY,
                new ConfiguredFeature<>(
                        WILD_CROP.get(),
                        new WildCropConfiguration(
                                64,
                                6,
                                3,
                                mushroomColonyFeature(ModBlocks.INKY_CAP_MUSHROOM_COLONY.get().defaultBlockState()),
                                mushroomFeature(ModBlocks.INKY_CAP_MUSHROOM.get().defaultBlockState()),
                                null
                        )
                )
        );
        context.register(
                PATCH_MOREL_MUSHROOM_COLONY_KEY,
                new ConfiguredFeature<>(
                        WILD_CROP.get(),
                        new WildCropConfiguration(
                                64,
                                6,
                                3,
                                mushroomColonyFeature(ModBlocks.MOREL_MUSHROOM_COLONY.get().defaultBlockState()),
                                mushroomFeature(ModBlocks.MOREL_MUSHROOM.get().defaultBlockState()),
                                null
                        )
                )
        );
    }
}

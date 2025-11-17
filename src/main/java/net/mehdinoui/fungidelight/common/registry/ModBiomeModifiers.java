package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.world.modifier.AddFeaturesByFilterBiomeModifier;

public class ModBiomeModifiers {
    // --- Keys ---
    public static final ResourceKey<BiomeModifier> ADD_HUGE_INKY_CAP =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_huge_inky_cap"));
    public static final ResourceKey<BiomeModifier> ADD_HUGE_MOREL =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_huge_morel"));

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_PATCH_MUSHROOM_FIELD =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_inky_cap_patch_mushroom_field"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_PATCH_MUSHROOM_FIELD =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_morel_patch_mushroom_field"));

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_PATCH_OVERWORLD =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_inky_cap_patch_overworld"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_PATCH_OVERWORLD =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_morel_patch_overworld"));

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_PATCH_DENSE =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_inky_cap_patch_dense"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_PATCH_SWAMP =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_morel_patch_swamp"));

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_COLONY =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "patch_inky_cap_mushroom_colony"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_COLONY =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "patch_morel_mushroom_colony"));

    // --- Register ---
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        // Huge Mushrooms
        context.register(
                ADD_HUGE_INKY_CAP,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HUGE_INKY_CAP_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_HUGE_MOREL,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HUGE_MOREL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        // Mushrooms Patches
        context.register(
                ADD_INKY_CAP_MUSHROOM_PATCH_OVERWORLD,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_NORMAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_PATCH_OVERWORLD,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_NORMAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );

        context.register(
                ADD_INKY_CAP_MUSHROOM_PATCH_MUSHROOM_FIELD,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_COMMON_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_PATCH_MUSHROOM_FIELD,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_COMMON_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );

        context.register(
                ADD_INKY_CAP_MUSHROOM_PATCH_DENSE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_DENSE_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_RARE_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_PATCH_SWAMP,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_RARE_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_INKY_CAP_MUSHROOM_COLONY,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_COLONY_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_COLONY,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_COLONY_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
    }
}

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
    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_PATCH_TAIGA =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_inky_cap_patch_taiga"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_PATCH_TAIGA =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_morel_patch_taiga"));

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
        // Mushrooms patches
        context.register(
                ADD_INKY_CAP_MUSHROOM_PATCH_MUSHROOM_FIELD,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_NORMAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_PATCH_MUSHROOM_FIELD,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_NORMAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
               ADD_INKY_CAP_MUSHROOM_PATCH_TAIGA,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_TAIGA),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_NORMAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_PATCH_TAIGA,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_TAIGA),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_NORMAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
    }
}

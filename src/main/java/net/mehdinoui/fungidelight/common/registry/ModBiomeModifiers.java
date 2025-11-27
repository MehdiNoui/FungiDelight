package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

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

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_PATCH_TAGGED =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_inky_cap_patch_tagged"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_PATCH_TAGGED =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_morel_patch_tagged"));

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_MUSHROOM_COLONY =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "patch_inky_cap_mushroom_colony"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_MUSHROOM_COLONY =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "patch_morel_mushroom_colony"));

    public static final ResourceKey<BiomeModifier> ADD_ROOTED_DIRT_BLOB =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_rooted_dirt_blob"));
    public static final ResourceKey<BiomeModifier> ADD_TRUFFLE_DIRT_ORE =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_truffle_dirt_ore"));

    public static final ResourceKey<BiomeModifier> ADD_INKY_CAP_COW_SPAWN =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_inky_cap_cow_spawn"));
    public static final ResourceKey<BiomeModifier> ADD_MOREL_COW_SPAWN =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FungiDelight.MOD_ID, "add_morel_cow_spawn"));

    // --- Register ---
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        // Huge Mushrooms (Mushroom Fields)
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
        // Mushrooms Patches (Overworld)
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
        // Common Patches (Mushroom Fields)
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
        // Rare Patches (Custom Biomes)
        context.register(
                ADD_INKY_CAP_MUSHROOM_PATCH_TAGGED,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(FungiDelightTags.HAS_INKY_CAPS),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.INKY_CAP_MUSHROOM_RARE_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        context.register(
                ADD_MOREL_MUSHROOM_PATCH_TAGGED,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(FungiDelightTags.HAS_MORELS),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MOREL_MUSHROOM_RARE_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
        // Mushroom Colonies
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
        context.register(
                ADD_ROOTED_DIRT_BLOB,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(FungiDelightTags.HAS_TRUFFLES),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ROOTED_DIRT_BLOB_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        context.register(
                ADD_TRUFFLE_DIRT_ORE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(FungiDelightTags.HAS_TRUFFLES),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TRUFFLE_DIRT_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        // New Mushroom Cows
        context.register(
                ADD_INKY_CAP_COW_SPAWN,
                new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        List.of(
                                new MobSpawnSettings.SpawnerData(ModEntities.INKY_CAP_COW.get(),
                                        8, 3, 4)
                        )
                )
        );
        context.register(
                ADD_MOREL_COW_SPAWN,
                new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_MUSHROOM),
                        List.of(
                                new MobSpawnSettings.SpawnerData(ModEntities.MOREL_COW.get(),
                                        8, 3, 4))
        ));
    }
}

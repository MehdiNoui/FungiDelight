package net.mehdinoui.fungidelight.data.recipe;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.List;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModBasicRecipes {
    // Helper method
    private static void suspiciousStew(RecipeOutput consumer, ItemLike ingredient, Holder<MobEffect> effect, int duration) {
        SuspiciousStewEffects.Entry entry = new SuspiciousStewEffects.Entry(effect, duration);
        SuspiciousStewEffects effectsComponent = new SuspiciousStewEffects(List.of(entry));

        ItemStack resultStack = new ItemStack(Items.SUSPICIOUS_STEW);
        resultStack.set(DataComponents.SUSPICIOUS_STEW_EFFECTS, effectsComponent);

        String name = BuiltInRegistries.ITEM.getKey(ingredient.asItem()).getPath();

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, resultStack)
                .requires(Items.BOWL)
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.RED_MUSHROOM)
                .requires(ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "suspicious_stew_from_" + name));
    }

    public static void register(RecipeOutput consumer) {
        shapefulRecipes(consumer);
        shapelessRecipes(consumer);;
    }
    public static void shapefulRecipes(RecipeOutput consumer){
        // Mushroom Crates
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.BROWN_MUSHROOM)
                .unlockedBy("has_brown_mushroom", hasItems(Items.BROWN_MUSHROOM))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"brown_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.RED_MUSHROOM)
                .unlockedBy("has_red_mushroom", hasItems(Items.RED_MUSHROOM))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"red_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INKY_CAP_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.INKY_CAP_MUSHROOM.get())
                .unlockedBy("has_inky_cap_mushroom", hasItems(ModItems.INKY_CAP_MUSHROOM.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"inky_cap_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOREL_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MOREL_MUSHROOM.get())
                .unlockedBy("has_morel_mushroom", hasItems(ModItems.MOREL_MUSHROOM.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"morel_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TRUFFLE_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TRUFFLE.get())
                .unlockedBy("has_truffle", hasItems(ModItems.TRUFFLE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"truffle_crate"));
    }
    public static void shapelessRecipes(RecipeOutput consumer){
        // Food items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.INKY_CAP_SCRAMBLED_EGGS.get(),1)
                .requires(CommonTags.FOODS_COOKED_EGG)
                .requires(CommonTags.FOODS_COOKED_EGG)
                .requires(ModItems.COOKED_CLEANED_CAPS.get())
                .requires(Items.BOWL)
                .unlockedBy("has_cooked_caps", hasItems(ModItems.COOKED_CLEANED_CAPS.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"inky_cap_scrambled_eggs"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.INKY_CAPS_SALAD.get(),1)
                .requires(CommonTags.FOODS_LEAFY_GREEN)
                .requires(ModItems.CLEANED_CAPS.get())
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", hasItems(Items.BOWL))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"inky_cap_salad"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TRUFFLE_ICE_CREAM.get(), 1)
                .requires(ModItems.TRUFFLE_SLICE.get())
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .requires(Items.MILK_BUCKET)
                .requires(Items.BOWL)
                .unlockedBy("has_truffle_slice", hasItems(ModItems.TRUFFLE_SLICE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "truffle_ice_cream"));
        // Mushroom from crates
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BROWN_MUSHROOM, 9)
                .requires(ModBlocks.BROWN_MUSHROOM_CRATE.get())
                .unlockedBy("has_brown_mushroom_crate", hasItems(ModBlocks.BROWN_MUSHROOM_CRATE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"brown_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_MUSHROOM, 9)
                .requires(ModBlocks.RED_MUSHROOM_CRATE.get())
                .unlockedBy("has_red_mushroom_crate", hasItems(ModBlocks.RED_MUSHROOM_CRATE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"red_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INKY_CAP_MUSHROOM.get(), 9)
                .requires(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get())
                .unlockedBy("has_inky_cap_mushroom_crate", hasItems(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"inky_cap_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MOREL_MUSHROOM.get(), 9)
                .requires(ModBlocks.MOREL_MUSHROOM_CRATE.get())
                .unlockedBy("has_morel_mushroom_crate", hasItems(ModBlocks.MOREL_MUSHROOM_CRATE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"morel_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TRUFFLE.get(), 9)
                .requires(ModBlocks.TRUFFLE_CRATE.get())
                .unlockedBy("has_truffle_crate", hasItems(ModBlocks.TRUFFLE_CRATE.get()))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID,"truffles_from_crate"));
        // Suspicious Stews
        suspiciousStew(consumer, ModItems.INKY_CAP_MUSHROOM.get(), MobEffects.BLINDNESS, 160);
        suspiciousStew(consumer, ModItems.MOREL_MUSHROOM.get(), MobEffects.SATURATION, 160);
        suspiciousStew(consumer, ModItems.TRUFFLE.get(), ModEffects.BURROWING, 160);
    }
}
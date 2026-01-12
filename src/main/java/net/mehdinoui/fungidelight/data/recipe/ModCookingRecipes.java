package net.mehdinoui.fungidelight.data.recipe;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SMALL_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.LARGE_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.FAST_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SLOW_COOKING;

public class ModCookingRecipes {
    public static void register(RecipeOutput consumer) {
        cookingMeals(consumer);
        cookMiscellaneous(consumer);
        cookDrinks(consumer);
    }
    private static void cookingMeals(RecipeOutput consumer) {

        // --- Soups ---
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CREAMY_MOREL_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(FungiDelightTags.MORELS)
                .addIngredient(FungiDelightTags.MORELS)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByItems("has_morel", ModItems.MOREL_MUSHROOM.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/creamy_morel_soup")));

        // --- Plated Meals ---
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.TRUFFLE_PASTA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_PASTA)
                .addIngredient(FungiDelightTags.TRUFFLES)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByItems("has_truffle_slice", ModItems.TRUFFLE_SLICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/truffle_pasta")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STUFFED_MORELS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(FungiDelightTags.MORELS)
                .addIngredient(FungiDelightTags.MORELS)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .addIngredient(CommonTags.FOODS_COOKED_CHICKEN)
                .unlockedByItems("has_morel", ModItems.MOREL_MUSHROOM.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/stuffed_morels")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STEAK_WITH_MUSHROOMS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.BEEF)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(CommonTags.CROPS_ONION)
                .addIngredient(CommonTags.FOODS_MILK)
                .unlockedByItems("has_brown_mushroom", Items.BROWN_MUSHROOM)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/steak_with_mushrooms")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MUTTON_CHOPS_WITH_TRUFFLE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_RAW_MUTTON)
                .addIngredient(FungiDelightTags.TRUFFLES)
                .addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByItems("has_truffle_slice", ModItems.TRUFFLE_SLICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/mutton_chops_with_truffle")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.RABBIT_WITH_MORELS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.RABBIT)
                .addIngredient(FungiDelightTags.MORELS)
                .addIngredient(FungiDelightTags.MORELS)
                .addIngredient(Tags.Items.CROPS_CARROT)
                .addIngredient(CommonTags.CROPS_ONION)
                .unlockedByItems("has_morel", ModItems.MOREL_MUSHROOM.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/rabbit_with_morels")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.PORK_MARSALA_WITH_MUSHROOMS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_RAW_PORK)
                .addIngredient(CommonTags.CROPS_ONION)
                .addIngredient(Items.RED_MUSHROOM)
                .addIngredient(Items.RED_MUSHROOM)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .unlockedByItems("has_red_mushroom", Items.RED_MUSHROOM)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath("fungidelight", "cooking/pork_marsala_with_mushrooms")));
    }
    private static void cookMiscellaneous(RecipeOutput consumer) {
    }
    private  static void cookDrinks(RecipeOutput consumer) {}
}

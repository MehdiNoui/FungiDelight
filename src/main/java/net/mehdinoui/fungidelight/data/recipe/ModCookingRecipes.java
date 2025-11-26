package net.mehdinoui.fungidelight.data.recipe;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SMALL_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.LARGE_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.FAST_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SLOW_COOKING;

public class ModCookingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        cookingMeals(consumer);
        cookMiscellaneous(consumer);
        cookDrinks(consumer);
    }
    private static void cookingMeals(Consumer<FinishedRecipe> consumer) {

        // --- Soups ---
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CREAMY_MOREL_SOUP.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.MOREL_MUSHROOM.get())
                .addIngredient(ModItems.MOREL_MUSHROOM.get())
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedByItems("has_morel", ModItems.MOREL_MUSHROOM.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/creamy_morel_soup"));

        // --- Plated Meals ---
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.TRUFFLE_PASTA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(ModItems.TRUFFLE_SLICE.get())
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedByItems("has_truffle_slice", ModItems.TRUFFLE_SLICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/truffle_pasta"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STUFFED_MORELS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.MOREL_MUSHROOM.get())
                .addIngredient(ModItems.MOREL_MUSHROOM.get())
                .addIngredient(ForgeTags.GRAIN_RICE)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ForgeTags.COOKED_CHICKEN)
                .unlockedByItems("has_morel", ModItems.MOREL_MUSHROOM.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/stuffed_morels"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STEAK_WITH_MUSHROOMS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.BEEF)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.MILK)
                .unlockedByItems("has_brown_mushroom", Items.BROWN_MUSHROOM)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/steak_with_mushrooms"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MUTTON_CHOPS_WITH_TRUFFLE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ForgeTags.RAW_MUTTON)
                .addIngredient(ModItems.TRUFFLE_SLICE.get())
                .addIngredient(ForgeTags.VEGETABLES_POTATO)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedByItems("has_truffle_slice", ModItems.TRUFFLE_SLICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/mutton_chops_with_truffle"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.RABBIT_WITH_MORELS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.RABBIT)
                .addIngredient(ModItems.MOREL_MUSHROOM.get())
                .addIngredient(ModItems.MOREL_MUSHROOM.get())
                .addIngredient(ForgeTags.VEGETABLES_CARROT)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedByItems("has_morel", ModItems.MOREL_MUSHROOM.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/rabbit_with_morels"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.PORK_MARSALA_WITH_MUSHROOMS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ForgeTags.RAW_PORK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.RED_MUSHROOM)
                .addIngredient(Items.RED_MUSHROOM)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .unlockedByItems("has_red_mushroom", Items.RED_MUSHROOM)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation("fungidelight", "cooking/pork_marsala_with_mushrooms"));
    }
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
    }
    private  static void cookDrinks(Consumer<FinishedRecipe> consumer) {}
}

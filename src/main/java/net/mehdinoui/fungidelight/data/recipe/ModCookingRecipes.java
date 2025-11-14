package net.mehdinoui.fungidelight.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

// FD's Experience Values
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SMALL_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.LARGE_EXP;
// FD's Cooking Time
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
    }
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
    }
    private  static void cookDrinks(Consumer<FinishedRecipe> consumer) {}
}

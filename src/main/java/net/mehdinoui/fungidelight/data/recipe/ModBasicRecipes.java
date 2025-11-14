package net.mehdinoui.fungidelight.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ModBasicRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        shapefulRecipes(consumer);
        shapelessRecipes(consumer);;
    }
    public static void shapefulRecipes(Consumer<FinishedRecipe> consumer){}
    public static void shapelessRecipes(Consumer<FinishedRecipe> consumer){}
}

package net.mehdinoui.fungidelight.data.recipe;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModSmeltingRecipes {
    // Helper method
    private static void cookingTriplet(
            RecipeOutput consumer,
            Ingredient input,
            ItemLike result,
            float xp,
            int cookTime,
            String name,
            ItemLike unlockItem
    ) {
        SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.FOOD, result, xp, cookTime)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, name + "_from_smelting"));

        SimpleCookingRecipeBuilder.smoking(input, RecipeCategory.FOOD, result, xp, cookTime / 2)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, name + "_from_smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(input, RecipeCategory.FOOD, result, xp, cookTime * 3)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, name + "_from_campfire_cooking"));
    }

    public static void register(RecipeOutput consumer) {
        tripletRecipes(consumer);
    }

    public static void tripletRecipes(RecipeOutput consumer) {
        cookingTriplet(consumer,
                Ingredient.of(ModItems.CLEANED_CAPS.get()),
                ModItems.COOKED_CLEANED_CAPS.get(),
                0.35F, 200,
                "cooked_cleaned_cap",
                ModItems.CLEANED_CAPS.get());
    }
}
package net.mehdinoui.fungidelight.data.recipe;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

public class ModCuttingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        // Colonies
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.INKY_CAP_MUSHROOM_COLONY.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.INKY_CAP_MUSHROOM.get(),5)
                .build(consumer, new ResourceLocation(FungiDelight.MOD_ID, "cutting/inky_cap_mushroom_colony"));
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.MOREL_MUSHROOM_COLONY.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.MOREL_MUSHROOM.get(),5)
                .build(consumer, new ResourceLocation(FungiDelight.MOD_ID, "cutting/morel_mushroom_colony"));
        // Inky cap
        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(ModItems.INKY_CAP_MUSHROOM.get()),
                Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.CLEANED_CAPS.get(),1)
                .addResult(Items.INK_SAC, 1)
                .addResultWithChance(Items.INK_SAC, 0.2F, 1)
                .build(consumer, new ResourceLocation(FungiDelight.MOD_ID, "cutting/cleaned_cap"));
        // Truffle
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.TRUFFLE.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.TRUFFLE_SLICE.get(),2)
                .build(consumer, new ResourceLocation(FungiDelight.MOD_ID, "cutting/truffle_slice"));
    }
}
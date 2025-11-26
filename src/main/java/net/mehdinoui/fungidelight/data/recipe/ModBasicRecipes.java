package net.mehdinoui.fungidelight.data.recipe;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModBasicRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        shapefulRecipes(consumer);
        shapelessRecipes(consumer);;
    }
    public static void shapefulRecipes(Consumer<FinishedRecipe> consumer){
        // Mushroom Crates
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.BROWN_MUSHROOM)
                .unlockedBy("has_brown_mushroom", hasItems(Items.BROWN_MUSHROOM))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"brown_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.RED_MUSHROOM)
                .unlockedBy("has_red_mushroom", hasItems(Items.RED_MUSHROOM))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"red_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INKY_CAP_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.INKY_CAP_MUSHROOM.get())
                .unlockedBy("has_inky_cap_mushroom", hasItems(ModItems.INKY_CAP_MUSHROOM.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"inky_cap_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOREL_MUSHROOM_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MOREL_MUSHROOM.get())
                .unlockedBy("has_morel_mushroom", hasItems(ModItems.MOREL_MUSHROOM.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"morel_mushroom_crate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TRUFFLE_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TRUFFLE.get())
                .unlockedBy("has_truffle", hasItems(ModItems.TRUFFLE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"truffle_crate"));
    }
    public static void shapelessRecipes(Consumer<FinishedRecipe> consumer){
        // Food items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.INKY_CAP_SCRAMBLED_EGGS.get(),1)
                .requires(ForgeTags.COOKED_EGGS)
                .requires(ForgeTags.COOKED_EGGS)
                .requires(ModItems.COOKED_CLEANED_CAPS.get())
                .requires(Items.BOWL)
                .unlockedBy("has_cooked_caps", hasItems(ModItems.COOKED_CLEANED_CAPS.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"inky_cap_scrambled_eggs"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.INKY_CAPS_SALAD.get(),1)
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ModItems.CLEANED_CAPS.get())
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", hasItems(Items.BOWL))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"inky_cap_salad"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TRUFFLE_ICE_CREAM.get(), 1)
                .requires(ModItems.TRUFFLE_SLICE.get())
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .requires(Items.MILK_BUCKET)
                .requires(Items.BOWL)
                .unlockedBy("has_truffle_slice", hasItems(ModItems.TRUFFLE_SLICE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID, "truffle_ice_cream"));
        // Mushroom from crates
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BROWN_MUSHROOM, 9)
                .requires(ModBlocks.BROWN_MUSHROOM_CRATE.get())
                .unlockedBy("has_brown_mushroom_crate", hasItems(ModBlocks.BROWN_MUSHROOM_CRATE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"brown_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_MUSHROOM, 9)
                .requires(ModBlocks.RED_MUSHROOM_CRATE.get())
                .unlockedBy("has_red_mushroom_crate", hasItems(ModBlocks.RED_MUSHROOM_CRATE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"red_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INKY_CAP_MUSHROOM.get(), 9)
                .requires(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get())
                .unlockedBy("has_inky_cap_mushroom_crate", hasItems(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"inky_cap_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MOREL_MUSHROOM.get(), 9)
                .requires(ModBlocks.MOREL_MUSHROOM_CRATE.get())
                .unlockedBy("has_morel_mushroom_crate", hasItems(ModBlocks.MOREL_MUSHROOM_CRATE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"morel_mushrooms_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TRUFFLE.get(), 9)
                .requires(ModBlocks.TRUFFLE_CRATE.get())
                .unlockedBy("has_truffle_crate", hasItems(ModBlocks.TRUFFLE_CRATE.get()))
                .save(consumer, new ResourceLocation(FungiDelight.MOD_ID,"truffles_from_crate"));
    }
}

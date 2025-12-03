package net.mehdinoui.fungidelight.common.potion;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.mehdinoui.fungidelight.common.registry.ModPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class ModBrewingRecipes {
    public static void register() {
        BrewingRecipeRegistry.addRecipe(new PotionBrewingRecipe(
                Potions.AWKWARD,
                ModItems.TRUFFLE.get(),
                ModPotions.BURROWING_POTION.get()
        ));

        BrewingRecipeRegistry.addRecipe(new PotionBrewingRecipe(
                ModPotions.BURROWING_POTION.get(),
                Items.REDSTONE,
                ModPotions.LONG_BURROWING_POTION.get()
        ));
    }

    private static class PotionBrewingRecipe implements IBrewingRecipe {
        private final Potion inputPotion;
        private final Item ingredient;
        private final Potion outputPotion;

        public PotionBrewingRecipe(Potion inputPotion, Item ingredient, Potion outputPotion) {
            this.inputPotion = inputPotion;
            this.ingredient = ingredient;
            this.outputPotion = outputPotion;
        }

        @Override
        public boolean isInput(ItemStack input) {
            return input.getItem() == Items.POTION && PotionUtils.getPotion(input) == this.inputPotion;
        }

        @Override
        public boolean isIngredient(ItemStack ingredient) {
            return ingredient.getItem() == this.ingredient;
        }

        @Override
        public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
            if (!isInput(input) || !isIngredient(ingredient)) {
                return ItemStack.EMPTY;
            }
            return PotionUtils.setPotion(new ItemStack(input.getItem()), this.outputPotion);
        }
    }
}
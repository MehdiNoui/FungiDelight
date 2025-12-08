package net.mehdinoui.fungidelight.common.potion;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.mehdinoui.fungidelight.common.registry.ModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModBrewingRecipes {
    public static void register() {
        ItemStack awkwardPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD);

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(awkwardPotion),
                Ingredient.of(ModItems.TRUFFLE.get()),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.BURROWING_POTION.get())
        ));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.BURROWING_POTION.get())),
                Ingredient.of(Items.REDSTONE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_BURROWING_POTION.get())
        ));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.BURROWING_POTION.get())),
                Ingredient.of(Items.GLOWSTONE_DUST),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.STRONG_BURROWING_POTION.get())
        ));
    }
}
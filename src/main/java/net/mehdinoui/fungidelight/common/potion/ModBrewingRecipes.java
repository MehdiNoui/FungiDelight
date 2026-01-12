package net.mehdinoui.fungidelight.common.potion;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.mehdinoui.fungidelight.common.registry.ModPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

public class ModBrewingRecipes {
    @SubscribeEvent
    public static void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent event) {
        var builder = event.getBuilder();

        builder.addMix(
                Potions.AWKWARD,
                ModItems.TRUFFLE.get(),
                ModPotions.BURROWING_POTION
        );
        builder.addMix(
                ModPotions.BURROWING_POTION,
                Items.REDSTONE,
                ModPotions.LONG_BURROWING_POTION
        );
        builder.addMix(
                ModPotions.BURROWING_POTION,
                Items.GLOWSTONE_DUST,
                ModPotions.STRONG_BURROWING_POTION
        );
    }
}
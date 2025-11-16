package net.mehdinoui.fungidelight.client.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModMobsEvents {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        if (Configuration.ENABLE_PIG_FOODS.get()) {
            event.enqueueWork(() -> {
                Ingredient newPigFood = Ingredient.of(
                    Items.BROWN_MUSHROOM,
                    Items.RED_MUSHROOM,
                    ModItems.INKY_CAP_MUSHROOM.get(),
                    ModItems.MOREL_MUSHROOM.get()
                );
                Pig.FOOD_ITEMS = new CompoundIngredient(Arrays.asList(Pig.FOOD_ITEMS, newPigFood)) {};
            });
        }
    }
}
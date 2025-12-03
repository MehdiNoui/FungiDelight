package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.potion.ModBrewingRecipes;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvent {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 50%
            ComposterBlock.COMPOSTABLES.put(ModItems.CLEANED_CAPS.get(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(ModItems.TRUFFLE_SLICE.get(), 0.5f);
            // 65%
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_CLEANED_CAPS.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_STEM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_GOO_VEIL.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM_STEM.get(), 0.65f);
            // 85%
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_BLOCK.get(), 0.85f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_EDGE.get(), 0.85f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM_BLOCK.get(), 0.85f);
            // 100%
            ComposterBlock.COMPOSTABLES.put(ModItems.TRUFFLE.get(), 1.0f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_COLONY.get(), 1.0f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM_COLONY.get(), 1.0f);
        });
    }
}
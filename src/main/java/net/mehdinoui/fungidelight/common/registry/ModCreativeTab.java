package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    // --- Deferred Register ---
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // --- Creative Tab Registry ---
    public static final RegistryObject<CreativeModeTab> FungiDelight_Tab = CREATIVE_MODE_TABS
            .register("fungidelight_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.INKY_CAP_MUSHROOM.get()))
                    .title(Component.translatable("creativetab.fungidelight_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Crates
                        pOutput.accept(ModItems.BROWN_MUSHROOM_CRATE.get());
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_CRATE.get());
                        pOutput.accept(ModItems.MOREL_MUSHROOM_CRATE.get());
                        pOutput.accept(ModItems.RED_MUSHROOM_CRATE.get());
                        pOutput.accept(ModItems.TRUFFLE_CRATE.get());

                        // Mushrooms & Colonies
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM.get());
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_COLONY.get());
                        pOutput.accept(ModItems.MOREL_MUSHROOM.get());
                        pOutput.accept(ModItems.MOREL_MUSHROOM_COLONY.get());

                        // Blocks
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_BLOCK.get());
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_EDGE.get());
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_STEM.get());
                        pOutput.accept(ModItems.INKY_GOO_VEIL.get());

                        pOutput.accept(ModItems.MOREL_MUSHROOM_BLOCK.get());
                        pOutput.accept(ModItems.MOREL_MUSHROOM_STEM.get());
                        pOutput.accept(ModItems.TRUFFLE_DIRT.get());

                        // Ingredients
                        pOutput.accept(ModItems.CLEANED_CAPS.get());
                        pOutput.accept(ModItems.COOKED_CLEANED_CAPS.get());
                        pOutput.accept(ModItems.TRUFFLE.get());
                        pOutput.accept(ModItems.TRUFFLE_SLICE.get());

                        // Food & Meals
                        pOutput.accept(ModItems.INKY_CAPS_SALAD.get());
                        pOutput.accept(ModItems.CREAMY_MOREL_SOUP.get());

                        pOutput.accept(ModItems.INKY_CAP_SCRAMBLED_EGGS.get());
                        pOutput.accept(ModItems.TRUFFLE_PASTA.get());
                        pOutput.accept(ModItems.STUFFED_MORELS.get());
                        pOutput.accept(ModItems.MUTTON_CHOPS_WITH_TRUFFLE.get());
                        pOutput.accept(ModItems.RABBIT_WITH_MORELS.get());

                        // Desserts
                        pOutput.accept(ModItems.TRUFFLE_ICE_CREAM.get());
                    }).build());
}

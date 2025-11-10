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
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM.get());
                        pOutput.accept(ModItems.MOREL_MUSHROOM.get());

                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_BLOCK.get());
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_EDGE.get());
                        pOutput.accept(ModItems.INKY_CAP_MUSHROOM_STEM.get());

                        pOutput.accept(ModItems.MOREL_MUSHROOM_BLOCK.get());
                        pOutput.accept(ModItems.MOREL_MUSHROOM_STEM.get());
                    }).build());
}

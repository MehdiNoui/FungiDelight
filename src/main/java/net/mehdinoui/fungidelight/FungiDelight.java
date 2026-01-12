package net.mehdinoui.fungidelight;

import net.mehdinoui.fungidelight.common.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;


@Mod(FungiDelight.MOD_ID)
public class FungiDelight {
    public static final String MOD_ID = "fungidelight";
    public FungiDelight(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModPlacementModifiers.register(modEventBus);
        ModSoundEvents.register(modEventBus);
        ModEntities.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, ModConfiguration.CONFIG);
    }
}

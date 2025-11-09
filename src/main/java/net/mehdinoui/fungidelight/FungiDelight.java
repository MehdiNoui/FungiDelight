package net.mehdinoui.fungidelight;

import net.mehdinoui.fungidelight.common.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FungiDelight.MOD_ID)
public class FungiDelight {
    public static final String MOD_ID = "fungidelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FungiDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
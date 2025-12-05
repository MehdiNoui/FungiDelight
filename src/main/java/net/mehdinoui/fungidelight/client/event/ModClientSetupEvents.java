package net.mehdinoui.fungidelight.client.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.client.renderer.FDMCowRenderer;
import net.mehdinoui.fungidelight.common.registry.ModEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientSetupEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.INKY_CAP_COW.get(), FDMCowRenderer::new);
        event.registerEntityRenderer(ModEntities.MOREL_COW.get(), FDMCowRenderer::new);
    }
}

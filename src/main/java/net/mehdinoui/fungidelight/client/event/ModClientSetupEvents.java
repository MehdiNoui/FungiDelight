package net.mehdinoui.fungidelight.client.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.client.renderer.FDMCowRenderer;
import net.mehdinoui.fungidelight.common.registry.ModEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModClientSetupEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.INKY_CAP_COW.get(), FDMCowRenderer::new);
        event.registerEntityRenderer(ModEntities.MOREL_COW.get(), FDMCowRenderer::new);
    }
}

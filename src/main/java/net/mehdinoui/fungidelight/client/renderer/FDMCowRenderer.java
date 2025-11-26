package net.mehdinoui.fungidelight.client.renderer;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.entity.custom.FDMCow;
import net.mehdinoui.fungidelight.common.registry.ModEntities;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FDMCowRenderer extends MobRenderer<FDMCow, CowModel<FDMCow>> {
    private static final ResourceLocation INKY_LOCATION = new ResourceLocation(FungiDelight.MOD_ID, "textures/entity/inky_cap_cow.png");
    private static final ResourceLocation MOREL_LOCATION = new ResourceLocation(FungiDelight.MOD_ID, "textures/entity/morel_cow.png");

    public FDMCowRenderer(EntityRendererProvider.Context context) {
        super(context, new CowModel<>(context.bakeLayer(ModelLayers.MOOSHROOM)), 0.7F);
        this.addLayer(new FDMCowMushroomLayer(this, context.getBlockRenderDispatcher()));
    }

    @Override
    public ResourceLocation getTextureLocation(FDMCow entity) {
        if (entity.getType() == ModEntities.INKY_CAP_COW.get()) {
            return INKY_LOCATION;
        } else {
            return MOREL_LOCATION;
        }
    }
}
package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.entity.custom.FDMCow;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModEntities {
    // --- Deferred Register ---
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    // --- Entities Registry ---
    public static final DeferredHolder<EntityType<?>, EntityType<FDMCow>> INKY_CAP_COW = ENTITIES.register("inky_cap_cow",
            () -> EntityType.Builder.<FDMCow>of((type, level) -> new FDMCow(type, level, ModBlocks.INKY_CAP_MUSHROOM), MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .build("inky_cap_cow"));

    public static final DeferredHolder<EntityType<?>, EntityType<FDMCow>> MOREL_COW = ENTITIES.register("morel_cow",
            () -> EntityType.Builder.<FDMCow>of((type, level) -> new FDMCow(type, level, ModBlocks.MOREL_MUSHROOM), MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .build("morel_cow"));
}

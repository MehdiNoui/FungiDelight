package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.entity.custom.FDMCow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    // --- Deferred Register ---
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    // --- Entities Registry ---
    public static final RegistryObject<EntityType<FDMCow>> INKY_CAP_COW = ENTITIES.register("inky_cap_cow",
            () -> EntityType.Builder.<FDMCow>of((type, level) -> new FDMCow(type, level, ModBlocks.INKY_CAP_MUSHROOM), MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .build("inky_cap_cow"));

    public static final RegistryObject<EntityType<FDMCow>> MOREL_COW = ENTITIES.register("morel_cow",
            () -> EntityType.Builder.<FDMCow>of((type, level) -> new FDMCow(type, level, ModBlocks.MOREL_MUSHROOM), MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .build("morel_cow"));
}

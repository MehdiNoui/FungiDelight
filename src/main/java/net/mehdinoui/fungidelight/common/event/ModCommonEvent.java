package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModCommonEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.INKY_CAP_COW.get(), Cow.createAttributes().build());
        event.put(ModEntities.MOREL_COW.get(), Cow.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(
                ModEntities.INKY_CAP_COW.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        MushroomCow.checkMushroomSpawnRules((EntityType<MushroomCow>) (Object) entityType, level, spawnType, pos, random),
                RegisterSpawnPlacementsEvent.Operation.OR
        );

        event.register(
                ModEntities.MOREL_COW.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        MushroomCow.checkMushroomSpawnRules((EntityType<MushroomCow>) (Object) entityType, level, spawnType, pos, random),
                RegisterSpawnPlacementsEvent.Operation.OR
        );
    }
}
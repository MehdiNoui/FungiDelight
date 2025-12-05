package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.potion.ModBrewingRecipes;
import net.mehdinoui.fungidelight.common.registry.ModEntities;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvent {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 50%
            ComposterBlock.COMPOSTABLES.put(ModItems.CLEANED_CAPS.get(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(ModItems.TRUFFLE_SLICE.get(), 0.5f);
            // 65%
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_CLEANED_CAPS.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_STEM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_GOO_VEIL.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM_STEM.get(), 0.65f);
            // 85%
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_BLOCK.get(), 0.85f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_EDGE.get(), 0.85f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM_BLOCK.get(), 0.85f);
            // 100%
            ComposterBlock.COMPOSTABLES.put(ModItems.TRUFFLE.get(), 1.0f);
            ComposterBlock.COMPOSTABLES.put(ModItems.INKY_CAP_MUSHROOM_COLONY.get(), 1.0f);
            ComposterBlock.COMPOSTABLES.put(ModItems.MOREL_MUSHROOM_COLONY.get(), 1.0f);
        });

        ModBrewingRecipes.register();

        if (Configuration.ENABLE_PIG_FOODS.get()) {
            event.enqueueWork(() -> {
                Ingredient newPigFood = Ingredient.of(
                        Items.BROWN_MUSHROOM,
                        Items.RED_MUSHROOM,
                        ModItems.INKY_CAP_MUSHROOM.get(),
                        ModItems.MOREL_MUSHROOM.get(),
                        ModItems.TRUFFLE.get()
                );
                Pig.FOOD_ITEMS = new CompoundIngredient(Arrays.asList(Pig.FOOD_ITEMS, newPigFood)) {};
            });
        }
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.INKY_CAP_COW.get(), Cow.createAttributes().build());
        event.put(ModEntities.MOREL_COW.get(), Cow.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                ModEntities.INKY_CAP_COW.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        MushroomCow.checkMushroomSpawnRules((EntityType<MushroomCow>) (Object) entityType, level, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );

        event.register(
                ModEntities.MOREL_COW.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        MushroomCow.checkMushroomSpawnRules((EntityType<MushroomCow>) (Object) entityType, level, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
    }
}
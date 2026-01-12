package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.item.ModFoods;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties()
                .component(DataComponents.FOOD, food)
                .craftRemainder(Items.BOWL)
                .stacksTo(16);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // --- Entities spawn eggs ---
    public static final DeferredItem<SpawnEggItem> INKY_CAP_COW_SPAWN_EGG = ITEMS.register("inky_cap_cow_spawn_egg",
            () -> new SpawnEggItem(ModEntities.INKY_CAP_COW.get(), 0x303038, 0xadaeb5,
                    new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> MOREL_COW_SPAWN_EGG = ITEMS.register("morel_cow_spawn_egg",
            () -> new SpawnEggItem(ModEntities.MOREL_COW.get(), 0x544428, 0x302110,
                    new Item.Properties()));

    // ---- Items Registry ----
    public static final DeferredItem<Item> CLEANED_CAPS = ITEMS.register("cleaned_cap",
            () -> new Item(basicItem().component(DataComponents.FOOD, ModFoods.CLEANED_CAPS)));
    public static final DeferredItem<Item> COOKED_CLEANED_CAPS = ITEMS.register("cooked_cleaned_cap",
            () -> new Item(basicItem().component(DataComponents.FOOD, ModFoods.COOKED_CLEANED_CAPS)));

    public static final DeferredItem<Item> TRUFFLE = ITEMS.register("truffle",
            () -> new Item(basicItem().component(DataComponents.FOOD, ModFoods.TRUFFLE)));
    public static final DeferredItem<Item> TRUFFLE_SLICE = ITEMS.register("truffle_slice",
            () -> new Item(basicItem().component(DataComponents.FOOD, ModFoods.TRUFFLE_SLICE)));

    // --- Salads, Soups, Meals ---
    public static final DeferredItem<Item> INKY_CAPS_SALAD = ITEMS.register("inky_caps_salad",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.INKY_CAPS_SALAD)));
    public static final DeferredItem<Item> CREAMY_MOREL_SOUP = ITEMS.register("creamy_morel_soup",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.CREAMY_MOREL_SOUP)));
    public static final DeferredItem<Item> TRUFFLE_ICE_CREAM = ITEMS.register("truffle_ice_cream",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.TRUFFLE_ICE_CREAM)));
    public static final DeferredItem<Item> INKY_CAP_SCRAMBLED_EGGS = ITEMS.register("inky_cap_scrambled_eggs",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.INKY_CAP_SCRAMBLED_EGGS)));
    public static final DeferredItem<Item> TRUFFLE_PASTA = ITEMS.register("truffle_pasta",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.TRUFFLE_PASTA)));
    public static final DeferredItem<Item> STUFFED_MORELS = ITEMS.register("stuffed_morels",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.STUFFED_MORELS)));
    public static final DeferredItem<Item> STEAK_WITH_MUSHROOMS = ITEMS.register("steak_with_mushrooms",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.STEAK_WITH_MUSHROOMS)));
    public static final DeferredItem<Item> MUTTON_CHOPS_WITH_TRUFFLE = ITEMS.register("mutton_chops_with_truffle",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.MUTTON_CHOPS_WITH_TRUFFLE)));
    public static final DeferredItem<Item> RABBIT_WITH_MORELS = ITEMS.register("rabbit_with_morels",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.RABBIT_WITH_MORELS)));
    public static final DeferredItem<Item> PORK_MARSALA_WITH_MUSHROOMS = ITEMS.register("pork_marsala_with_mushrooms",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.PORK_MARSALA_WITH_MUSHROOMS)));

    // ---- Block Items ----
    public static final DeferredItem<Item> BROWN_MUSHROOM_CRATE = ITEMS.register("brown_mushroom_crate",
            () -> new BlockItem(ModBlocks.BROWN_MUSHROOM_CRATE.get(), basicItem()));
    public static final DeferredItem<Item> INKY_CAP_MUSHROOM_CRATE = ITEMS.register("inky_cap_mushroom_crate",
            () -> new BlockItem(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get(), basicItem()));
    public static final DeferredItem<Item> MOREL_MUSHROOM_CRATE = ITEMS.register("morel_mushroom_crate",
            () -> new BlockItem(ModBlocks.MOREL_MUSHROOM_CRATE.get(), basicItem()));
    public static final DeferredItem<Item> RED_MUSHROOM_CRATE = ITEMS.register("red_mushroom_crate",
            () -> new BlockItem(ModBlocks.RED_MUSHROOM_CRATE.get(), basicItem()));
    public static final DeferredItem<Item> TRUFFLE_CRATE = ITEMS.register("truffle_crate",
            () -> new BlockItem(ModBlocks.TRUFFLE_CRATE.get(), basicItem()));

    public static final DeferredItem<Item> INKY_CAP_MUSHROOM = ITEMS.register("inky_cap_mushroom",
            () -> new BlockItem(ModBlocks.INKY_CAP_MUSHROOM.get(), basicItem()));
    public static final DeferredItem<Item> MOREL_MUSHROOM = ITEMS.register("morel_mushroom",
            () -> new BlockItem(ModBlocks.MOREL_MUSHROOM.get(), basicItem()));

    public static final DeferredItem<Item> INKY_CAP_MUSHROOM_COLONY = ITEMS.register("inky_cap_mushroom_colony",
            () -> new MushroomColonyItem(ModBlocks.INKY_CAP_MUSHROOM_COLONY.get(), basicItem()));
    public static final DeferredItem<Item> MOREL_MUSHROOM_COLONY = ITEMS.register("morel_mushroom_colony",
            () -> new MushroomColonyItem(ModBlocks.MOREL_MUSHROOM_COLONY.get(), basicItem()));

    public static final DeferredItem<Item> TRUFFLE_DIRT = ITEMS.register("truffle_dirt",
            () -> new BlockItem(ModBlocks.TRUFFLE_DIRT.get(), basicItem()));

    public static final DeferredItem<Item> INKY_CAP_MUSHROOM_BLOCK = ITEMS.register("inky_cap_mushroom_block",
            () -> new BlockItem(ModBlocks.INKY_CAP_MUSHROOM_BLOCK.get(), basicItem()));
    public static final DeferredItem<Item> INKY_CAP_MUSHROOM_EDGE = ITEMS.register("inky_cap_mushroom_edge",
            () -> new BlockItem(ModBlocks.INKY_CAP_MUSHROOM_EDGE.get(), basicItem()));
    public static final DeferredItem<Item> INKY_CAP_MUSHROOM_STEM = ITEMS.register("inky_cap_mushroom_stem",
            () -> new BlockItem(ModBlocks.INKY_CAP_MUSHROOM_STEM.get(), basicItem()));
    public static final DeferredItem<Item> INKY_GOO_VEIL = ITEMS.register("inky_goo_veil",
            () -> new BlockItem(ModBlocks.INKY_GOO_VEIL.get(), basicItem()));

    public static final DeferredItem<Item> MOREL_MUSHROOM_BLOCK = ITEMS.register("morel_mushroom_block",
            () -> new BlockItem(ModBlocks.MOREL_MUSHROOM_BLOCK.get(), basicItem()));
    public static final DeferredItem<Item> MOREL_MUSHROOM_STEM = ITEMS.register("morel_mushroom_stem",
            () -> new BlockItem(ModBlocks.MOREL_MUSHROOM_STEM.get(), basicItem()));
}
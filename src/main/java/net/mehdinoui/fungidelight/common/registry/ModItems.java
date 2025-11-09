package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    // --- Deferred Register ---
    public final static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static Item.Properties basicItem() {
        return new Item.Properties();
    }
    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }
    public static Item.Properties stickFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.STICK).stacksTo(64);
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // --- Items Registry ---

    // --- Block Items ---
    public static final RegistryObject<Item> INKY_CAP_MUSHROOM = ITEMS.register("inky_cap_mushroom",
            () -> new BlockItem(ModBlocks.INKY_CAP_MUSHROOM.get(), basicItem()));
    public static final RegistryObject<Item> MOREL_MUSHROOM = ITEMS.register("morel_mushroom",
            () -> new BlockItem(ModBlocks.MOREL_MUSHROOM.get(), basicItem()));
}

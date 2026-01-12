package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.ModConfiguration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModVillagerEvents {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (ModConfiguration.ENABLE_VILLAGER_TRADES.get()) {
            if (event.getType() == VillagerProfession.FARMER) {
                List<VillagerTrades.ItemListing> level3Trades = event.getTrades().get(3);
                // Fungi Delight Colonies
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemCost(ModItems.INKY_CAP_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemCost(ModItems.MOREL_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                // Farmer's Delight Colonies
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemCost(vectorwing.farmersdelight.common.registry
                                .ModItems.BROWN_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemCost(vectorwing.farmersdelight.common.registry
                                .ModItems.RED_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemCost(ModItems.TRUFFLE.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
            }
        }
    }

    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        if (ModConfiguration.ENABLE_WANDERING_TRADER_SELLS.get()) {
            List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.INKY_CAP_MUSHROOM.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.MOREL_MUSHROOM.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.INKY_GOO_VEIL.get()), 12, 1, 0.05f));
        }
    }
}
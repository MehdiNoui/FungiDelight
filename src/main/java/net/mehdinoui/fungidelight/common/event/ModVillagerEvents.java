package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModVillagerEvents {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (Configuration.ENABLE_VILLAGER_TRADES.get()) {
            if (event.getType() == VillagerProfession.FARMER) {
                List<VillagerTrades.ItemListing> level3Trades = event.getTrades().get(3);
                // Fungi Delight Colonies
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.INKY_CAP_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.MOREL_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                // Farmer's Delight Colonies
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(vectorwing.farmersdelight.common.registry
                                .ModItems.BROWN_MUSHROOM_COLONY.get(), 4),
                        new ItemStack(Items.EMERALD, 1),
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(vectorwing.farmersdelight.common.registry
                                .ModItems.RED_MUSHROOM_COLONY.get(), 4),
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
        if (Configuration.ENABLE_WANDERING_TRADER_SELLS.get()) {
            List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.INKY_CAP_MUSHROOM.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.MOREL_MUSHROOM.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.INKY_GOO_VEIL.get()), 12, 1, 0.05f));
        }
    }
}
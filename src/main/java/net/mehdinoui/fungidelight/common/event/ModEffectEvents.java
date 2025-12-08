package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModEffectEvents {
    @SubscribeEvent
    public static void onBreakSpeed(net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed event) {
        if (!Configuration.ENABLE_BURROWING_EFFECT.get()) return;
        if (!event.getEntity().hasEffect(ModEffects.BURROWING.get())) {
            return;
        }
        if (event.getState().is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            int amplifier = Objects.requireNonNull(event.getEntity().getEffect(ModEffects.BURROWING.get())).getAmplifier();
            float multiplier = 1.5F + (0.5F * amplifier);
            event.setNewSpeed(event.getOriginalSpeed() * multiplier);
        }
    }
    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (!Configuration.ENABLE_WEAK_STOMACH_EFFECT.get()) return;
        if (event.getEntity().level().isClientSide) return;
        ItemStack consumedItem = event.getItem();
        if (event.getEntity().hasEffect(ModEffects.WEAK_STOMACH.get())) {
            ResourceLocation itemID = ForgeRegistries.ITEMS.getKey(consumedItem.getItem());
            boolean isPotion = consumedItem.getItem() instanceof PotionItem
                    && PotionUtils.getPotion(consumedItem) != Potions.WATER;
            boolean isAlcohol = consumedItem.is(FungiDelightTags.ALCOHOL);
            boolean isConfigured = itemID != null
                    && Configuration.WEAK_STOMACH_ITEMS.get().contains(itemID.toString());
            if (isPotion || isAlcohol || isConfigured) triggerReaction(event.getEntity());
        } else {
            boolean isCoprine = consumedItem.is(FungiDelightTags.ALCOHOL_REACTION);
            if (isCoprine) event.getEntity().addEffect(
                    new MobEffectInstance(ModEffects.WEAK_STOMACH.get(), 1200, 0));
        }
    }
    private static void triggerReaction(LivingEntity entity) {
        if (!Configuration.ENABLE_WEAK_STOMACH_EFFECT.get()) return;
        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
    }
}

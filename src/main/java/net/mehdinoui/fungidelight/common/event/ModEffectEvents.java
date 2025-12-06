package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModEffectEvents {
    @SubscribeEvent
    public static void onBreakSpeed(net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed event) {
        if (!Configuration.ENABLE_BURROWING_POTION.get()) return;
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
        if (event.getEntity().level().isClientSide) return;
        if (event.getEntity().hasEffect(ModEffects.WEAK_STOMACH.get())) {
            ItemStack consumedItem = event.getItem();
            boolean isPotion = consumedItem.getItem() instanceof PotionItem
                    && PotionUtils.getPotion(consumedItem) != Potions.WATER;
            if (isPotion) {
                triggerReaction(event.getEntity());
            }
        }
    }
    private static void triggerReaction(LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
    }
}

package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.ModConfiguration;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.Objects;

@EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModEffectEvents {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (!ModConfiguration.ENABLE_BURROWING_EFFECT.get()) return;
        if (!event.getEntity().hasEffect(ModEffects.BURROWING)) return;

        if (event.getState().is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            int amplifier = Objects.requireNonNull(event.getEntity().getEffect(ModEffects.BURROWING)).getAmplifier();
            float multiplier = 1.5F + (0.5F * amplifier);
            event.setNewSpeed(event.getOriginalSpeed() * multiplier);
        }
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (!ModConfiguration.ENABLE_WEAK_STOMACH_EFFECT.get()) return;
        if (event.getEntity().level().isClientSide) return;

        ItemStack consumedItem = event.getItem();
        LivingEntity entity = event.getEntity();

        if (entity.hasEffect(ModEffects.WEAK_STOMACH)) {
            ResourceLocation itemID = BuiltInRegistries.ITEM.getKey(consumedItem.getItem());

            PotionContents contents = consumedItem.get(DataComponents.POTION_CONTENTS);
            boolean isPotion = consumedItem.getItem() instanceof PotionItem
                    && contents != null
                    && !contents.is(Potions.WATER);

            boolean isAlcohol = consumedItem.is(FungiDelightTags.ALCOHOL);

            boolean isConfigured = itemID != null
                    && ModConfiguration.WEAK_STOMACH_ITEMS.get().contains(itemID.toString());

            if (isPotion || isAlcohol || isConfigured) {
                triggerReaction(entity);
            }
        } else {
            boolean isCoprine = consumedItem.is(FungiDelightTags.ALCOHOL_REACTION);
            if (isCoprine) {
                entity.addEffect(new MobEffectInstance(ModEffects.WEAK_STOMACH, 1200, 0));
            }
        }
    }

    private static void triggerReaction(LivingEntity entity) {
        if (!ModConfiguration.ENABLE_WEAK_STOMACH_EFFECT.get()) return;
        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1)); // CONFUSION is now NAUSEA
        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
    }
}
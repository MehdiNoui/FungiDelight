package net.mehdinoui.fungidelight.client.event;

import net.mehdinoui.fungidelight.ModConfiguration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = FungiDelight.MOD_ID,
        value = Dist.CLIENT)
public class ModTooltipEvents {
    @SubscribeEvent
    public static void onCoprineItemTooltip(ItemTooltipEvent event) {
        if (!ModConfiguration.ENABLE_WEAK_STOMACH_EFFECT.get()) return;
        ItemStack stack = event.getItemStack();
        if (stack.is(FungiDelightTags.ALCOHOL_REACTION)) {
            event.getToolTip().add(Component.translatable("tooltip.fungidelight.weak_stomach_desc")
                    .withStyle(ChatFormatting.RED));
        }
    }

    @SubscribeEvent
    public static void onPotionTooltip(ItemTooltipEvent event) {
        if (!ModConfiguration.ENABLE_BURROWING_EFFECT.get()) return;

        ItemStack stack = event.getItemStack();
        // Check if item can even have potion effects
        if (!stack.has(DataComponents.POTION_CONTENTS)) return;

        // 1.21.1: Get effects from PotionContents component instead of PotionUtils
        PotionContents contents = stack.get(DataComponents.POTION_CONTENTS);
        if (contents == null) return;

        MobEffectInstance burrowingInstance = null;
        for (MobEffectInstance effect : contents.getAllEffects()) {
            // Compare using the Holder (getDelegate())
            if (effect.getEffect().equals(ModEffects.BURROWING.getDelegate())) {
                burrowingInstance = effect;
                break;
            }
        }

        if (burrowingInstance != null) {
            List<Component> tooltip = event.getToolTip();

            // Logic for calculation
            String boostText = (burrowingInstance.getAmplifier() == 0) ? "50%" : "100%";

            Component header = Component.translatable("potion.whenDrank").withStyle(ChatFormatting.DARK_PURPLE);
            Component statLine = Component.translatable("tooltip.fungidelight.burrowing_desc", boostText)
                    .withStyle(ChatFormatting.BLUE);

            // Scannable check for existing header
            boolean headerExists = tooltip.stream()
                    .anyMatch(c -> c.getString().equals(header.getString()));

            if (!headerExists) {
                tooltip.add(Component.empty());
                tooltip.add(header);
            }
            tooltip.add(statLine);
        }
    }
}
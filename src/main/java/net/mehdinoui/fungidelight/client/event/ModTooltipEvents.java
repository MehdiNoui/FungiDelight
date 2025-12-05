package net.mehdinoui.fungidelight.client.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID,
        value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModTooltipEvents {
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        if (!Configuration.ENABLE_BURROWING_POTION.get()) return;
        ItemStack stack = event.getItemStack();
        if (stack.getItem() != Items.POTION && stack.getItem() != Items.SPLASH_POTION
                && stack.getItem() != Items.LINGERING_POTION && stack.getItem() != Items.TIPPED_ARROW) {
            return;
        }

        List<MobEffectInstance> effects = net.minecraft.world.item.alchemy.PotionUtils.getMobEffects(stack);
        MobEffectInstance burrowingInstance = null;
        for (MobEffectInstance effect : effects) {
            if (effect.getEffect() == ModEffects.BURROWING.get()) {
                burrowingInstance = effect;
                break;
            }
        }

        if (burrowingInstance != null) {
            // Set up lines
            List<Component> tooltip = event.getToolTip();
            String boostText = (burrowingInstance.getAmplifier() == 0) ? "50%" : "100%";
            Component header = Component.translatable("potion.whenDrank").withStyle(ChatFormatting.DARK_PURPLE);
            Component statLine = Component.translatable("tooltip.fungidelight.burrowing_desc", boostText)
                    .withStyle(ChatFormatting.BLUE);

            // Check if the "When Applied" header already exists
            boolean headerExists = false;
            for (Component component : tooltip) {
                if (component.getString().equals(header.getString())) {
                    headerExists = true;
                    break;
                }
            }
            // Add lines
            if (!headerExists) {
                tooltip.add(Component.empty());
                tooltip.add(header);
            }
            tooltip.add(statLine);
        }
    }
}
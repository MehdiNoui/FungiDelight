package net.mehdinoui.fungidelight.common.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModInteractionEvents {
    public static final String HUNTING_TAG = "fungidelight.dog_hunting_timer";
    public static final int HUNT_DURATION = 20 * 60 * 2;

    @SubscribeEvent
    public static void onDogInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof Wolf wolf && wolf.isTame()) {
            ItemStack itemStack = event.getItemStack();
            if (itemStack.is(ModItems.TRUFFLE.get())) {
                if (!event.getLevel().isClientSide) {
                    long endTime = event.getLevel().getGameTime() + HUNT_DURATION;
                    wolf.getPersistentData().putLong(HUNTING_TAG, endTime);
                    wolf.playSound(SoundEvents.WOLF_PANT, 1.0F, 1.2F);
                }
                // Successful Interaction Particles
                if (event.getLevel().isClientSide) {
                    for(int i = 0; i < 7; ++i) {
                        double d0 = event.getLevel().random.nextGaussian() * 0.02D;
                        double d1 = event.getLevel().random.nextGaussian() * 0.02D;
                        double d2 = event.getLevel().random.nextGaussian() * 0.02D;
                        event.getLevel().addParticle(ParticleTypes.HAPPY_VILLAGER,
                                wolf.getRandomX(1.0D), wolf.getRandomY() + 0.5D, wolf.getRandomZ(1.0D), d0, d1, d2);
                    }
                }
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true); // Prevent default interaction (like opening GUI)
            }
        }
    }
}
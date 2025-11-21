package net.mehdinoui.fungidelight.server.event;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.client.event.ModInteractionEvents;
import net.mehdinoui.fungidelight.common.entity.ai.pig.TruffleDiggingGoal;
import net.mehdinoui.fungidelight.common.entity.ai.wolf.DogTruffleHuntGoal;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModForgeEvents {
    @SubscribeEvent
    public static void addCustomGoals(EntityJoinLevelEvent event) {
        // --- PIG LOGIC ---
        if (event.getEntity() instanceof Pig pig) {
            if (pig.goalSelector.getAvailableGoals().stream().anyMatch(
                    wrappedGoal -> wrappedGoal.getGoal() instanceof TruffleDiggingGoal)) {
                return;
            }
            if (Configuration.ENABLE_PIG_DIGGING.get()) {
                pig.goalSelector.addGoal(5, new TruffleDiggingGoal(pig));
            }
        }
        // --- WOLF LOGIC ---
        if (event.getEntity() instanceof Wolf wolf) {
            if (wolf.goalSelector.getAvailableGoals().stream().anyMatch(
                    wrappedGoal -> wrappedGoal.getGoal() instanceof DogTruffleHuntGoal)) {
                return;
            }
            if (Configuration.ENABLE_WOLF_HUNT_TRUFFLE.get()) {
                wolf.goalSelector.addGoal(2, new DogTruffleHuntGoal(wolf));
            }
        }
    }
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (!event.getEntity().level().isClientSide && event.getEntity() instanceof Wolf wolf) {
            // Check for Hunting Tag
            if (wolf.getPersistentData().contains(ModInteractionEvents.HUNTING_TAG)) {
                long endTime = wolf.getPersistentData().getLong(ModInteractionEvents.HUNTING_TAG);
                // Particles Indicator that the dog is in truffle hunting mode
                if (wolf.level().getGameTime() < endTime) {
                    ServerLevel serverLevel = (ServerLevel) wolf.level();
                    if (wolf.tickCount % 4 == 0) {
                        serverLevel.sendParticles(ParticleTypes.MYCELIUM,
                                wolf.getX(), wolf.getY() + 0.5, wolf.getZ(),
                                3,
                                0.3, 0.3, 0.3,
                                0.05
                        );
                    }
                }
            }
        }
    }
}
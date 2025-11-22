package net.mehdinoui.fungidelight.common.entity.ai.wolf;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.client.event.ModInteractionEvents;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;

public class DogTruffleHuntGoal extends Goal {
    // Properties
    private final Wolf wolf;
    private final Level level;
    private BlockPos targetTrufflePos;
    private BlockPos targetSurfacePos;

    // State Tracking
    private int barkTimer = 9;
    private int offBlockTimer = 9;

    // Constants
    private static final int SEARCH_RADIUS = 12;
    private static final int SEARCH_DEPTH = 4;
    private static final int SUCCESS_TIME = 40; // 2 Seconds for success
    private static final int MAX_GIVE_UP_TICKS = 100; // 5 Seconds to reach the block before giving up

    public DogTruffleHuntGoal(Wolf wolf) {
        this.wolf = wolf;
        this.level = wolf.level();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    // --- Helper Methods ---
    private boolean isHunting() {
        if (!this.wolf.getPersistentData().contains(ModInteractionEvents.HUNTING_TAG)) return false;
        long endTime = this.wolf.getPersistentData().getLong(ModInteractionEvents.HUNTING_TAG);
        return this.level.getGameTime() < endTime;
    }

    private void completeHunt() {
        this.wolf.getPersistentData().remove(ModInteractionEvents.HUNTING_TAG);
    }

    private BlockPos findNearestTruffle() {
        BlockPos origin = this.wolf.blockPosition();
        BlockPos best = null;
        double bestDist = Double.MAX_VALUE;
        // Getting Best path
        for (BlockPos pos : BlockPos.betweenClosed(
                origin.offset(-SEARCH_RADIUS, -SEARCH_DEPTH, -SEARCH_RADIUS),
                origin.offset(SEARCH_RADIUS, -1, SEARCH_RADIUS)
        )) {
            if (this.level.getBlockState(pos).is(ModBlocks.TRUFFLE_DIRT.get())) {
                double dist = pos.distSqr(origin);
                if (dist < bestDist) {
                    bestDist = dist;
                    best = pos.immutable();
                }
            }
        }
        return best;
    }

    // --- AI Logic ---
    @Override
    public boolean canUse() {
        // Config Option Check
        if (!Configuration.ENABLE_WOLF_HUNT_TRUFFLE.get()) return false;
        // Basic State Checks
        if (!this.wolf.isTame() || this.wolf.isOrderedToSit() || this.wolf.getTarget() != null || !isHunting()) return false;
        // Find Truffle
        this.targetTrufflePos = findNearestTruffle();
        return this.targetTrufflePos != null;
    }

    @Override
    public boolean canContinueToUse() {
        boolean targetBlockStillValid = this.targetTrufflePos != null && this.level.getBlockState(this.targetTrufflePos).is(ModBlocks.TRUFFLE_DIRT.get());
        return isHunting()
                && targetBlockStillValid
                && !this.wolf.isOrderedToSit()
                && this.offBlockTimer < MAX_GIVE_UP_TICKS
                && this.wolf.getTarget() == null;
    }

    @Override
    public void start() {
        this.barkTimer = 0;
        this.offBlockTimer = 0;
        // Logic to find surface block
        this.targetSurfacePos = this.targetTrufflePos.above();
        while (this.level.getBlockState(this.targetSurfacePos).isSolidRender(this.level, this.targetSurfacePos)) {
            this.targetSurfacePos = this.targetSurfacePos.above();
            if (this.targetSurfacePos.getY() > this.targetTrufflePos.getY() + 5) break;
        }
        // Checks if it's possible to go to that spot
        boolean pathSuccess = this.wolf.getNavigation().moveTo(
                targetSurfacePos.getX() + 0.5, targetSurfacePos.getY(), targetSurfacePos.getZ() + 0.5, 1.2D
        );
        if (!pathSuccess) {
            // Abort if pathfinding failed
            this.offBlockTimer = MAX_GIVE_UP_TICKS;
            this.wolf.getNavigation().stop();
        }
        // Initial sound
        this.wolf.playSound(SoundEvents.WOLF_GROWL, 1.0F, 1.0F);
    }

    @Override
    public void tick() {
        if (targetSurfacePos == null || !(level instanceof ServerLevel serverLevel)) return;

        // Calculate distance
        double distSqr = this.wolf.distanceToSqr(
                targetSurfacePos.getX() + 0.5,
                targetSurfacePos.getY(),
                targetSurfacePos.getZ() + 0.5);

        // --- Movement Phase ---
        if (distSqr > 2.5D) { // Approx 1.5 blocks away
            this.offBlockTimer++;
            if (this.wolf.getNavigation().isDone() || this.offBlockTimer % 20 == 0) {
                boolean pathSuccess = this.wolf.getNavigation().moveTo(
                        targetSurfacePos.getX() + 0.5,
                        targetSurfacePos.getY(),
                        targetSurfacePos.getZ() + 0.5,
                        1.2D
                );
                if (!pathSuccess) {
                    this.offBlockTimer += 10;
                }
            }
            return; // Don't execute success logic yet
        }

        // --- Success Phase (Arrived) ---
        this.offBlockTimer = 0;
        this.wolf.getNavigation().stop();
        // Look at the target
        this.wolf.getLookControl().setLookAt(
                targetSurfacePos.getX() + 0.5,
                targetSurfacePos.getY() - 0.5,
                targetSurfacePos.getZ() + 0.5,
                10.0F,
                this.wolf.getMaxHeadXRot()
        );

        // Security Check: Did the block change?
        if (this.targetTrufflePos == null || !this.level.getBlockState(this.targetTrufflePos).is(ModBlocks.TRUFFLE_DIRT.get())) {
            this.barkTimer = 0;
            return;
        }

        // Success Sound (Play once)
        if (this.barkTimer == 0) {
            this.wolf.playSound(SoundEvents.WOLF_HOWL, 1.0F, 1.0F); // Pitch 1.2 is a bit high/squeaky, 1.0 is standard
        }

        // Success particles
        if (this.barkTimer % 5 == 0 ) {
            BlockState blockState = this.level.getBlockState(this.targetSurfacePos);
            serverLevel.sendParticles(
                    new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                    this.targetSurfacePos.getX() + 0.5D,
                    this.targetSurfacePos.getY() + 1.0D,
                    this.targetSurfacePos.getZ() + 0.5D,
                    6, 0.3D, 0.1D, 0.3D, 0.15D
            );
        }
        this.barkTimer++;
        if (this.barkTimer > SUCCESS_TIME) {
            completeHunt();
        }
    }

    @Override
    public void stop() {
        if (this.barkTimer <= SUCCESS_TIME) {
            completeHunt();
        }
        // Cleanup
        this.targetTrufflePos = null;
        this.targetSurfacePos = null;
        this.barkTimer = 0;
        this.offBlockTimer = 0;
        this.wolf.getNavigation().stop();
    }
}
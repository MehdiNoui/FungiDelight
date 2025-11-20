package net.mehdinoui.fungidelight.common.entity.ai;

import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.EnumSet;
import java.util.List;

public class TruffleDiggingGoal extends Goal {
    // Properties
    private final Pig pig;
    private final Level level;
    private BlockPos targetBlock = null;

    // Digging Loot
    public static final ResourceLocation DIGGING_LOOT = new ResourceLocation(FungiDelight.MOD_ID, "gameplay/pig_digging");

    // State Tracking
    private int digTime = 0;
    private int offBlockTimer = 0;
    private int cooldown = 0;
    private boolean hasFinishedDigging = false;

    // Constants
    private static final int SEARCH_RADIUS = 6;
    private static final int DIG_DURATION = 60; // 3 Seconds of digging
    private static final int MAX_GIVE_UP_TICKS = 100; // 5 Seconds to reach the block before giving up

    // Rarity
    private static final Double DIG_CHANCE = Configuration.CHANCE_PIG_DIGGING.get();

    public TruffleDiggingGoal(Pig pig) {
        this.pig = pig;
        this.level = pig.level();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    // --- Helper Methods ---
    private void lookAtTarget() {
        if (targetBlock != null) {
            this.pig.getLookControl().setLookAt(
                    this.targetBlock.getX() + 0.5D,
                    this.targetBlock.getY() + 0.5D,
                    this.targetBlock.getZ() + 0.5D,
                    10.0F,
                    this.pig.getMaxHeadXRot()
            );
        }
    }

    private void navigateToTarget() {
        if (targetBlock != null) {
            this.pig.getNavigation().moveTo(
                    this.targetBlock.getX() + 0.5D,
                    this.targetBlock.getY(),
                    this.targetBlock.getZ() + 0.5D,
                    1.0D
            );
        }
    }

    private BlockPos findNearestPODZOL() {
        BlockPos origin = this.pig.blockPosition();
        BlockPos best = null;
        double bestDist = Double.MAX_VALUE;

        for (BlockPos pos : BlockPos.betweenClosed(
                origin.offset(-SEARCH_RADIUS, -1, -SEARCH_RADIUS),
                origin.offset(SEARCH_RADIUS, 0, SEARCH_RADIUS)
        )) {
            // Must be Podzol AND have air above it
            if (level.getBlockState(pos).is(Blocks.PODZOL) && level.isEmptyBlock(pos.above())) {
                double dist = pos.distSqr(origin);
                if (dist < bestDist) {
                    bestDist = dist;
                    best = pos.immutable();
                }
            }
        }
        return best;
    }

    private void dropLoot() {
        if (this.level instanceof ServerLevel serverLevel) {
            LootTable lootTable = serverLevel.getServer().getLootData().getLootTable(DIGGING_LOOT);
            List<ItemStack> items = lootTable.getRandomItems(
                    new LootParams.Builder(serverLevel)
                            .withParameter(LootContextParams.ORIGIN, this.pig.position())
                            .withParameter(LootContextParams.THIS_ENTITY, this.pig)
                            .create(LootContextParamSets.PIGLIN_BARTER)
            );

            for (ItemStack item : items) {
                ItemEntity itemEntity = new ItemEntity(this.level,
                        this.targetBlock.getX() + 0.5D,
                        this.targetBlock.getY() + 1.0D,
                        this.targetBlock.getZ() + 0.5D,
                        item);
                itemEntity.setDeltaMovement(0, 0.25, 0);
                this.level.addFreshEntity(itemEntity);
            }
        }
    }
    // --- AI Logic ---
    @Override
    public boolean canUse() {
        // Config Option Check
        if (!Configuration.ENABLE_PIG_TRUFFLE_DIGGING.get()){
            return false;
        }
        // Cooldown Check
        if (cooldown > 0) {
            cooldown--;
            return false;
        }
        // Basic State Checks
        if (!this.pig.onGround() || this.pig.isBaby()) {
            return false;
        }
        // Rarity Check
        if (this.level.random.nextFloat() >= DIG_CHANCE) {
            return false;
        }
        targetBlock = findNearestPODZOL();
        return targetBlock != null;
    }

    @Override
    public boolean canContinueToUse() {
        return this.digTime > 0
                && this.targetBlock != null
                && this.pig.hurtTime <= 0
                && this.pig.onGround()
                && this.offBlockTimer < MAX_GIVE_UP_TICKS
                && !this.hasFinishedDigging;
    }

    @Override
    public void start() {
        this.digTime = DIG_DURATION;
        this.offBlockTimer = 0;
        this.hasFinishedDigging = false;
        // Stop wandering and go to the podzol
        this.pig.getNavigation().stop();
        navigateToTarget();
        // Initial sound
        this.level.playSound(null, this.pig, SoundEvents.HOGLIN_RETREAT, SoundSource.NEUTRAL, 1.0F, 1.0F);
        lookAtTarget();
    }

    @Override
    public void tick() {
        if (targetBlock == null) return;
        // Calculate distance to the block
        double distSqr = this.pig.distanceToSqr(
                targetBlock.getX() + 0.5,
                targetBlock.getY() + 1,
                targetBlock.getZ() + 0.5);
        // Movement Phase
        if (distSqr > 2.25D) { // > 1.5 blocks away
            this.offBlockTimer++;
            if (this.pig.getNavigation().isDone()) {
                navigateToTarget(); // Recalculate path if it stopped early
            }
            lookAtTarget();
            return;
        }
        // Digging Phase
        this.offBlockTimer = 0;
        this.pig.getNavigation().stop();
        lookAtTarget();
        // Security Check
        if (!level.getBlockState(targetBlock).is(Blocks.PODZOL)) {
            this.digTime = 0; // Abort
            return;
        }
        // Decrement timer
        this.digTime = Math.max(0, this.digTime - 1);
        // Particles & Sound
        if (this.digTime > 0) {
            if (this.digTime % 5 == 0 && this.level instanceof ServerLevel serverLevel) {
                BlockState blockState = this.level.getBlockState(this.targetBlock);
                serverLevel.sendParticles(
                        new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                        this.targetBlock.getX() + 0.5D,
                        this.targetBlock.getY() + 1.0D,
                        this.targetBlock.getZ() + 0.5D,
                        6, 0.3D, 0.1D, 0.3D, 0.15D
                );
                this.level.playSound(null, this.pig, SoundEvents.ROOTED_DIRT_BREAK, SoundSource.NEUTRAL, 0.5F, 0.8F);
            }
        } else {
            this.hasFinishedDigging = true;
        }
    }

    @Override
    public void stop() {
        if (this.hasFinishedDigging && this.targetBlock != null && level.getBlockState(targetBlock).is(Blocks.PODZOL)) {
            // --- SUCCESS ---
            // Success sounds
            this.level.playSound(null, this.targetBlock, SoundEvents.MUD_BREAK, SoundSource.NEUTRAL, 1.0F, 1.0F);
            this.level.playSound(null, this.targetBlock, SoundEvents.CHICKEN_EGG, SoundSource.NEUTRAL, 1.0F, 1.0F);
            // Drop Truffle
            this.dropLoot();
            // Convert Block
            this.level.setBlockAndUpdate(this.targetBlock, Blocks.COARSE_DIRT.defaultBlockState());
            // Cooldown (2400 ticks = 2 Minutes)
            this.cooldown = 2400;
        } else {
            // --- FAILURE / ABORT ---
            // The pig didn't finish, or block broke, or path failed.
            // Apply Short Cooldown so it can try again soon.
            // 200 ticks = 10 Seconds
            this.cooldown = 200;
        }
        // Cleanup
        this.targetBlock = null;
        this.hasFinishedDigging = false;
        this.pig.getNavigation().stop();
    }
}
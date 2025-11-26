package net.mehdinoui.fungidelight.common.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class FDMCow extends MushroomCow {
    private final Supplier<Block> mushroom;
    public FDMCow(EntityType<? extends MushroomCow> type, Level level, Supplier<Block> mushroom) {
        super(type, level);
        this.mushroom = mushroom;
    }

    // --- Helper Method ---
    public net.minecraft.world.level.block.state.BlockState getMushroomBlockState() {
        return this.mushroom.get().defaultBlockState();
    }

    @Override
    public void thunderHit(ServerLevel level, LightningBolt bolt) {
        return; // Disable Thunder Hit
    }

    @Override
    public List<ItemStack> onSheared(@Nullable Player player, @NotNull ItemStack item, Level world, BlockPos pos, int fortune) {
        this.gameEvent(GameEvent.SHEAR, player);
        this.level().playSound(null, this, SoundEvents.MOOSHROOM_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        if (!this.level().isClientSide()) {
            Cow cow = EntityType.COW.create(this.level());
            if (cow != null) {
                ((ServerLevel)this.level()).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                cow.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
                cow.setHealth(this.getHealth());
                cow.yBodyRot = this.yBodyRot;
                if (this.hasCustomName()) {
                    cow.setCustomName(this.getCustomName());
                    cow.setCustomNameVisible(this.isCustomNameVisible());
                }
                if (this.isPersistenceRequired()) {
                    cow.setPersistenceRequired();
                }

                cow.setInvulnerable(this.isInvulnerable());
                this.discard();
                this.level().addFreshEntity(cow);

                List<ItemStack> items = new ArrayList<>();
                for (int i = 0; i < 5; ++i) {
                    items.add(new ItemStack(this.mushroom.get()));
                }
                return items;
            }
        }
        return Collections.emptyList();
    }
}
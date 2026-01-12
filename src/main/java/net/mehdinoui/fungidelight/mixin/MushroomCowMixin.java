package net.mehdinoui.fungidelight.mixin;

import net.mehdinoui.fungidelight.common.entity.custom.FDMCow;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.MushroomCow;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MushroomCow.class)
public abstract class MushroomCowMixin extends Animal {
    protected MushroomCowMixin(net.minecraft.world.entity.EntityType<? extends Animal> type, net.minecraft.world.level.Level level) {
        super(type, level);
    }
    @Override
    public boolean canMate(Animal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (otherAnimal instanceof FDMCow && this.isInLove() && otherAnimal.isInLove()) {
            return true;
        } else {
            return super.canMate(otherAnimal);
        }
    }
}
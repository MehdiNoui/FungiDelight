package net.mehdinoui.fungidelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class WeakStomachEffect extends MobEffect {
    public WeakStomachEffect() {
        super(MobEffectCategory.HARMFUL, 0x4C5578);
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false;
    }
}

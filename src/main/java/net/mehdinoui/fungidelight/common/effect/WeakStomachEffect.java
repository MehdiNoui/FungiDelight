package net.mehdinoui.fungidelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class WeakStomachEffect extends MobEffect {
    public WeakStomachEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x0E101C);
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false;
    }
}

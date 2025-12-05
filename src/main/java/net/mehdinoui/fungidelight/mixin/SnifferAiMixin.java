package net.mehdinoui.fungidelight.mixin;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.world.entity.animal.sniffer.SnifferAi;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.CompoundIngredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(SnifferAi.class)
public class SnifferAiMixin {
    @Inject(method = "getTemptations", at = @At("RETURN"), cancellable = true)
    private static void addTruffleToSnifferTemptation(CallbackInfoReturnable<Ingredient> cir) {
        cir.setReturnValue(new CompoundIngredient(
                Arrays.asList(cir.getReturnValue(),
                        Ingredient.of(ModItems.TRUFFLE.get()))) {}
        );
    }
}

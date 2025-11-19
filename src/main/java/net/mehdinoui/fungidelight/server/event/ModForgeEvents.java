package net.mehdinoui.fungidelight.server.event;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.entity.ai.TruffleDiggingGoal; // Your goal class
import net.minecraft.world.entity.animal.Pig;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class ModForgeEvents {
    @SubscribeEvent
    public static void addCustomGoals(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Pig pig) {
            if (pig.goalSelector.getAvailableGoals().stream().anyMatch(
                    wrappedGoal -> wrappedGoal.getGoal() instanceof TruffleDiggingGoal)) {
                return;
            }
            pig.goalSelector.addGoal(5, new TruffleDiggingGoal(pig));
        }
    }
}
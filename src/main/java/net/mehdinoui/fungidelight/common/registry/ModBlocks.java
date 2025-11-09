package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.block.mushrooms.InkyCapBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    // --- Deferred Register ---
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // --- Blocks Registry ---
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM = BLOCKS.register("inky_cap_mushroom",
            () -> new InkyCapBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)));
}

package net.mehdinoui.fungidelight.common.registry;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.block.mushrooms.InkyCapMushroomBlock;
import net.mehdinoui.fungidelight.common.block.mushrooms.InkyGooVeilBlock;
import net.mehdinoui.fungidelight.common.block.mushrooms.MorelMushroomBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

public class ModBlocks {
    // --- Deferred Register ---
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FungiDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // --- Blocks Registry ---
    // Mushrooms
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM = BLOCKS.register("inky_cap_mushroom",
            () -> new InkyCapMushroomBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)));
    public static final RegistryObject<Block> MOREL_MUSHROOM = BLOCKS.register("morel_mushroom",
            () -> new MorelMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)));
    // Mushrooms Blocks
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM_BLOCK = BLOCKS.register("inky_cap_mushroom_block",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM_STEM = BLOCKS.register("inky_cap_mushroom_stem",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM_EDGE = BLOCKS.register("inky_cap_mushroom_edge",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK)));

    public static final RegistryObject<Block> MOREL_MUSHROOM_BLOCK = BLOCKS.register("morel_mushroom_block",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK)));
    public static final RegistryObject<Block> MOREL_MUSHROOM_STEM = BLOCKS.register("morel_mushroom_stem",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));
    // Mushroom Colonies
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM_COLONY = BLOCKS.register("inky_cap_mushroom_colony",
            () -> new MushroomColonyBlock(Block.Properties.copy(Blocks.BROWN_MUSHROOM), ModItems.INKY_CAP_MUSHROOM));
    public static final RegistryObject<Block> MOREL_MUSHROOM_COLONY = BLOCKS.register("morel_mushroom_colony",
            () -> new MushroomColonyBlock(Block.Properties.copy(Blocks.BROWN_MUSHROOM), ModItems.MOREL_MUSHROOM));
    // Mushroom Crates
    public static final RegistryObject<Block> BROWN_MUSHROOM_CRATE = BLOCKS.register("brown_mushroom_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> INKY_CAP_MUSHROOM_CRATE = BLOCKS.register("inky_cap_mushroom_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MOREL_MUSHROOM_CRATE = BLOCKS.register("morel_mushroom_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_MUSHROOM_CRATE = BLOCKS.register("red_mushroom_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TRUFFLE_CRATE = BLOCKS.register("truffle_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // Inky Cap Goo
    public static final RegistryObject<Block> INKY_GOO_VEIL = BLOCKS.register("inky_goo_veil",
            () -> new InkyGooVeilBlock(BlockBehaviour.Properties.copy(Blocks.CAVE_VINES)));
    // Truffle Dirt
    public static final RegistryObject<Block> TRUFFLE_DIRT = BLOCKS.register("truffle_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

}

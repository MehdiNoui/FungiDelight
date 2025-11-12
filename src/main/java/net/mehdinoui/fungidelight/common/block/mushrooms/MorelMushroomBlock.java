package net.mehdinoui.fungidelight.common.block.mushrooms;

import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.tag.ModTags;

import static net.mehdinoui.fungidelight.common.registry.ModConfiguredFeatures.HUGE_MOREL_MUSHROOM;

public class MorelMushroomBlock extends MushroomBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 13.0D, 11.0D);

    public MorelMushroomBlock(Properties pProperties) {
        super(pProperties, HUGE_MOREL_MUSHROOM);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (level.getBlockState(pos.below()).is(ModTags.MUSHROOM_COLONY_GROWABLE_ON)) {
            if (random.nextInt(4) == 0) {
                level.setBlock(pos, ModBlocks.MOREL_MUSHROOM_COLONY.get().defaultBlockState(), 3);
            }
        }
    }
}

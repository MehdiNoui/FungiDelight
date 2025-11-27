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

import static net.mehdinoui.fungidelight.common.registry.ModConfiguredFeatures.HUGE_INKY_CAP_MUSHROOM;

public class InkyCapMushroomBlock extends MushroomBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public InkyCapMushroomBlock(Properties pProperties) {
        super(pProperties, HUGE_INKY_CAP_MUSHROOM);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide()) {
            if (level.getBlockState(pos.below()).is(ModTags.MUSHROOM_COLONY_GROWABLE_ON)) {
                if (random.nextInt(4) == 0) {
                    level.setBlockAndUpdate(pos, ModBlocks.INKY_CAP_MUSHROOM_COLONY.get().defaultBlockState());
                }
            } else {
                super.randomTick(state, level, pos, random);
            }
        }
    }
}

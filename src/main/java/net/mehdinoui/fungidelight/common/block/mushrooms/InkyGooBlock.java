package net.mehdinoui.fungidelight.common.block.mushrooms;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class InkyGooBlock extends Block {
    public static final BooleanProperty CONNECTED = BooleanProperty.create("connected");

    protected static final VoxelShape SHAPE_NORMAL = Block.box(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHAPE_CONNECTED = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public InkyGooBlock(BlockBehaviour.Properties properties) {
        super(properties.noOcclusion().instabreak().lightLevel(state -> 5).sound(SoundType.HONEY_BLOCK));
        this.registerDefaultState(this.stateDefinition.any().setValue(CONNECTED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CONNECTED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(CONNECTED) ? SHAPE_CONNECTED : SHAPE_NORMAL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        boolean connectedBelow = context.getLevel().getBlockState(pos.below()).is(this);
        return this.defaultBlockState().setValue(CONNECTED, connectedBelow);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, false);
        }
        if (direction == Direction.DOWN) {
            return state.setValue(CONNECTED, neighborState.is(this));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        return above.isFaceSturdy(level, pos.above(), Direction.DOWN) || above.is(this);
    }
}

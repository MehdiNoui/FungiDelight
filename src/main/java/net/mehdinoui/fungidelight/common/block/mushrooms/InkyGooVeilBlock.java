package net.mehdinoui.fungidelight.common.block.mushrooms;

import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ModTags;

public class InkyGooVeilBlock extends Block implements BonemealableBlock {
    public static final BooleanProperty CONNECTED = BooleanProperty.create("connected");

    protected static final VoxelShape SHAPE_NORMAL = Block.box(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHAPE_CONNECTED = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public InkyGooVeilBlock(BlockBehaviour.Properties properties) {
        super(properties.noOcclusion().instabreak().lightLevel(state -> 5).sound(SoundType.HONEY_BLOCK));
        this.registerDefaultState(this.stateDefinition.any().setValue(CONNECTED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CONNECTED);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
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

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isEmptyBlock(pos.below())) {
            if (!level.isClientSide()) {
                if (random.nextInt(16) == 0) {
                    this.performBonemeal(level, random, pos, state);
                } else {
                    super.randomTick(state, level, pos, random);
                }
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean pIsClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos target = pos;
        while (level.getBlockState(target.below()).is(this)) {
            target = target.below();
        }
        BlockPos below = target.below();
        if (level.isEmptyBlock(below) && this.defaultBlockState().canSurvive(level, below)) {
            level.setBlock(below, this.defaultBlockState().setValue(CONNECTED, false), 3);
        }
    }
}

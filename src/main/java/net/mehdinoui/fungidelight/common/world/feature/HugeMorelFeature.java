package net.mehdinoui.fungidelight.common.world.feature;

import com.mojang.serialization.Codec;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class HugeMorelFeature extends Feature<NoneFeatureConfiguration> {
    protected static int[][][] capLayers = new int[][][]{
            {{0, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 1}, {4, 2}, {4, 3}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 1}, {4, 2}, {4, 3}},
            {{0, 2}, {0, 3}, {0, 4}, {1, 1}, {1, 5}, {2, 0}, {2, 6}, {3, 0}, {3, 6}, {4, 0}, {4, 6}, {5, 1}, {5, 5}, {6, 2}, {6, 3}, {6, 4}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 1}, {4, 2}, {4, 3}}
    };
    public HugeMorelFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        LevelAccessor world = context.level();
        BlockPos pos = context.origin();
        // Check if valid below
        if (!world.getBlockState(pos.below()).isSolid()) {
            System.out.println("DEBUG: no valid surface");
            return false;
        }
        // Check if valid above
        for (int y = 0; y <= 6; y++) {
            BlockPos checkPos = pos.above(y);
            if (!world.getBlockState(checkPos).canBeReplaced()) {
                System.out.println("DEBUG: no valid air");
                return false;
            }
        }
        // Stem placement
        int stemHeight = 9 + context.random().nextInt(4);
        for (int y = 0; y < stemHeight; y++) {
            BlockPos stemPos = pos.above(y);
            // Fall-back check
            if (world.getBlockState(stemPos).canBeReplaced()) {
                world.setBlock(stemPos, ModBlocks.MOREL_MUSHROOM_STEM.get().defaultBlockState(), 3);
            }
        }
        // Cap placement
        BlockPos layerOrigin = pos.above(stemHeight);
        for (int i = 0; i < capLayers.length; i++) {
            placeCapLayer(world, layerOrigin.below(i), capLayers[i]);
        }
        return true;
    }

    // AI-Generated center compute because I'm a lazy fuck that won't amount to anything in his life
    private void placeCapLayer(LevelAccessor world, BlockPos center, int[][] offsets) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minZ = Integer.MAX_VALUE, maxZ = Integer.MIN_VALUE;
        for (int[] offset : offsets) {
            minX = Math.min(minX, offset[0]);
            maxX = Math.max(maxX, offset[0]);
            minZ = Math.min(minZ, offset[1]);
            maxZ = Math.max(maxZ, offset[1]);
        }
        int centerX = (minX + maxX) / 2;
        int centerZ = (minZ + maxZ) / 2;
        for (int[] offset : offsets) {
            int x = offset[0] - centerX;
            int z = offset[1] - centerZ;
            BlockPos blockPos = center.offset(x, 0, z);
            // check if it's replaceable, if not ignore and do nothing
            if (world.getBlockState(blockPos).canBeReplaced()) {
                world.setBlock(blockPos, ModBlocks.MOREL_MUSHROOM_BLOCK.get().defaultBlockState(), 3);
            }
        }
    }
}

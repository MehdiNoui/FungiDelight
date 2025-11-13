package net.mehdinoui.fungidelight.common.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public abstract class CustomHugeMushroomFeature extends Feature<NoneFeatureConfiguration> {
    protected CustomHugeMushroomFeature(com.mojang.serialization.Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }
    // Stem placing
    protected boolean placeStem(LevelAccessor world, BlockPos pos, int minHeight, int maxHeight, BlockState stemBlock) {
        int stemHeight = minHeight + world.getRandom().nextInt(maxHeight - minHeight + 1);
        for (int y = 0; y < stemHeight; y++) {
            BlockPos stemPos = pos.above(y);
            if (world.getBlockState(stemPos).canBeReplaced()) {
                world.setBlock(stemPos, stemBlock, 3);
            }
        }
        return stemHeight > 0;
    }

    // Cap placing
    protected void placeCapLayer(LevelAccessor world, BlockPos center, int[][] offsets, BlockState block, boolean hanging) {
        // This part is to get the center of each cap layer to properly place it around the stem.
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

        if (!hanging) { // For block placement
            for (int[] offset : offsets) {
                BlockPos blockPos = center.offset(offset[0] - centerX, 0, offset[1] - centerZ);
                // Check if it's replaceable, if not ignore and do nothing
                if (world.getBlockState(blockPos).canBeReplaced()) {
                    world.setBlock(blockPos, block, 3);
                }
            }
        } else { // For veils placement or anything with a chance
            var random = world.getRandom();
            for (int[] offset : offsets) {
                BlockPos blockPos = center.offset(offset[0] - centerX, 0, offset[1] - centerZ);
                // Check if it's replaceable, if not ignore and do nothing
                if (world.getBlockState(blockPos).canBeReplaced()
                        && random.nextFloat() < 0.6f) {
                    int length = 1 + random.nextInt(2); // either 1 or 2
                    for (int i = 0; i < length; i++) {
                        BlockPos hangingPos = blockPos.below(i);
                        if (world.getBlockState(hangingPos).canBeReplaced()) {
                            world.setBlock(hangingPos, block, 3);
                        } else break; // stop if it hits a solid block
                    }
                }
            }
        }
    }
    // This method checks if the mushroom got enough space
    protected boolean isValidSpace(LevelAccessor world, BlockPos pos, int mushroomHeight, int capHeight, int mushroomRadius) {
        // Checks if the ground is suitable for huge mushrooms
        if (!world.getBlockState(pos.below()).is(BlockTags.MUSHROOM_GROW_BLOCK)) return false;
        // Cheks for world height safety
        if (pos.getY() + mushroomHeight >= world.getMaxBuildHeight()) return false;
        // Checks if nothing is in the way for the stem
        for (int y = 0; y <= mushroomHeight; y++) {
            if (!world.getBlockState(pos.above(y)).canBeReplaced()) return false;
        }
        // Checks if nothing is in the way for the cap radius
        for (int y = mushroomHeight; y >= capHeight; y--) {
            for (int x = -mushroomRadius; x <= mushroomRadius; x++) {
                for (int z = -mushroomRadius; z <= mushroomRadius; z++) {
                    if (!world.getBlockState(pos.offset(x, y, z)).canBeReplaced()) return false;
                }
            }
        }
        return true;
    }
}

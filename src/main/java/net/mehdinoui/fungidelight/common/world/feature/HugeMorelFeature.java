package net.mehdinoui.fungidelight.common.world.feature;

import com.mojang.serialization.Codec;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HugeMorelFeature extends CustomHugeMushroomFeature {
    protected static int[][][] capLayers = new int[][][]{
            {{0, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 1}, {4, 2}, {4, 3}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 1}, {4, 2}, {4, 3}},
            {{0, 2}, {0, 3}, {0, 4}, {1, 1}, {1, 5}, {2, 0}, {2, 6}, {3, 0}, {3, 6}, {4, 0}, {4, 6}, {5, 1}, {5, 5}, {6, 2}, {6, 3}, {6, 4}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 4}, {2, 0}, {2, 4}, {3, 0}, {3, 4}, {4, 1}, {4, 2}, {4, 3}}
    };
    public HugeMorelFeature(Codec<NoneFeatureConfiguration> codec) { super(codec); }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        var world = context.level();
        var pos = context.origin();

        if (!isValidSpace(world, pos, 6,6, 2)) return false;

        int stemHeight = 9 + context.random().nextInt(4);
        placeStem(world, pos, stemHeight, stemHeight, ModBlocks.MOREL_MUSHROOM_STEM.get().defaultBlockState());

        BlockPos layerOrigin = pos.above(stemHeight);
        for (int i = 0; i < capLayers.length; i++) {
            placeCapLayer(world, layerOrigin.below(i), capLayers[i], ModBlocks.MOREL_MUSHROOM_BLOCK.get().defaultBlockState(), false);
        }
        return true;
    }
}

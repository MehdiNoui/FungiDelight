package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FungiDelight.MOD_ID, exFileHelper);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, "block/" + path);
    }

    @Override
    protected void registerStatesAndModels() {
        // Mushrooms
        simpleCrossBlock(ModBlocks.INKY_CAP_MUSHROOM);
        simpleCrossBlock(ModBlocks.MOREL_MUSHROOM);
        stageBlock(ModBlocks.INKY_CAP_MUSHROOM_COLONY.get(), MushroomColonyBlock.COLONY_AGE);
        stageBlock(ModBlocks.MOREL_MUSHROOM_COLONY.get(), MushroomColonyBlock.COLONY_AGE);

        simpleCubeAllBlock(ModBlocks.TRUFFLE_DIRT);
    }

    // --- Helper Methods ---
    private void simpleCubeAllBlock(DeferredHolder<Block, ? extends Block> blockHolder) {
        Block block = blockHolder.get();
        this.simpleBlock(block, models().cubeAll(blockName(block), resourceBlock(blockName(block))));
    }
    private void simpleCrossBlock(DeferredHolder<Block, ? extends Block> blockHolder) {
        Block block = blockHolder.get();
        this.simpleBlock(block,
                models().cross(blockName(block), resourceBlock(blockName(block)))
                        .renderType("cutout")
        );
    }
    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage" + ageSuffix;
                    return ConfiguredModel.builder()
                            .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout"))
                            .build();
                }, ignored);
    }
}
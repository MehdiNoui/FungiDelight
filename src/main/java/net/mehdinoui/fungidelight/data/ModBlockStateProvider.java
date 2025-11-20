package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FungiDelight.MOD_ID, exFileHelper);
    }
    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FungiDelight.MOD_ID, "block/" + path);
    }

    // States Registry
    @Override
    protected void registerStatesAndModels() {
        simpleCrossBlock(ModBlocks.INKY_CAP_MUSHROOM);
        simpleCrossBlock(ModBlocks.MOREL_MUSHROOM);
        stageBlock(ModBlocks.INKY_CAP_MUSHROOM_COLONY.get(), MushroomColonyBlock.COLONY_AGE);
        stageBlock(ModBlocks.MOREL_MUSHROOM_COLONY.get(), MushroomColonyBlock.COLONY_AGE);

        simpleCubeAllBlock(ModBlocks.TRUFFLE_DIRT);
    }

    // --- Helper Methods ---
    private void simpleCubeAllBlock(RegistryObject<? extends Block> blockRegistry) {
        Block block = blockRegistry.get();
        this.simpleBlock(block,
                models().cubeAll(blockName(block), resourceBlock(blockName(block)))
        );
    }
    private void simpleCrossBlock(RegistryObject<? extends Block> blockRegistry) {
        simpleCrossBlock(blockRegistry, false);
    }
    private void simpleCrossBlock(RegistryObject<? extends Block> blockRegistry, boolean isBushCrop) {
        Block block = blockRegistry.get();
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
                            .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }
}
package net.mehdinoui.fungidelight.data.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FungiDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.registerForgeTags();
        this.registerMinecraftTags();
        this.registerFarmersDelightTags();
        this.registerFungiDelightTags();
    }
    protected void registerForgeTags() {
    }
    protected void registerMinecraftTags() {
        // Mushrooms
        tag(net.minecraft.tags.BlockTags.SWORD_EFFICIENT).add(
                ModBlocks.INKY_CAP_MUSHROOM.get(),
                ModBlocks.MOREL_MUSHROOM.get(),
                ModBlocks.INKY_GOO_VEIL.get()
        );
        tag(net.minecraft.tags.BlockTags.ENDERMAN_HOLDABLE).add(
                ModBlocks.INKY_CAP_MUSHROOM.get(),
                ModBlocks.MOREL_MUSHROOM.get()
        );
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.INKY_CAP_MUSHROOM.get(),
                ModBlocks.MOREL_MUSHROOM.get(),
                ModBlocks.INKY_CAP_MUSHROOM_BLOCK.get(),
                ModBlocks.INKY_CAP_MUSHROOM_EDGE.get(),
                ModBlocks.INKY_CAP_MUSHROOM_STEM.get(),
                ModBlocks.INKY_GOO_VEIL.get(),
                ModBlocks.MOREL_MUSHROOM_BLOCK.get(),
                ModBlocks.MOREL_MUSHROOM_STEM.get()
        );
        tag(net.minecraft.tags.BlockTags.REPLACEABLE_BY_TREES).add(
                ModBlocks.INKY_GOO_VEIL.get()
        );
        tag(net.minecraft.tags.BlockTags.REPLACEABLE).add(
                ModBlocks.INKY_GOO_VEIL.get()
        );
        tag(net.minecraft.tags.BlockTags.ENCHANTMENT_POWER_TRANSMITTER).add(
                ModBlocks.INKY_GOO_VEIL.get()
        );
    }
    protected void registerFarmersDelightTags() {
        tag(ModTags.COMPOST_ACTIVATORS).add(
                ModBlocks.INKY_CAP_MUSHROOM.get(),
                ModBlocks.MOREL_MUSHROOM.get(),
                ModBlocks.INKY_CAP_MUSHROOM_COLONY.get(),
                ModBlocks.MOREL_MUSHROOM_COLONY.get()
        );
        tag(ModTags.UNAFFECTED_BY_RICH_SOIL).add(
                ModBlocks.INKY_CAP_MUSHROOM_COLONY.get(),
                ModBlocks.MOREL_MUSHROOM_COLONY.get()
        );
    }
    protected void registerFungiDelightTags() {
        tag(FungiDelightTags.INKY_CAP_PLACEABLE_ON)
                .addTag(net.minecraft.tags.BlockTags.DIRT)
                .addTag(net.minecraft.tags.BlockTags.LOGS)
                .addTag(net.minecraft.tags.BlockTags.MUSHROOM_GROW_BLOCK)
                .addTag(Tags.Blocks.COBBLESTONE)
                .addTag(Tags.Blocks.STONE)
                .add(Blocks.SCULK);
        tag(FungiDelightTags.MOREL_PLACEABLE_ON)
                .addTag(net.minecraft.tags.BlockTags.DIRT)
                .addTag(net.minecraft.tags.BlockTags.LOGS)
                .addTag(net.minecraft.tags.BlockTags.MUSHROOM_GROW_BLOCK)
                .addTag(Tags.Blocks.COBBLESTONE)
                .addTag(Tags.Blocks.STONE);
    }
}
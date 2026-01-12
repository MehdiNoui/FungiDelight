package net.mehdinoui.fungidelight.data.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
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
        this.registerCommonTags();
        this.registerMinecraftTags();
        this.registerFarmersDelightTags();
        this.registerFungiDelightTags();
    }
    protected void registerCommonTags() {
        tag(FungiDelightTags.STORAGE_BLOCKS_BROWN_MUSHROOM)
                .add(ModBlocks.BROWN_MUSHROOM_CRATE.get());
        tag(FungiDelightTags.STORAGE_BLOCKS_RED_MUSHROOM)
                .add(ModBlocks.RED_MUSHROOM_CRATE.get());
        tag(FungiDelightTags.STORAGE_BLOCKS_INKY_CAP)
                .add(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get());
        tag(FungiDelightTags.STORAGE_BLOCKS_MOREL)
                .add(ModBlocks.MOREL_MUSHROOM_CRATE.get());
        tag(FungiDelightTags.STORAGE_BLOCKS_TRUFFLE)
                .add(ModBlocks.TRUFFLE_CRATE.get());
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(FungiDelightTags.STORAGE_BLOCKS_BROWN_MUSHROOM)
                .addTag(FungiDelightTags.STORAGE_BLOCKS_RED_MUSHROOM)
                .addTag(FungiDelightTags.STORAGE_BLOCKS_INKY_CAP)
                .addTag(FungiDelightTags.STORAGE_BLOCKS_MOREL)
                .addTag(FungiDelightTags.STORAGE_BLOCKS_TRUFFLE);
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
                ModBlocks.MOREL_MUSHROOM_STEM.get(),
                ModBlocks.BROWN_MUSHROOM_CRATE.get(),
                ModBlocks.INKY_CAP_MUSHROOM_CRATE.get(),
                ModBlocks.MOREL_MUSHROOM_CRATE.get(),
                ModBlocks.RED_MUSHROOM_CRATE.get(),
                ModBlocks.TRUFFLE_CRATE.get()
        );
        tag(net.minecraft.tags.BlockTags.DIRT).add(
                ModBlocks.TRUFFLE_DIRT.get()
        );
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL).add(
                ModBlocks.TRUFFLE_DIRT.get()
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
                .addTag(Tags.Blocks.COBBLESTONES)
                .addTag(Tags.Blocks.STONES)
                .add(Blocks.SCULK);
        tag(FungiDelightTags.MOREL_PLACEABLE_ON)
                .addTag(net.minecraft.tags.BlockTags.DIRT)
                .addTag(net.minecraft.tags.BlockTags.LOGS)
                .addTag(net.minecraft.tags.BlockTags.MUSHROOM_GROW_BLOCK)
                .addTag(Tags.Blocks.COBBLESTONES)
                .addTag(Tags.Blocks.STONES);
    }
}
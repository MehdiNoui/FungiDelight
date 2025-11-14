package net.mehdinoui.fungidelight.data.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
    }
    protected void registerForgeTags() {
    }
    protected void registerMinecraftTags() {
        // Mushrooms
        tag(net.minecraft.tags.BlockTags.SWORD_EFFICIENT).add(
                ModBlocks.INKY_CAP_MUSHROOM.get(),
                ModBlocks.MOREL_MUSHROOM.get()
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
                ModBlocks.MOREL_MUSHROOM_BLOCK.get(),
                ModBlocks.MOREL_MUSHROOM_STEM.get()
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
}
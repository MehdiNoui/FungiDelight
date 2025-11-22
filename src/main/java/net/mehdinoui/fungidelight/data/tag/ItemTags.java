package net.mehdinoui.fungidelight.data.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, FungiDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.registerForgeTags();
        this.registerMinecraftTags();
        this.registerFarmersDelightTags();
    }
    public void registerForgeTags() {
        tag(Tags.Items.MUSHROOMS).add(
                ModItems.INKY_CAP_MUSHROOM.get(),
                ModItems.MOREL_MUSHROOM.get(),
                ModItems.TRUFFLE.get()
        );
        tag(FungiDelightTags.STORAGE_BLOCKS_ITEM_BROWN_MUSHROOM)
                .add(ModBlocks.BROWN_MUSHROOM_CRATE.get().asItem());
        tag(FungiDelightTags.STORAGE_BLOCKS_ITEM_RED_MUSHROOM)
                .add(ModBlocks.RED_MUSHROOM_CRATE.get().asItem());
        tag(FungiDelightTags.STORAGE_BLOCKS_ITEM_INKY_CAP)
                .add(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get().asItem());
        tag(FungiDelightTags.STORAGE_BLOCKS_ITEM_MOREL)
                .add(ModBlocks.MOREL_MUSHROOM_CRATE.get().asItem());
        tag(FungiDelightTags.STORAGE_BLOCKS_ITEM_TRUFFLE)
                .add(ModBlocks.TRUFFLE_CRATE.get().asItem());
    }
    public void registerMinecraftTags() {}
    public void registerFarmersDelightTags() {}
}

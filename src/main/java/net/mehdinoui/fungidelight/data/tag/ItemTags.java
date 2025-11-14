package net.mehdinoui.fungidelight.data.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModItems;
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
                ModItems.MOREL_MUSHROOM.get()
        );
    }
    public void registerMinecraftTags() {}
    public void registerFarmersDelightTags() {}
}

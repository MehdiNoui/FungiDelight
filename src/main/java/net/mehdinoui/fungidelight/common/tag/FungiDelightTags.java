package net.mehdinoui.fungidelight.common.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FungiDelightTags {
    private static TagKey<Block> fungiDelightBlockTag(String path) {
        return BlockTags.create(new ResourceLocation(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Item> fungiDelightItemTag(String path) {
        return ItemTags.create(new ResourceLocation(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Block> forgeBlockTag(String path) {
        return BlockTags.create(new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(new ResourceLocation("forge", path));
    }

    // Blocks morels can naturally spawn on
    public static final TagKey<Block> MOREL_PLACEABLE_ON =
            fungiDelightBlockTag("morel_placeable_on");
    // Blocks inky caps can naturally spawn on
    public static final TagKey<Block> INKY_CAP_PLACEABLE_ON =
            fungiDelightBlockTag("inky_cap_placeable_on");
}

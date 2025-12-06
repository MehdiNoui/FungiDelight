package net.mehdinoui.fungidelight.common.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class FungiDelightTags {
    private static TagKey<Block> fungiDelightBlockTag(String path) {
        return BlockTags.create(new ResourceLocation(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Item> fungiDelightItemTag(String path) {
        return ItemTags.create(new ResourceLocation(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Biome> fungiDelightBiomeTag(String path) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Block> forgeBlockTag(String path) {
        return BlockTags.create(new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(new ResourceLocation("forge", path));
    }

    // BIOMES:
    public static final TagKey<Biome> HAS_INKY_CAPS = fungiDelightBiomeTag("has_inky_caps");
    public static final TagKey<Biome> HAS_MORELS = fungiDelightBiomeTag("has_morels");
    public static final TagKey<Biome> HAS_TRUFFLES = fungiDelightBiomeTag("has_truffles");

    // Fungi Delight Tags:
    // Truffle Ore
    public static final TagKey<Block> TRUFFLE_ORE =
            fungiDelightBlockTag("truffle_ore");
    // Blocks pig can dig up
    public static final TagKey<Block> PIG_CAN_DIG_UP =
            fungiDelightBlockTag("pig_can_dig_up");
    // Blocks morels can naturally spawn on
    public static final TagKey<Block> MOREL_PLACEABLE_ON =
            fungiDelightBlockTag("morel_placeable_on");
    // Blocks inky caps can naturally spawn on
    public static final TagKey<Block> INKY_CAP_PLACEABLE_ON =
            fungiDelightBlockTag("inky_cap_placeable_on");

    // Forge Tags:
    // BLOCKS: Storage blocks
    public static final TagKey<Block> STORAGE_BLOCKS_BROWN_MUSHROOM =
            forgeBlockTag("storage_blocks/brown_mushroom");
    public static final TagKey<Block> STORAGE_BLOCKS_RED_MUSHROOM =
            forgeBlockTag("storage_blocks/red_mushroom");
    public static final TagKey<Block> STORAGE_BLOCKS_INKY_CAP =
            forgeBlockTag("storage_blocks/inky_cap");
    public static final TagKey<Block> STORAGE_BLOCKS_MOREL =
            forgeBlockTag("storage_blocks/morel");
    public static final TagKey<Block> STORAGE_BLOCKS_TRUFFLE =
            forgeBlockTag("storage_blocks/truffle");

    // ITEMS: Storage block items
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BROWN_MUSHROOM =
            forgeItemTag("storage_blocks/brown_mushroom");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_RED_MUSHROOM =
            forgeItemTag("storage_blocks/red_mushroom");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_INKY_CAP =
            forgeItemTag("storage_blocks/inky_cap");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_MOREL =
            forgeItemTag("storage_blocks/morel");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_TRUFFLE =
            forgeItemTag("storage_blocks/truffle");

    // Reference Key for alcohol items (done in json)
    public static final TagKey<Item> ALCOHOL =
            forgeItemTag("alcohol");
}

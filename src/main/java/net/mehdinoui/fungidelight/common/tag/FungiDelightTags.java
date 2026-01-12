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
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Item> fungiDelightItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Biome> fungiDelightBiomeTag(String path) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(FungiDelight.MOD_ID, path));
    }
    private static TagKey<Block> commonBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
    private static TagKey<Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    // BIOMES:
    public static final TagKey<Biome> HAS_INKY_CAPS =
            fungiDelightBiomeTag("has_inky_caps");
    public static final TagKey<Biome> HAS_MORELS =
            fungiDelightBiomeTag("has_morels");
    public static final TagKey<Biome> HAS_TRUFFLES =
            fungiDelightBiomeTag("has_truffles");

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

    // Common Tags:
    // BLOCKS: Storage blocks
    public static final TagKey<Block> STORAGE_BLOCKS_BROWN_MUSHROOM =
            commonBlockTag("storage_blocks/brown_mushroom");
    public static final TagKey<Block> STORAGE_BLOCKS_RED_MUSHROOM =
            commonBlockTag("storage_blocks/red_mushroom");
    public static final TagKey<Block> STORAGE_BLOCKS_INKY_CAP =
            commonBlockTag("storage_blocks/inky_cap");
    public static final TagKey<Block> STORAGE_BLOCKS_MOREL =
            commonBlockTag("storage_blocks/morel");
    public static final TagKey<Block> STORAGE_BLOCKS_TRUFFLE =
            commonBlockTag("storage_blocks/truffle");

    // ITEMS:
    public static final TagKey<Item> INKY_CAPS =
            commonItemTag("mushrooms/inky_cap");
    public static final TagKey<Item> MORELS =
            commonItemTag("mushrooms/morel");
    public static final TagKey<Item> TRUFFLES =
            commonItemTag("mushrooms/truffle");
    // Storage block items
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BROWN_MUSHROOM =
            commonItemTag("storage_blocks/brown_mushroom");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_RED_MUSHROOM =
            commonItemTag("storage_blocks/red_mushroom");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_INKY_CAP =
            commonItemTag("storage_blocks/inky_cap");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_MOREL =
            commonItemTag("storage_blocks/morel");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_TRUFFLE =
            commonItemTag("storage_blocks/truffle");

    // Reference Key for alcohol items (done in json)
    public static final TagKey<Item> ALCOHOL =
            commonItemTag("alcohol");
    public static final TagKey<Item> ALCOHOL_REACTION =
            fungiDelightItemTag("alcohol_reaction");
}

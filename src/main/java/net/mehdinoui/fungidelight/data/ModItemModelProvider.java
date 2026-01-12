package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FungiDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        // Flat Items
        flatItem(ModItems.INKY_CAP_MUSHROOM);
        flatItem(ModItems.MOREL_MUSHROOM);
        flatItem(ModItems.INKY_CAP_MUSHROOM_COLONY, "_stage3");
        flatItem(ModItems.MOREL_MUSHROOM_COLONY, "_stage3");
        flatItem(ModItems.INKY_GOO_VEIL, "_connected");

        // Standard Food/Ingredients
        simpleItem(ModItems.CLEANED_CAPS);
        simpleItem(ModItems.COOKED_CLEANED_CAPS);
        simpleItem(ModItems.TRUFFLE);
        simpleItem(ModItems.TRUFFLE_SLICE);
        simpleItem(ModItems.INKY_CAPS_SALAD);
        simpleItem(ModItems.CREAMY_MOREL_SOUP);
        simpleItem(ModItems.TRUFFLE_ICE_CREAM);
        simpleItem(ModItems.INKY_CAP_SCRAMBLED_EGGS);
        simpleItem(ModItems.TRUFFLE_PASTA);
        simpleItem(ModItems.STUFFED_MORELS);
        simpleItem(ModItems.STEAK_WITH_MUSHROOMS);
        simpleItem(ModItems.MUTTON_CHOPS_WITH_TRUFFLE);
        simpleItem(ModItems.RABBIT_WITH_MORELS);
        simpleItem(ModItems.PORK_MARSALA_WITH_MUSHROOMS);

        // Block Items
        simpleBlock(ModBlocks.INKY_CAP_MUSHROOM_BLOCK, "_inventory");
        simpleBlock(ModBlocks.INKY_CAP_MUSHROOM_EDGE, "_inventory");
        simpleBlock(ModBlocks.INKY_CAP_MUSHROOM_STEM, "_inventory");
        simpleBlock(ModBlocks.MOREL_MUSHROOM_BLOCK, "_inventory");
        simpleBlock(ModBlocks.MOREL_MUSHROOM_STEM, "_inventory");

        simpleBlock(ModBlocks.TRUFFLE_DIRT);
        simpleBlock(ModBlocks.BROWN_MUSHROOM_CRATE);
        simpleBlock(ModBlocks.INKY_CAP_MUSHROOM_CRATE);
        simpleBlock(ModBlocks.MOREL_MUSHROOM_CRATE);
        simpleBlock(ModBlocks.RED_MUSHROOM_CRATE);
        simpleBlock(ModBlocks.TRUFFLE_CRATE);
    }

    // --- Helper Methods ---
    private void flatItem(DeferredHolder<Item, ? extends Item> itemHolder) {
        String name = itemHolder.getKey().location().getPath();
        withExistingParent(name, ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", modLoc("block/" + name));
    }
    private void flatItem(DeferredHolder<Item, ? extends Item> itemHolder, String suffix) {
        String name = itemHolder.getKey().location().getPath();
        withExistingParent(name, ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", modLoc("block/" + name + suffix));
    }

    public void simpleBlock(DeferredHolder<Block, ? extends Block> blockHolder) {
        String name = blockHolder.getKey().location().getPath();
        this.withExistingParent(name, modLoc("block/" + name));
    }
    public void simpleBlock(DeferredHolder<Block, ? extends Block> blockHolder, String suffix) {
        String name = blockHolder.getKey().location().getPath();
        this.withExistingParent(name, modLoc("block/" + name + suffix));
    }

    private ItemModelBuilder simpleItem(DeferredHolder<Item, ? extends Item> itemHolder) {
        String name = itemHolder.getKey().location().getPath();
        return withExistingParent(name, ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", modLoc("item/" + name));
    }
}
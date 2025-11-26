package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FungiDelight.MOD_ID, exFileHelper);
    }
    // States Registry
    @Override
    protected void registerModels() {
        flatItem(ModItems.INKY_CAP_MUSHROOM);
        flatItem(ModItems.MOREL_MUSHROOM);

        flatItem(ModItems.INKY_CAP_MUSHROOM_COLONY, "_stage3");
        flatItem(ModItems.MOREL_MUSHROOM_COLONY, "_stage3");

        flatItem(ModItems.INKY_GOO_VEIL, "_connected");

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
    private void flatItem(RegistryObject<?> itemRegistry) {
        String name = itemRegistry.getId().getPath();
        withExistingParent(name, "item/generated")
                .texture("layer0", modLoc("block/" + name));
    }
    private void flatItem(RegistryObject<?> itemRegistry, String stuff) {
        String name = itemRegistry.getId().getPath();
        withExistingParent(name, "item/generated")
                .texture("layer0", modLoc("block/" + name + stuff));
    }
    public void simpleBlock(RegistryObject<Block> block) {
        this.withExistingParent(
                FungiDelight.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void simpleBlock(RegistryObject<Block> block, String stuff) {
        this.withExistingParent(
                FungiDelight.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + stuff));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FungiDelight.MOD_ID,"item/" + item.getId().getPath()));
    }
}

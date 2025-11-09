package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FungiDelight.MOD_ID, exFileHelper);
    }
    // States Registry
    @Override
    protected void registerModels() {
        flatItem(ModItems.INKY_CAP_MUSHROOM);
    }
    // --- Helper Methods ---
    private void flatItem(RegistryObject<?> itemRegistry) {
        String name = itemRegistry.getId().getPath();
        withExistingParent(name, "item/generated")
                .texture("layer0", modLoc("block/" + name));
    }
}

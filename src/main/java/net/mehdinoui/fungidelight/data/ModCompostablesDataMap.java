package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModCompostablesDataMap extends DataMapProvider {
    protected ModCompostablesDataMap(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        var builder = builder(NeoForgeDataMaps.COMPOSTABLES);

        // 50% chance
        builder.add(ModItems.CLEANED_CAPS.get().asItem().builtInRegistryHolder(), new Compostable(0.5F), false);
        builder.add(ModItems.TRUFFLE_SLICE.get().asItem().builtInRegistryHolder(), new Compostable(0.5F), false);

        // 65% chance
        builder.add(ModItems.INKY_CAP_MUSHROOM.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.COOKED_CLEANED_CAPS.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.MOREL_MUSHROOM.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.INKY_CAP_MUSHROOM_STEM.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.INKY_GOO_VEIL.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.MOREL_MUSHROOM_STEM.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false);

        // 85% chance
        builder.add(ModItems.INKY_CAP_MUSHROOM_BLOCK.get().asItem().builtInRegistryHolder(), new Compostable(0.85F), false);
        builder.add(ModItems.INKY_CAP_MUSHROOM_EDGE.get().asItem().builtInRegistryHolder(), new Compostable(0.85F), false);
        builder.add(ModItems.MOREL_MUSHROOM_BLOCK.get().asItem().builtInRegistryHolder(), new Compostable(0.85F), false);

        // 100% chance
        builder.add(ModItems.TRUFFLE.get().asItem().builtInRegistryHolder(), new Compostable(1.0F), false);
        builder.add(ModItems.INKY_CAP_MUSHROOM_COLONY.get().asItem().builtInRegistryHolder(), new Compostable(1.0F), false);
        builder.add(ModItems.MOREL_MUSHROOM_COLONY.get().asItem().builtInRegistryHolder(), new Compostable(1.0F), false);
    }
}
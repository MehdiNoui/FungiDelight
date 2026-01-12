package net.mehdinoui.fungidelight.data;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.data.recipe.*;
import net.mehdinoui.fungidelight.data.tag.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = FungiDelight.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Tags
        BlockTags blockTags = new BlockTags(packOutput, lookupProvider, existingFileHelper);
        ItemTags itemTags = new ItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper);
        BiomeTags biomeTags = new BiomeTags(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), itemTags);
        generator.addProvider(event.includeServer(), biomeTags);

        // Compostables (DataMapProvider)
        generator.addProvider(event.includeServer(),
                new ModCompostablesDataMap(packOutput, lookupProvider));

        // Models
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        // Loot Tables
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput, lookupProvider));

        // Recipes
        generator.addProvider(event.includeServer(),
                new RecipeProvider(packOutput,lookupProvider) {
                    @Override
                    protected void buildRecipes(@NotNull RecipeOutput output) {
                        ModBasicRecipes.register(output);
                        ModCookingRecipes.register(output);
                        ModCuttingRecipes.register(output);
                        ModSmeltingRecipes.register(output);
                    }
                });

        // World-gen
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
    }
}

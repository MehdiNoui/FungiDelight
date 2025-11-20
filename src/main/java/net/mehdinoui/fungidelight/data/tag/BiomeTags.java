package net.mehdinoui.fungidelight.data.tag;

import net.mehdinoui.fungidelight.FungiDelight;
import net.mehdinoui.fungidelight.common.tag.FungiDelightTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BiomeTags extends BiomeTagsProvider {
    public BiomeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookup, FungiDelight.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(FungiDelightTags.HAS_TRUFFLES)
                .addTag(net.minecraft.tags.BiomeTags.IS_TAIGA)
                .add(Biomes.DARK_FOREST);

        this.tag(FungiDelightTags.HAS_INKY_CAPS)
                .addTag(Tags.Biomes.IS_SWAMP)
                .add(Biomes.BIRCH_FOREST)
                .add(Biomes.OLD_GROWTH_BIRCH_FOREST);

        this.tag(FungiDelightTags.HAS_MORELS)
                .addTag(Tags.Biomes.IS_CONIFEROUS)
                .add(Biomes.DARK_FOREST);
    }
}

package net.mehdinoui.fungidelight.data.loot;

import net.mehdinoui.fungidelight.common.registry.ModBlocks;
import net.mehdinoui.fungidelight.common.registry.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private final Set<Block> generatedLootTables = new HashSet<>();
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), new HashMap<>());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BROWN_MUSHROOM_CRATE.get());
        this.dropSelf(ModBlocks.RED_MUSHROOM_CRATE.get());
        this.dropSelf(ModBlocks.MOREL_MUSHROOM_CRATE.get());
        this.dropSelf(ModBlocks.INKY_CAP_MUSHROOM_CRATE.get());
        this.dropSelf(ModBlocks.TRUFFLE_CRATE.get());
        this.dropSelf(ModBlocks.INKY_CAP_MUSHROOM.get());
        this.dropSelf(ModBlocks.MOREL_MUSHROOM.get());

        this.add(ModBlocks.TRUFFLE_DIRT.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(ModBlocks.TRUFFLE_DIRT.get())
                                        .when(HAS_SILK_TOUCH)
                                        .otherwise(LootItem.lootTableItem(ModItems.TRUFFLE.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                                .apply(ApplyExplosionDecay.explosionDecay())
                                        )
                                )
                )
        );


        this.add(ModBlocks.INKY_GOO_VEIL.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(HAS_SHEARS_OR_SILK_TOUCH)
                                .add(LootItem.lootTableItem(ModBlocks.INKY_GOO_VEIL.get()))
                )
        );

        this.add(ModBlocks.INKY_CAP_MUSHROOM_BLOCK.get(),
                this.createMushroomBlockDrop(ModBlocks.INKY_CAP_MUSHROOM_BLOCK.get(), ModItems.INKY_CAP_MUSHROOM.get()));
        this.add(ModBlocks.INKY_CAP_MUSHROOM_EDGE.get(),
                this.createMushroomBlockDrop(ModBlocks.INKY_CAP_MUSHROOM_EDGE.get(), ModItems.INKY_CAP_MUSHROOM.get()));
        this.add(ModBlocks.INKY_CAP_MUSHROOM_STEM.get(),
                this.createMushroomBlockDrop(ModBlocks.INKY_CAP_MUSHROOM_STEM.get(), ModItems.INKY_CAP_MUSHROOM.get()));
        this.add(ModBlocks.MOREL_MUSHROOM_BLOCK.get(),
                this.createMushroomBlockDrop(ModBlocks.MOREL_MUSHROOM_BLOCK.get(), ModItems.MOREL_MUSHROOM.get()));
        this.add(ModBlocks.MOREL_MUSHROOM_STEM.get(),
                this.createMushroomBlockDrop(ModBlocks.MOREL_MUSHROOM_STEM.get(), ModItems.MOREL_MUSHROOM.get()));
    }

    @Override
    protected void add(Block block, LootTable.Builder builder) {
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.generatedLootTables;
    }
}
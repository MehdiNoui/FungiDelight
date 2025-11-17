package net.mehdinoui.fungidelight;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    // --- Foods ---
    public static final ForgeConfigSpec.BooleanValue ENABLE_PIG_FOODS;

    // --- Trades ---
    public static final ForgeConfigSpec.BooleanValue ENABLE_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_WANDERING_TRADER_SELLS;

    // --- World Generation ---
    // ---- Huge Mushrooms ----
    public static final ForgeConfigSpec.IntValue CHANCE_HUGE_INKY_CAP;
    public static final ForgeConfigSpec.IntValue CHANCE_HUGE_MOREL;

    // ---- Mushroom Colonies ----
    public static final ForgeConfigSpec.IntValue CHANCE_INKY_CAP_COLONY;
    public static final ForgeConfigSpec.IntValue CHANCE_MOREL_COLONY;

    // ---- Mushroom Patches ----
    public static final ForgeConfigSpec.IntValue CHANCE_INKY_CAP_NORMAL;
    public static final ForgeConfigSpec.IntValue CHANCE_MOREL_NORMAL;

    public static final ForgeConfigSpec.IntValue CHANCE_INKY_CAP_COMMON;
    public static final ForgeConfigSpec.IntValue CHANCE_MOREL_COMMON;

    public static final ForgeConfigSpec.IntValue CHANCE_INKY_CAP_RARE;
    public static final ForgeConfigSpec.IntValue CHANCE_MOREL_RARE;

    static {
        // --- Foods ---
        BUILDER.push("Food Settings");
        ENABLE_PIG_FOODS = BUILDER
                .comment("Enable mushrooms as pig food sources")
                .define("enablePigFoods", true);
        BUILDER.pop();

        // --- Trades ---
        BUILDER.push("Trade Settings");
        ENABLE_VILLAGER_TRADES = BUILDER
                .comment("Enable Fungi Delight villager trades")
                .define("enableVillagerTrades", true);
        ENABLE_WANDERING_TRADER_SELLS = BUILDER
                .comment("Enable Fungi Delight Wandering Trader sales")
                .define("enableWanderingTraderTrades", true);
        BUILDER.pop();

        // --- World Generation ---
        BUILDER.push("Worldgen Settings");

        BUILDER.comment("Smaller value = more frequent. Or provide 0 to disable generation.");
        BUILDER.push("Huge Mushroom Generation");
        CHANCE_HUGE_INKY_CAP = BUILDER
                .comment("Chance of generating Huge Inky Caps Mushroom (default = 3)")
                .defineInRange("hugeInkyCapChance", 3, 0, Integer.MAX_VALUE);
        CHANCE_HUGE_MOREL = BUILDER
                .comment("Chance of generating Huge Morel Mushroom (default = 4)")
                .defineInRange("hugeMorelChance", 4, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.comment("Smaller value = more frequent. Or provide 0 to disable generation.");
        BUILDER.push("Mushroom Colony Patches");
        CHANCE_INKY_CAP_COLONY = BUILDER
                .comment("Chance of generating Inky Cap mushroom colony patches (default = 15)")
                .defineInRange("inkyCapColonyChance", 15, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_COLONY = BUILDER
                .comment("Chance of generating rare Morel mushroom colony patches (default = 15)")
                .defineInRange("morelColonyChance", 15, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.comment("Smaller value = more frequent. Or provide 0 to disable generation.");
        BUILDER.push("Mushroom Patches Generation");
        BUILDER.comment("Normal patches = Overworld");
        BUILDER.comment("Common patches = Mushroom Fields");
        BUILDER.comment("Rare patches = Dense Overworld / Swamp");
        CHANCE_INKY_CAP_NORMAL = BUILDER
                .comment("Chance of generating normal Inky Cap mushroom patches (default = 768)")
                .defineInRange("inkyCapNormalChance", 768, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_NORMAL = BUILDER
                .comment("Chance of generating normal Morel mushroom patches (default = 384)")
                .defineInRange("morelNormalChance", 384, 0, Integer.MAX_VALUE);
        CHANCE_INKY_CAP_COMMON = BUILDER
                .comment("Chance of generating common Inky Cap mushroom patches (default = 16)")
                .defineInRange("inkyCapCommonChance", 16, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_COMMON = BUILDER
                .comment("Chance of generating common Morel mushroom patches (default = 12)")
                .defineInRange("morelCommonChance", 12, 0, Integer.MAX_VALUE);
        CHANCE_INKY_CAP_RARE = BUILDER
                .comment("Chance of generating rare Inky Cap mushroom patches (default = 64)")
                .defineInRange("inkyCapRareChance", 64, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_RARE = BUILDER
                .comment("Chance of generating rare Morel mushroom patches (default = 32)")
                .defineInRange("morelRareChance", 32, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.pop();
        CONFIG = BUILDER.build();
    }
}

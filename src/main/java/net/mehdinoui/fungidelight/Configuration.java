package net.mehdinoui.fungidelight;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    // --- Pigs ---
    public static final ForgeConfigSpec.BooleanValue ENABLE_PIG_FOODS;
    public static final ForgeConfigSpec.BooleanValue ENABLE_PIG_DIGGING;
    public static final ForgeConfigSpec.DoubleValue CHANCE_PIG_DIGGING;

    // --- Wolf ---
    public static final ForgeConfigSpec.BooleanValue ENABLE_WOLF_HUNT_TRUFFLE;

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

    // ---- Truffle Ore Blobs ---
    public static final ForgeConfigSpec.IntValue CHANCE_ROOTED_DIRT_BLOB;
    public static final ForgeConfigSpec.IntValue CHANCE_TRUFFLE_DIRT_ORE;

    static {
        // ==========================================
        //              Animal Settings
        // ==========================================
        BUILDER.push("Animal Settings");

        ENABLE_PIG_FOODS = BUILDER
                .comment("If true, Pigs can be tempted and bred using Fungi Delight mushrooms.")
                .define("enablePigFoods", true);

        ENABLE_PIG_DIGGING = BUILDER
                .comment("If true, Pigs can randomly dig up items when standing on Podzol.")
                .define("enablePigDigging", true);

        CHANCE_PIG_DIGGING = BUILDER
                .comment("The probability per tick that a pig will attempt to dig a podzol block",
                        "Formula: 1 / value = Average Ticks.",
                        "Default: 0.00025 (Approx. 1 attempt every 3 min 20 sec).",
                        "Range: 0.0 (Disabled) to 1.0 (Every tick).")
                .defineInRange("chancePigDigging", 0.00025, 0.0, 1.0);

        ENABLE_WOLF_HUNT_TRUFFLE = BUILDER
                .comment("If true, Tamed Wolves can be used to sniff and locate Truffle Dirt blocks")
                .define("enableWolfHuntTruffle", true);

        BUILDER.pop();

        // ==========================================
        //              Trade Settings
        // ==========================================
        BUILDER.push("Trade Settings");

        ENABLE_VILLAGER_TRADES = BUILDER
                .comment("If true, adds Fungi Delight trades to Farmers and Wandering Traders.")
                .define("enableVillagerTrades", true);

        ENABLE_WANDERING_TRADER_SELLS = BUILDER
                .comment("If true, the Wandering Trader can sell Fungi Delight items.")
                .define("enableWanderingTraderTrades", true);

        BUILDER.pop();

        // ==========================================
        //            World Gen Settings
        // ==========================================
        BUILDER.comment("Generation settings. Lower values = More Frequent generation.",
                "Set value to 0 to disable the feature entirely.");
        BUILDER.push("World-gen Settings");

        // --- Huge Mushrooms ---
        BUILDER.push("Huge Mushroom Generation");
        CHANCE_HUGE_INKY_CAP = BUILDER
                .comment("Average number of chunks between attempts to generate Huge Inky Caps.",
                        "Default: 3")
                .defineInRange("hugeInkyCapRarity", 3, 0, Integer.MAX_VALUE);
        CHANCE_HUGE_MOREL = BUILDER
                .comment("Average number of chunks between attempts to generate Huge Morels.",
                        "Default: 4")
                .defineInRange("hugeMorelRarity", 4, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        // --- Mushroom Colonies ---
        BUILDER.push("Mushroom Colony Patches");
        CHANCE_INKY_CAP_COLONY = BUILDER
                .comment("Average number of chunks between attempts to generate Inky Cap Colonies.",
                        "Default: 15")
                .defineInRange("inkyCapColonyRarity", 15, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_COLONY = BUILDER
                .comment("Average number of chunks between attempts to generate Morel Colonies.",
                        "Default: 15")
                .defineInRange("morelColonyRarity", 15, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        // --- Mushroom Patches ---
        BUILDER.push("Mushroom Patches Generation");

        CHANCE_INKY_CAP_NORMAL = BUILDER
                .comment("Rarity of Inky Caps in standard Overworld biomes.",
                        "Default: 768")
                .defineInRange("inkyCapStandardRarity", 768, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_NORMAL = BUILDER
                .comment("Rarity of Morels in standard Overworld biomes.",
                        "Default: 384")
                .defineInRange("morelStandardRarity", 384, 0, Integer.MAX_VALUE);

        CHANCE_INKY_CAP_COMMON = BUILDER
                .comment("Rarity of Inky Caps in Mushroom Fields.",
                        "Default: 16")
                .defineInRange("inkyCapMushroomFieldRarity", 16, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_COMMON = BUILDER
                .comment("Rarity of Morels in Mushroom Fields.",
                        "Default: 12")
                .defineInRange("morelMushroomFieldRarity", 12, 0, Integer.MAX_VALUE);

        CHANCE_INKY_CAP_RARE = BUILDER
                .comment("Rarity of Inky Caps in Tagged biomes.",
                        "Default: 64")
                .defineInRange("inkyCapTaggedRarity", 64, 0, Integer.MAX_VALUE);
        CHANCE_MOREL_RARE = BUILDER
                .comment("Rarity of Morels in Tagged biomes.",
                        "Default: 32")
                .defineInRange("morelTaggedRarity", 32, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        // --- Ores ---
        BUILDER.push("Truffle Ore Generation");
        CHANCE_ROOTED_DIRT_BLOB = BUILDER
                .comment("Average number of chunks between Rooted Dirt blobs.",
                        "Default: 3")
                .defineInRange("rootedDirtBlobRarity", 3, 0, Integer.MAX_VALUE);
        CHANCE_TRUFFLE_DIRT_ORE = BUILDER
                .comment("Average number of chunks between Truffle Dirt Ores.",
                        "Note: This replaces Rooted Dirt generated by the config above.",
                        "Default: 1")
                .defineInRange("truffleDirtOreRarity", 1, 0, Integer.MAX_VALUE);
        BUILDER.pop(); // Pop Ore
        BUILDER.pop(); // Pop World Gen

        CONFIG = BUILDER.build();
    }
}
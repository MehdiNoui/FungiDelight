package net.mehdinoui.fungidelight.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.mehdinoui.fungidelight.Configuration; // Import your Configuration
import net.mehdinoui.fungidelight.common.registry.ModPlacementModifiers; // Import your registry
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.core.BlockPos;

public class ConfigurableRarityFilter extends PlacementFilter {

    // 1. Define the CODEC to save/load our config key
    public static final MapCodec<ConfigurableRarityFilter> CODEC =
            Codec.STRING.fieldOf("config_key")
                    .xmap(ConfigurableRarityFilter::new, ConfigurableRarityFilter::getConfigKey);

    private final String configKey;

    public ConfigurableRarityFilter(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigKey() {
        return this.configKey;
    }

    // 2. The logic is now inside shouldPlace
    @Override
    protected boolean shouldPlace(PlacementContext ctx, RandomSource random, BlockPos pos) {
        // Get the config value *at runtime*
        int chance = getConfigValue(this.configKey);

        // Handle 0 (never place) and 1 (always place) correctly
        if (chance == 0) {
            return false; // 0 chance = never place
        }
        if (chance == 1) {
            return true; // 1 chance = always place
        }
        // For other values, use the random check
        return random.nextInt(chance) == 0;
    }

    // 3. Add a helper to get the right config value
    private int getConfigValue(String key) {
        switch (key) {
            case "huge_inky_cap":
                return Configuration.CHANCE_HUGE_INKY_CAP.get();
            case "huge_morel":
                return Configuration.CHANCE_HUGE_MOREL.get();
            case "inky_cap_normal":
                return Configuration.CHANCE_INKY_CAP_NORMAL.get();
            case "morel_normal":
                return Configuration.CHANCE_MOREL_NORMAL.get();
            case "inky_cap_common":
                return Configuration.CHANCE_INKY_CAP_COMMON.get();
            case "morel_common":
                return Configuration.CHANCE_MOREL_COMMON.get();
            case "inky_cap_rare":
                return Configuration.CHANCE_INKY_CAP_RARE.get();
            case "morel_rare":
                return Configuration.CHANCE_MOREL_RARE.get();
            default:
                // Default to 0 (disabled) if key is unknown
                return 0;
        }
    }

    @Override
    public PlacementModifierType<?> type() {
        // Point to your custom registered modifier
        return ModPlacementModifiers.CONFIGURABLE_RARITY_FILTER.get();
    }
}
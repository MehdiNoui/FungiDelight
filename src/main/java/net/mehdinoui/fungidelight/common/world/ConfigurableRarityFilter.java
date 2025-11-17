package net.mehdinoui.fungidelight.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.mehdinoui.fungidelight.Configuration;
import net.mehdinoui.fungidelight.common.registry.ModPlacementModifiers;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.core.BlockPos;

public class ConfigurableRarityFilter extends PlacementFilter {
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
    @Override
    protected boolean shouldPlace(PlacementContext ctx, RandomSource random, BlockPos pos) {
        int chance = getConfigValue(this.configKey);
        if (chance == 0) {
            return false;
        }
        if (chance == 1) {
            return true;
        }
        return random.nextInt(chance) == 0;
    }

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
            case "inky_cap_colony":
                return Configuration.CHANCE_INKY_CAP_COLONY.get();
            case "morel_colony":
                return Configuration.CHANCE_MOREL_COLONY.get();
            default:
                return 0;
        }
    }

    @Override
    public PlacementModifierType<?> type() {
        return ModPlacementModifiers.CONFIGURABLE_RARITY_FILTER.get();
    }
}
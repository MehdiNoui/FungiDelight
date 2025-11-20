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
import org.jetbrains.annotations.NotNull;

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
    protected boolean shouldPlace(@NotNull PlacementContext ctx, @NotNull RandomSource random, @NotNull BlockPos pos) {
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
        return switch (key) {
            case "huge_inky_cap" -> Configuration.CHANCE_HUGE_INKY_CAP.get();
            case "huge_morel" -> Configuration.CHANCE_HUGE_MOREL.get();
            case "inky_cap_normal" -> Configuration.CHANCE_INKY_CAP_NORMAL.get();
            case "morel_normal" -> Configuration.CHANCE_MOREL_NORMAL.get();
            case "inky_cap_common" -> Configuration.CHANCE_INKY_CAP_COMMON.get();
            case "morel_common" -> Configuration.CHANCE_MOREL_COMMON.get();
            case "inky_cap_rare" -> Configuration.CHANCE_INKY_CAP_RARE.get();
            case "morel_rare" -> Configuration.CHANCE_MOREL_RARE.get();
            case "inky_cap_colony" -> Configuration.CHANCE_INKY_CAP_COLONY.get();
            case "morel_colony" -> Configuration.CHANCE_MOREL_COLONY.get();
            case "rooted_dirt_blob" -> Configuration.CHANCE_ROOTED_DIRT_BLOB.get();
            case "truffle_dirt_ore" -> Configuration.CHANCE_TRUFFLE_DIRT_ORE.get();
            default -> 0;
        };
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return ModPlacementModifiers.CONFIGURABLE_RARITY_FILTER.get();
    }
}
package com.github.command17.enhancedtools.config;

import com.github.command17.enhancedtools.config.builder.BooleanConfigField;
import com.github.command17.enhancedtools.config.builder.ConfigBuilder;
import com.github.command17.enhancedtools.config.builder.FloatConfigField;
import com.github.command17.enhancedtools.config.builder.IntegerConfigField;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModCommonConfig extends ConfigBuilder {
    public static final Pair<ModCommonConfig, ModConfigSpec> PAIR = new ModConfigSpec.Builder().configure(ModCommonConfig::new);

    @BooleanConfigField(name = "explosive_arrows.explosive_arrows_destroy_blocks", defaultValue = false, comment = "If true, explosive arrows destroy blocks")
    public static ModConfigSpec.ConfigValue<Boolean> explosiveArrowsDestroyBlocks;

    @FloatConfigField(name = "explosive_arrows.explosive_arrows_explosion_strength", defaultValue = 2, comment = "The strength of the explosion from explosive arrows")
    public static ModConfigSpec.ConfigValue<Float> explosiveArrowsExplosionStrength;

    @IntegerConfigField(name = "hammering.hammering_depth_add", defaultValue = -1, comment = "The value for the depth of the Hammering enchantment. It's calculated like this: enchantmentLevel + hammering_depth_add")
    public static ModConfigSpec.ConfigValue<Integer> hammeringDepthAdd;

    @IntegerConfigField(name = "hammering.hammering_radius", defaultValue = 1, comment = "The value for the radius of the Hammering enchantment.")
    public static ModConfigSpec.ConfigValue<Integer> hammeringRadius;

    @BooleanConfigField(name = "adze.allow_axe_tool_action", defaultValue = true, comment = "If true, adzes can strip logs and wax off copper")
    public static ModConfigSpec.ConfigValue<Boolean> adzesAllowToolActions;

    public ModCommonConfig(ModConfigSpec.Builder builder) {
        super(builder);
    }
}

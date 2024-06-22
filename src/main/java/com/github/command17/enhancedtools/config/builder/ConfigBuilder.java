package com.github.command17.enhancedtools.config.builder;

import com.github.command17.enhancedtools.EnhancedTools;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ConfigBuilder {
    public ConfigBuilder(ModConfigSpec.Builder builder) {
        for (Field field: this.getClass().getDeclaredFields()) {
            for (Annotation annotation: field.getAnnotations()) {
                try {
                    if (annotation instanceof BooleanConfigField configField)
                        field.set(this, builder.comment(configField.comment()).define(configField.name(), configField.defaultValue()));

                    if (annotation instanceof IntegerConfigField configField)
                        field.set(this, builder.comment(configField.comment()).define(configField.name(), configField.defaultValue()));

                    if (annotation instanceof FloatConfigField configField)
                        field.set(this, builder.comment(configField.comment()).define(configField.name(), configField.defaultValue()));
                } catch (Exception e) {
                    EnhancedTools.LOGGER.error("Error with configuring config fields! Exception:", e);
                }
            }
        }

        EnhancedTools.LOGGER.info("Built Config.");
    }
}

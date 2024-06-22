package com.github.command17.enhancedtools.util;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        makeBow(ModItems.COPPER_BOW.get());
        makeCrossbow(ModItems.COPPER_CROSSBOW.get());

        EnhancedTools.LOGGER.info("Added Custom Item Properties.");
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, EnhancedTools.mcResource("pull"), (stack, level, entity, id) -> {
            if (entity == null) return 0;
            else return entity.getUseItem() != stack ? 0 : (float) (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20;
        });

        ItemProperties.register(item, EnhancedTools.mcResource("pulling"),
                (stack, level, entity, id) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1 : 0);
    }

    private static void makeCrossbow(Item item) {
        ItemProperties.register(item, EnhancedTools.mcResource("pull"), (stack, level, entity, id) -> {
            if (entity == null) return 0;
            else return CrossbowItem.isCharged(stack) ? 0 : (float) (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(stack);
        });

        ItemProperties.register(item, EnhancedTools.mcResource("pulling"),
                (stack, level, entity, id) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);

        ItemProperties.register(item, EnhancedTools.mcResource("charged"),
                (stack, level, entity, id) -> CrossbowItem.isCharged(stack) ? 1 : 0);

        ItemProperties.register(item, EnhancedTools.mcResource("firework"),
                (stack, level, entity, id) -> {
                    ChargedProjectiles projectiles = stack.get(DataComponents.CHARGED_PROJECTILES);

                    return projectiles != null && projectiles.contains(Items.FIREWORK_ROCKET) ? 1 : 0;
                }
        );
    }
}

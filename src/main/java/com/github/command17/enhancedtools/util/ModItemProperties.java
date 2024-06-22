package com.github.command17.enhancedtools.util;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        makeBow(ModItems.COPPER_BOW.get());
        makeCrossbow(ModItems.COPPER_CROSSBOW.get());

        EnhancedTools.LOGGER.info("Added Custom Item Properties.");
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (stack, level, entity, id) -> {
            if (entity == null) return 0;
            else return entity.getUseItem() != stack ? 0 : (float) (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20;
        });

        ItemProperties.register(item, new ResourceLocation("pulling"),
                (stack, level, entity, id) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1 : 0);
    }

    private static void makeCrossbow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (stack, level, entity, id) -> {
            if (entity == null) return 0;
            else return CrossbowItem.isCharged(stack) ? 0 : (float) (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(stack);
        });

        ItemProperties.register(item, new ResourceLocation("pulling"),
                (stack, level, entity, id) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1 : 0);

        ItemProperties.register(item, new ResourceLocation("charged"),
                (stack, level, entity, id) -> CrossbowItem.isCharged(stack) ? 1 : 0);

        ItemProperties.register(item, new ResourceLocation("firework"),
                (stack, level, entity, id) -> CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1 : 0);
    }
}

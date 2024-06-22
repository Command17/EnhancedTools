package com.github.command17.enhancedtools.util;

import com.github.command17.enhancedtools.EnhancedTools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class ItemTag {
        public static final TagKey<Item> NEOFORGE_TOOLS_TAG = neoforgeTag("tools");
        public static final TagKey<Item> NEOFORGE_BOWS_TAG = neoforgeTag("tools/bows");
        public static final TagKey<Item> NEOFORGE_CROSSBOWS_TAG = neoforgeTag("tools/crossbows");

        public static final TagKey<Item> ENHANCED_TOOLS_TAG = tag("enhanced_tools");
        public static final TagKey<Item> COPPER_PROJECTILE_SHOOTERS_TAG = tag("copper_projectile_shooters");
        public static final TagKey<Item> ADZES_TAG = tag("adzes");
        public static final TagKey<Item> HAMMERS_TAG = tag("hammers");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(EnhancedTools.resource(name));
        }

        private static TagKey<Item> neoforgeTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", name));
        }
    }

    public static class BlockTag {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(EnhancedTools.resource(name));
        }

        private static TagKey<Block> neoforgeTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", name));
        }
    }
}

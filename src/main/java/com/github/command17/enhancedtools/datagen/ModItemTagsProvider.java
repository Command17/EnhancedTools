package com.github.command17.enhancedtools.datagen;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.ModItems;
import com.github.command17.enhancedtools.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> lookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, completableFuture, lookup, EnhancedTools.MOD_ID, existingFileHelper);
    }

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Item>> lookupItem, CompletableFuture<TagLookup<Block>> lookupBlock, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, completableFuture, lookupItem, lookupBlock, EnhancedTools.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(ModTags.ItemTag.COPPER_PROJECTILE_SHOOTERS_TAG)
                .add(ModItems.COPPER_BOW.get())
                .add(ModItems.COPPER_CROSSBOW.get());

        tag(ModTags.ItemTag.NEOFORGE_TOOLS_TAG)
                .add(ModItems.COPPER_BOW.get())
                .add(ModItems.COPPER_CROSSBOW.get())

                .add(ModItems.IRON_ADZE.get())
                .add(ModItems.GOLDEN_ADZE.get())
                .add(ModItems.DIAMOND_ADZE.get())
                .add(ModItems.NETHERITE_ADZE.get())

                .add(ModItems.COPPER_IRON_ADZE.get())
                .add(ModItems.COPPER_GOLDEN_ADZE.get())
                .add(ModItems.COPPER_DIAMOND_ADZE.get())
                .add(ModItems.COPPER_NETHERITE_ADZE.get())

                .add(ModItems.COPPER_WOODEN_SWORD.get())
                .add(ModItems.COPPER_WOODEN_SHOVEL.get())
                .add(ModItems.COPPER_WOODEN_PICKAXE.get())
                .add(ModItems.COPPER_WOODEN_AXE.get())
                .add(ModItems.COPPER_WOODEN_HOE.get())

                .add(ModItems.COPPER_STONE_SWORD.get())
                .add(ModItems.COPPER_STONE_SHOVEL.get())
                .add(ModItems.COPPER_STONE_PICKAXE.get())
                .add(ModItems.COPPER_STONE_AXE.get())
                .add(ModItems.COPPER_STONE_HOE.get())

                .add(ModItems.COPPER_GOLDEN_SWORD.get())
                .add(ModItems.COPPER_GOLDEN_SHOVEL.get())
                .add(ModItems.COPPER_GOLDEN_PICKAXE.get())
                .add(ModItems.COPPER_GOLDEN_AXE.get())
                .add(ModItems.COPPER_GOLDEN_HOE.get())

                .add(ModItems.COPPER_IRON_SWORD.get())
                .add(ModItems.COPPER_IRON_SHOVEL.get())
                .add(ModItems.COPPER_IRON_PICKAXE.get())
                .add(ModItems.COPPER_IRON_AXE.get())
                .add(ModItems.COPPER_IRON_HOE.get())

                .add(ModItems.COPPER_DIAMOND_SWORD.get())
                .add(ModItems.COPPER_DIAMOND_SHOVEL.get())
                .add(ModItems.COPPER_DIAMOND_PICKAXE.get())
                .add(ModItems.COPPER_DIAMOND_AXE.get())
                .add(ModItems.COPPER_DIAMOND_HOE.get())

                .add(ModItems.COPPER_NETHERITE_SWORD.get())
                .add(ModItems.COPPER_NETHERITE_SHOVEL.get())
                .add(ModItems.COPPER_NETHERITE_PICKAXE.get())
                .add(ModItems.COPPER_NETHERITE_AXE.get())
                .add(ModItems.COPPER_NETHERITE_HOE.get())

                .add(ModItems.IRON_HAMMER.get())
                .add(ModItems.GOLDEN_HAMMER.get())
                .add(ModItems.DIAMOND_HAMMER.get())
                .add(ModItems.NETHERITE_HAMMER.get())

                .add(ModItems.COPPER_IRON_HAMMER.get())
                .add(ModItems.COPPER_GOLDEN_HAMMER.get())
                .add(ModItems.COPPER_DIAMOND_HAMMER.get())
                .add(ModItems.COPPER_NETHERITE_HAMMER.get());
        /*
        tag(ItemTags.TOOLS)
                .add(ModItems.COPPER_BOW.get())
                .add(ModItems.COPPER_CROSSBOW.get())

                .add(ModItems.IRON_ADZE.get())
                .add(ModItems.GOLDEN_ADZE.get())
                .add(ModItems.DIAMOND_ADZE.get())
                .add(ModItems.NETHERITE_ADZE.get())

                .add(ModItems.COPPER_IRON_ADZE.get())
                .add(ModItems.COPPER_GOLDEN_ADZE.get())
                .add(ModItems.COPPER_DIAMOND_ADZE.get())
                .add(ModItems.COPPER_NETHERITE_ADZE.get())

                .add(ModItems.COPPER_WOODEN_SWORD.get())
                .add(ModItems.COPPER_WOODEN_SHOVEL.get())
                .add(ModItems.COPPER_WOODEN_PICKAXE.get())
                .add(ModItems.COPPER_WOODEN_AXE.get())
                .add(ModItems.COPPER_WOODEN_HOE.get())

                .add(ModItems.COPPER_STONE_SWORD.get())
                .add(ModItems.COPPER_STONE_SHOVEL.get())
                .add(ModItems.COPPER_STONE_PICKAXE.get())
                .add(ModItems.COPPER_STONE_AXE.get())
                .add(ModItems.COPPER_STONE_HOE.get())

                .add(ModItems.COPPER_GOLDEN_SWORD.get())
                .add(ModItems.COPPER_GOLDEN_SHOVEL.get())
                .add(ModItems.COPPER_GOLDEN_PICKAXE.get())
                .add(ModItems.COPPER_GOLDEN_AXE.get())
                .add(ModItems.COPPER_GOLDEN_HOE.get())

                .add(ModItems.COPPER_IRON_SWORD.get())
                .add(ModItems.COPPER_IRON_SHOVEL.get())
                .add(ModItems.COPPER_IRON_PICKAXE.get())
                .add(ModItems.COPPER_IRON_AXE.get())
                .add(ModItems.COPPER_IRON_HOE.get())

                .add(ModItems.COPPER_DIAMOND_SWORD.get())
                .add(ModItems.COPPER_DIAMOND_SHOVEL.get())
                .add(ModItems.COPPER_DIAMOND_PICKAXE.get())
                .add(ModItems.COPPER_DIAMOND_AXE.get())
                .add(ModItems.COPPER_DIAMOND_HOE.get())

                .add(ModItems.COPPER_NETHERITE_SWORD.get())
                .add(ModItems.COPPER_NETHERITE_SHOVEL.get())
                .add(ModItems.COPPER_NETHERITE_PICKAXE.get())
                .add(ModItems.COPPER_NETHERITE_AXE.get())
                .add(ModItems.COPPER_NETHERITE_HOE.get())

                .add(ModItems.IRON_HAMMER.get())
                .add(ModItems.GOLDEN_HAMMER.get())
                .add(ModItems.DIAMOND_HAMMER.get())
                .add(ModItems.NETHERITE_HAMMER.get())

                .add(ModItems.COPPER_IRON_HAMMER.get())
                .add(ModItems.COPPER_GOLDEN_HAMMER.get())
                .add(ModItems.COPPER_DIAMOND_HAMMER.get())
                .add(ModItems.COPPER_NETHERITE_HAMMER.get());
         */

        tag(ModTags.ItemTag.ENHANCED_TOOLS_TAG)
                .add(ModItems.COPPER_BOW.get())
                .add(ModItems.COPPER_CROSSBOW.get())

                .add(ModItems.COPPER_IRON_ADZE.get())
                .add(ModItems.COPPER_GOLDEN_ADZE.get())
                .add(ModItems.COPPER_DIAMOND_ADZE.get())
                .add(ModItems.COPPER_NETHERITE_ADZE.get())

                .add(ModItems.COPPER_WOODEN_SWORD.get())
                .add(ModItems.COPPER_WOODEN_SHOVEL.get())
                .add(ModItems.COPPER_WOODEN_PICKAXE.get())
                .add(ModItems.COPPER_WOODEN_AXE.get())
                .add(ModItems.COPPER_WOODEN_HOE.get())

                .add(ModItems.COPPER_STONE_SWORD.get())
                .add(ModItems.COPPER_STONE_SHOVEL.get())
                .add(ModItems.COPPER_STONE_PICKAXE.get())
                .add(ModItems.COPPER_STONE_AXE.get())
                .add(ModItems.COPPER_STONE_HOE.get())

                .add(ModItems.COPPER_GOLDEN_SWORD.get())
                .add(ModItems.COPPER_GOLDEN_SHOVEL.get())
                .add(ModItems.COPPER_GOLDEN_PICKAXE.get())
                .add(ModItems.COPPER_GOLDEN_AXE.get())
                .add(ModItems.COPPER_GOLDEN_HOE.get())

                .add(ModItems.COPPER_IRON_SWORD.get())
                .add(ModItems.COPPER_IRON_SHOVEL.get())
                .add(ModItems.COPPER_IRON_PICKAXE.get())
                .add(ModItems.COPPER_IRON_AXE.get())
                .add(ModItems.COPPER_IRON_HOE.get())

                .add(ModItems.COPPER_DIAMOND_SWORD.get())
                .add(ModItems.COPPER_DIAMOND_SHOVEL.get())
                .add(ModItems.COPPER_DIAMOND_PICKAXE.get())
                .add(ModItems.COPPER_DIAMOND_AXE.get())
                .add(ModItems.COPPER_DIAMOND_HOE.get())

                .add(ModItems.COPPER_NETHERITE_SWORD.get())
                .add(ModItems.COPPER_NETHERITE_SHOVEL.get())
                .add(ModItems.COPPER_NETHERITE_PICKAXE.get())
                .add(ModItems.COPPER_NETHERITE_AXE.get())
                .add(ModItems.COPPER_NETHERITE_HOE.get())

                .add(ModItems.COPPER_IRON_HAMMER.get())
                .add(ModItems.COPPER_GOLDEN_HAMMER.get())
                .add(ModItems.COPPER_DIAMOND_HAMMER.get())
                .add(ModItems.COPPER_NETHERITE_HAMMER.get());

        tag(ModTags.ItemTag.ADZES_TAG)
                .add(ModItems.IRON_ADZE.get())
                .add(ModItems.GOLDEN_ADZE.get())
                .add(ModItems.DIAMOND_ADZE.get())
                .add(ModItems.NETHERITE_ADZE.get())

                .add(ModItems.COPPER_IRON_ADZE.get())
                .add(ModItems.COPPER_GOLDEN_ADZE.get())
                .add(ModItems.COPPER_DIAMOND_ADZE.get())
                .add(ModItems.COPPER_NETHERITE_ADZE.get());

        tag(ModTags.ItemTag.HAMMERS_TAG)
                .add(ModItems.IRON_HAMMER.get())
                .add(ModItems.GOLDEN_HAMMER.get())
                .add(ModItems.DIAMOND_HAMMER.get())
                .add(ModItems.NETHERITE_HAMMER.get())

                .add(ModItems.COPPER_IRON_HAMMER.get())
                .add(ModItems.COPPER_GOLDEN_HAMMER.get())
                .add(ModItems.COPPER_DIAMOND_HAMMER.get())
                .add(ModItems.COPPER_NETHERITE_HAMMER.get());


        tag(ModTags.ItemTag.NEOFORGE_BOWS_TAG).add(ModItems.COPPER_BOW.get());
        tag(ModTags.ItemTag.NEOFORGE_CROSSBOWS_TAG).add(ModItems.COPPER_CROSSBOW.get());
    }
}

package com.github.command17.enhancedtools.datagen;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedTools.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_ENHANCING_SMITHING_TEMPLATE);

        handheldItem(ModItems.IRON_ADZE);
        handheldItem(ModItems.GOLDEN_ADZE);
        handheldItem(ModItems.DIAMOND_ADZE);
        handheldItem(ModItems.NETHERITE_ADZE);

        handheldItem(ModItems.COPPER_IRON_ADZE);
        handheldItem(ModItems.COPPER_GOLDEN_ADZE);
        handheldItem(ModItems.COPPER_DIAMOND_ADZE);
        handheldItem(ModItems.COPPER_NETHERITE_ADZE);

        handheldItem(ModItems.COPPER_WOODEN_SWORD);
        handheldItem(ModItems.COPPER_WOODEN_SHOVEL);
        handheldItem(ModItems.COPPER_WOODEN_PICKAXE);
        handheldItem(ModItems.COPPER_WOODEN_AXE);
        handheldItem(ModItems.COPPER_WOODEN_HOE);

        handheldItem(ModItems.COPPER_STONE_SWORD);
        handheldItem(ModItems.COPPER_STONE_SHOVEL);
        handheldItem(ModItems.COPPER_STONE_PICKAXE);
        handheldItem(ModItems.COPPER_STONE_AXE);
        handheldItem(ModItems.COPPER_STONE_HOE);

        handheldItem(ModItems.COPPER_GOLDEN_SWORD);
        handheldItem(ModItems.COPPER_GOLDEN_SHOVEL);
        handheldItem(ModItems.COPPER_GOLDEN_PICKAXE);
        handheldItem(ModItems.COPPER_GOLDEN_AXE);
        handheldItem(ModItems.COPPER_GOLDEN_HOE);

        handheldItem(ModItems.COPPER_IRON_SWORD);
        handheldItem(ModItems.COPPER_IRON_SHOVEL);
        handheldItem(ModItems.COPPER_IRON_PICKAXE);
        handheldItem(ModItems.COPPER_IRON_AXE);
        handheldItem(ModItems.COPPER_IRON_HOE);

        handheldItem(ModItems.COPPER_DIAMOND_SWORD);
        handheldItem(ModItems.COPPER_DIAMOND_SHOVEL);
        handheldItem(ModItems.COPPER_DIAMOND_PICKAXE);
        handheldItem(ModItems.COPPER_DIAMOND_AXE);
        handheldItem(ModItems.COPPER_DIAMOND_HOE);

        handheldItem(ModItems.COPPER_NETHERITE_SWORD);
        handheldItem(ModItems.COPPER_NETHERITE_SHOVEL);
        handheldItem(ModItems.COPPER_NETHERITE_PICKAXE);
        handheldItem(ModItems.COPPER_NETHERITE_AXE);
        handheldItem(ModItems.COPPER_NETHERITE_HOE);

        handheldItem(ModItems.IRON_HAMMER);
        handheldItem(ModItems.GOLDEN_HAMMER);
        handheldItem(ModItems.DIAMOND_HAMMER);
        handheldItem(ModItems.NETHERITE_HAMMER);

        handheldItem(ModItems.COPPER_IRON_HAMMER);
        handheldItem(ModItems.COPPER_GOLDEN_HAMMER);
        handheldItem(ModItems.COPPER_DIAMOND_HAMMER);
        handheldItem(ModItems.COPPER_NETHERITE_HAMMER);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EnhancedTools.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedTools.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedTools.MOD_ID,"item/" + item.getId().getPath()));
    }
}

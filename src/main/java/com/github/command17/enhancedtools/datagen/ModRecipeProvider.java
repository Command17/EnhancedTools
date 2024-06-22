package com.github.command17.enhancedtools.datagen;

import com.github.command17.enhancedtools.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        copperEnhancingRecipe(recipeConsumer, Items.CROSSBOW, RecipeCategory.COMBAT, ModItems.COPPER_CROSSBOW.get());
        copperEnhancingRecipe(recipeConsumer, Items.BOW, RecipeCategory.COMBAT, ModItems.COPPER_BOW.get());

        copperEnhancingRecipe(recipeConsumer, Items.WOODEN_SWORD, RecipeCategory.COMBAT, ModItems.COPPER_WOODEN_SWORD.get());
        copperEnhancingRecipe(recipeConsumer, Items.WOODEN_SHOVEL, RecipeCategory.TOOLS, ModItems.COPPER_WOODEN_SHOVEL.get());
        copperEnhancingRecipe(recipeConsumer, Items.WOODEN_PICKAXE, RecipeCategory.TOOLS, ModItems.COPPER_WOODEN_PICKAXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.WOODEN_AXE, RecipeCategory.TOOLS, ModItems.COPPER_WOODEN_AXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.WOODEN_HOE, RecipeCategory.TOOLS, ModItems.COPPER_WOODEN_HOE.get());

        copperEnhancingRecipe(recipeConsumer, Items.STONE_SWORD, RecipeCategory.COMBAT, ModItems.COPPER_STONE_SWORD.get());
        copperEnhancingRecipe(recipeConsumer, Items.STONE_SHOVEL, RecipeCategory.TOOLS, ModItems.COPPER_STONE_SHOVEL.get());
        copperEnhancingRecipe(recipeConsumer, Items.STONE_PICKAXE, RecipeCategory.TOOLS, ModItems.COPPER_STONE_PICKAXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.STONE_AXE, RecipeCategory.TOOLS, ModItems.COPPER_STONE_AXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.STONE_HOE, RecipeCategory.TOOLS, ModItems.COPPER_STONE_HOE.get());

        copperEnhancingRecipe(recipeConsumer, Items.GOLDEN_SWORD, RecipeCategory.COMBAT, ModItems.COPPER_GOLDEN_SWORD.get());
        copperEnhancingRecipe(recipeConsumer, Items.GOLDEN_SHOVEL, RecipeCategory.TOOLS, ModItems.COPPER_GOLDEN_SHOVEL.get());
        copperEnhancingRecipe(recipeConsumer, Items.GOLDEN_PICKAXE, RecipeCategory.TOOLS, ModItems.COPPER_GOLDEN_PICKAXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.GOLDEN_AXE, RecipeCategory.TOOLS, ModItems.COPPER_GOLDEN_AXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.GOLDEN_HOE, RecipeCategory.TOOLS, ModItems.COPPER_GOLDEN_HOE.get());

        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_SWORD.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_SHOVEL.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_PICKAXE.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_AXE.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_HOE.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.4f);

        copperEnhancingRecipe(recipeConsumer, Items.IRON_SWORD, RecipeCategory.COMBAT, ModItems.COPPER_IRON_SWORD.get());
        copperEnhancingRecipe(recipeConsumer, Items.IRON_SHOVEL, RecipeCategory.TOOLS, ModItems.COPPER_IRON_SHOVEL.get());
        copperEnhancingRecipe(recipeConsumer, Items.IRON_PICKAXE, RecipeCategory.TOOLS, ModItems.COPPER_IRON_PICKAXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.IRON_AXE, RecipeCategory.TOOLS, ModItems.COPPER_IRON_AXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.IRON_HOE, RecipeCategory.TOOLS, ModItems.COPPER_IRON_HOE.get());

        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_SWORD.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_SHOVEL.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_PICKAXE.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_AXE.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.4f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_HOE.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.4f);

        copperEnhancingRecipe(recipeConsumer, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, ModItems.COPPER_DIAMOND_SWORD.get());
        copperEnhancingRecipe(recipeConsumer, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, ModItems.COPPER_DIAMOND_SHOVEL.get());
        copperEnhancingRecipe(recipeConsumer, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, ModItems.COPPER_DIAMOND_PICKAXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.DIAMOND_AXE, RecipeCategory.TOOLS, ModItems.COPPER_DIAMOND_AXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.DIAMOND_HOE, RecipeCategory.TOOLS, ModItems.COPPER_DIAMOND_HOE.get());

        copperEnhancingRecipe(recipeConsumer, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.COPPER_NETHERITE_SWORD.get());
        copperEnhancingRecipe(recipeConsumer, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.COPPER_NETHERITE_SHOVEL.get());
        copperEnhancingRecipe(recipeConsumer, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.COPPER_NETHERITE_PICKAXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.COPPER_NETHERITE_AXE.get());
        copperEnhancingRecipe(recipeConsumer, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.COPPER_NETHERITE_HOE.get());

        adzeRecipe(recipeConsumer, Items.IRON_INGOT, RecipeCategory.TOOLS, ModItems.IRON_ADZE.get());
        adzeRecipe(recipeConsumer, Items.GOLD_INGOT, RecipeCategory.TOOLS, ModItems.GOLDEN_ADZE.get());
        adzeRecipe(recipeConsumer, Items.DIAMOND, RecipeCategory.TOOLS, ModItems.DIAMOND_ADZE.get());

        smeltingRecipe(recipeConsumer, ModItems.IRON_ADZE.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.1f);
        smeltingRecipe(recipeConsumer, ModItems.GOLDEN_ADZE.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.1f);

        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_ADZE.get(), RecipeCategory.MISC, Items.IRON_NUGGET, 180, 0.1f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_ADZE.get(), RecipeCategory.MISC, Items.GOLD_NUGGET, 180, 0.1f);

        copperEnhancingRecipe(recipeConsumer, ModItems.IRON_ADZE.get(), RecipeCategory.TOOLS, ModItems.COPPER_IRON_ADZE.get());
        copperEnhancingRecipe(recipeConsumer, ModItems.GOLDEN_ADZE.get(), RecipeCategory.TOOLS, ModItems.COPPER_GOLDEN_ADZE.get());
        copperEnhancingRecipe(recipeConsumer, ModItems.DIAMOND_ADZE.get(), RecipeCategory.TOOLS, ModItems.COPPER_DIAMOND_ADZE.get());
        copperEnhancingRecipe(recipeConsumer, ModItems.NETHERITE_ADZE.get(), RecipeCategory.TOOLS, ModItems.COPPER_NETHERITE_ADZE.get());

        netheriteSmithing(recipeConsumer, ModItems.DIAMOND_ADZE.get(), RecipeCategory.TOOLS, ModItems.NETHERITE_ADZE.get());

        hammerRecipe(ModItems.IRON_HAMMER.get(), Items.IRON_INGOT, Items.IRON_BLOCK).save(recipeConsumer);
        hammerRecipe(ModItems.GOLDEN_HAMMER.get(), Items.GOLD_INGOT, Items.GOLD_BLOCK).save(recipeConsumer);
        hammerRecipe(ModItems.DIAMOND_HAMMER.get(), Items.DIAMOND, Items.DIAMOND_BLOCK).save(recipeConsumer);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ModItems.DIAMOND_HAMMER.get()), Ingredient.of(Items.NETHERITE_BLOCK), RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(recipeConsumer, getItemName(ModItems.NETHERITE_HAMMER.get()) + "_smithing");

        smeltingRecipe(recipeConsumer, ModItems.IRON_HAMMER.get(), RecipeCategory.MISC, Items.IRON_INGOT, 180, 0.1f);
        smeltingRecipe(recipeConsumer, ModItems.GOLDEN_HAMMER.get(), RecipeCategory.MISC, Items.GOLD_INGOT, 180, 0.1f);

        smeltingRecipe(recipeConsumer, ModItems.COPPER_IRON_HAMMER.get(), RecipeCategory.MISC, Items.IRON_INGOT, 180, 0.1f);
        smeltingRecipe(recipeConsumer, ModItems.COPPER_GOLDEN_HAMMER.get(), RecipeCategory.MISC, Items.GOLD_INGOT, 180, 0.1f);

        copperEnhancingRecipe(recipeConsumer, ModItems.IRON_HAMMER.get(), RecipeCategory.TOOLS, ModItems.COPPER_IRON_HAMMER.get());
        copperEnhancingRecipe(recipeConsumer, ModItems.GOLDEN_HAMMER.get(), RecipeCategory.TOOLS, ModItems.COPPER_GOLDEN_HAMMER.get());
        copperEnhancingRecipe(recipeConsumer, ModItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.COPPER_DIAMOND_HAMMER.get());
        copperEnhancingRecipe(recipeConsumer, ModItems.NETHERITE_HAMMER.get(), RecipeCategory.TOOLS, ModItems.COPPER_NETHERITE_HAMMER.get());
    }

    public static void copperEnhancingRecipe(Consumer<FinishedRecipe> recipeConsumer, Item baseItem, RecipeCategory category, Item enhancedItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.COPPER_ENHANCING_SMITHING_TEMPLATE.get()), Ingredient.of(baseItem), Ingredient.of(Items.COPPER_INGOT), category, enhancedItem).unlocks("has_copper_ingot", has(Items.COPPER_INGOT)).save(recipeConsumer, getItemName(enhancedItem) + "_enhanced_smithing");
    }

    public static void smeltingRecipe(Consumer<FinishedRecipe> recipeConsumer, Item baseItem, RecipeCategory category, Item result, int cookTime, float xp) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(baseItem), category, result, xp, cookTime)
                .unlockedBy("has_item", has(baseItem))
                .save(recipeConsumer, getSmeltingRecipeName(baseItem));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(baseItem), category, result, xp, cookTime)
                .unlockedBy("has_item", has(baseItem))
                .save(recipeConsumer, getBlastingRecipeName(baseItem));
    }

    public static void adzeRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike material, RecipeCategory category, Item adze) {
        ShapedRecipeBuilder.shaped(category, adze)
                .pattern(" M")
                .pattern("MS")
                .pattern(" S")
                .define('M', material)
                .define('S', Items.STICK)
                .unlockedBy("has_material", has(material))
                .save(recipeConsumer);
    }

    public static ShapedRecipeBuilder hammerRecipe(Item item, Item itemMaterial, Item blockMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, item)
                .pattern("XxX")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', blockMaterial)
                .define('x', itemMaterial)
                .define('S', Items.STICK).unlockedBy("has_material", has(itemMaterial));
    }

    public static void adzeRecipe(Consumer<FinishedRecipe> recipeConsumer, TagKey<Item> material, RecipeCategory category, Item adze) {
        ShapedRecipeBuilder.shaped(category, adze)
                .pattern("M ")
                .pattern("SM")
                .pattern("S ")
                .define('M', material)
                .define('S', Items.STICK)
                .unlockedBy("has_material", has(material))
                .save(recipeConsumer);
    }
}

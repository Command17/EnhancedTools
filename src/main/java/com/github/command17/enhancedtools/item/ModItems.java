package com.github.command17.enhancedtools.item;

import com.github.command17.enhancedtools.EnhancedTools;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {
    private static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedTools.MOD_ID);

    public static final RegistryObject<Item> COPPER_ENHANCING_SMITHING_TEMPLATE =
            ITEM_REGISTRY.register("copper_enhancing_smithing_template", () -> new SmithingTemplateItem(
                    Component.translatable("item.enhancedtools.smithing_template.copper_enhancing.applies_to").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.enhancedtools.smithing_template.copper_enhancing.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.enhancedtools.copper_enhancing").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.enhancedtools.smithing_template.copper_enhancing.base_slot_description"),
                    Component.translatable("item.enhancedtools.smithing_template.copper_enhancing.additions_slot_description"),
                    List.of(
                            EnhancedTools.mcResource("item/empty_slot_hoe"),
                            EnhancedTools.mcResource("item/empty_slot_axe"),
                            EnhancedTools.mcResource("item/empty_slot_axe"),
                            EnhancedTools.mcResource("item/empty_slot_shovel"),
                            EnhancedTools.mcResource("item/empty_slot_pickaxe"),
                            EnhancedTools.resource("item/empty_slot_bow"),
                            EnhancedTools.resource("item/empty_slot_crossbow")
                    ),
                    List.of(EnhancedTools.mcResource("item/empty_slot_ingot"))
            ));

    public static final RegistryObject<Item> COPPER_CROSSBOW = ITEM_REGISTRY.register("copper_crossbow",
            () -> new CopperCrossbowItem(new Item.Properties().stacksTo(1).durability(865)));

    public static final RegistryObject<Item> COPPER_BOW = ITEM_REGISTRY.register("copper_bow",
            () -> new CopperBowItem(new Item.Properties().durability(684)));

    // Adzes

    public static final RegistryObject<Item> IRON_ADZE = ITEM_REGISTRY.register("iron_adze",
            () -> new AdzeItem(3, -3, Tiers.IRON, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_ADZE = ITEM_REGISTRY.register("golden_adze",
            () -> new AdzeItem(3, -2.9f, Tiers.GOLD, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_ADZE = ITEM_REGISTRY.register("diamond_adze",
            () -> new AdzeItem(2.5f, -3, Tiers.DIAMOND, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_ADZE = ITEM_REGISTRY.register("netherite_adze",
            () -> new AdzeItem(2.5f, -3, Tiers.NETHERITE, new Item.Properties()));

    // Enhanced Adzes

    public static final RegistryObject<Item> COPPER_IRON_ADZE = ITEM_REGISTRY.register("copper_iron_adze",
            () -> new AdzeItem(3 * 1.5f, -3, Tiers.IRON, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_GOLDEN_ADZE = ITEM_REGISTRY.register("copper_golden_adze",
            () -> new AdzeItem(3 * 1.5f, -2.9f, Tiers.GOLD, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_DIAMOND_ADZE = ITEM_REGISTRY.register("copper_diamond_adze",
            () -> new AdzeItem(2.5f * 1.5f, -3, Tiers.DIAMOND, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_NETHERITE_ADZE = ITEM_REGISTRY.register("copper_netherite_adze",
            () -> new AdzeItem(2.5f * 1.5f, -3, Tiers.NETHERITE, new Item.Properties().durability(Tiers.NETHERITE.getUses() * 2)));

    // Hammers

    public static final RegistryObject<Item> IRON_HAMMER = ITEM_REGISTRY.register("iron_hammer",
            () -> new HammerItem(5, -2.8f, Tiers.IRON, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_HAMMER = ITEM_REGISTRY.register("golden_hammer",
            () -> new HammerItem(5, -2.8f, Tiers.GOLD, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEM_REGISTRY.register("diamond_hammer",
            () -> new HammerItem(4, -2.8f, Tiers.DIAMOND, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEM_REGISTRY.register("netherite_hammer",
            () -> new HammerItem(4, -2.8f, Tiers.NETHERITE, new Item.Properties().fireResistant()));

    // Enhanced Hammers

    public static final RegistryObject<Item> COPPER_IRON_HAMMER = ITEM_REGISTRY.register("copper_iron_hammer",
            () -> new HammerItem(5 * 1.5f, -2.8f, Tiers.IRON, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_GOLDEN_HAMMER = ITEM_REGISTRY.register("copper_golden_hammer",
            () -> new HammerItem(5 * 1.5f, -2.8f, Tiers.GOLD, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_DIAMOND_HAMMER = ITEM_REGISTRY.register("copper_diamond_hammer",
            () -> new HammerItem(4 * 1.5f, -2.8f, Tiers.DIAMOND, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_NETHERITE_HAMMER = ITEM_REGISTRY.register("copper_netherite_hammer",
            () -> new HammerItem(4 * 1.5f, -2.8f, Tiers.NETHERITE, new Item.Properties().fireResistant().durability(Tiers.NETHERITE.getUses() * 2)));

    // Enhanced Vanilla Tools

    // Wood

    public static final RegistryObject<Item> COPPER_WOODEN_SWORD = ITEM_REGISTRY.register("copper_wooden_sword",
            () -> new SwordItem(Tiers.WOOD, (int) (3 * 1.5f), -2.4f, new Item.Properties().durability(Tiers.WOOD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_WOODEN_SHOVEL = ITEM_REGISTRY.register("copper_wooden_shovel",
            () -> new ShovelItem(Tiers.WOOD, 1.5f * 1.5f, -3, new Item.Properties().durability(Tiers.WOOD.getUses() * 2)) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return 200;
                }
            });

    public static final RegistryObject<Item> COPPER_WOODEN_PICKAXE = ITEM_REGISTRY.register("copper_wooden_pickaxe",
            () -> new PickaxeItem(Tiers.WOOD, (int) (1 * 1.5f), -2.8f, new Item.Properties().durability(Tiers.WOOD.getUses() * 2)) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return 200;
                }
            });

    public static final RegistryObject<Item> COPPER_WOODEN_AXE = ITEM_REGISTRY.register("copper_wooden_axe",
            () -> new AxeItem(Tiers.WOOD, 6 * 1.5f, -3.2f, new Item.Properties().durability(Tiers.WOOD.getUses() * 2)) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return 200;
                }
            });

    public static final RegistryObject<Item> COPPER_WOODEN_HOE = ITEM_REGISTRY.register("copper_wooden_hoe",
            () -> new HoeItem(Tiers.WOOD, 1, -3, new Item.Properties().durability(Tiers.WOOD.getUses() * 2)) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return 200;
                }
            });

    // Stone

    public static final RegistryObject<Item> COPPER_STONE_SWORD = ITEM_REGISTRY.register("copper_stone_sword",
            () -> new SwordItem(Tiers.STONE, (int) (3 * 1.5f), -2.4f, new Item.Properties().durability(Tiers.STONE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_STONE_SHOVEL = ITEM_REGISTRY.register("copper_stone_shovel",
            () -> new ShovelItem(Tiers.STONE, 1.5f * 1.5f, -3, new Item.Properties().durability(Tiers.STONE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_STONE_PICKAXE = ITEM_REGISTRY.register("copper_stone_pickaxe",
            () -> new PickaxeItem(Tiers.STONE, (int) (1 * 1.5f), -2.8f, new Item.Properties().durability(Tiers.STONE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_STONE_AXE = ITEM_REGISTRY.register("copper_stone_axe",
            () -> new AxeItem(Tiers.STONE, 7 * 1.5f, -3.2f, new Item.Properties().durability(Tiers.STONE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_STONE_HOE = ITEM_REGISTRY.register("copper_stone_hoe",
            () -> new HoeItem(Tiers.STONE, -1, -2, new Item.Properties().durability(Tiers.STONE.getUses() * 2)));

    // Iron

    public static final RegistryObject<Item> COPPER_IRON_SWORD = ITEM_REGISTRY.register("copper_iron_sword",
            () -> new SwordItem(Tiers.IRON, (int) (3 * 1.5f), -2.4f, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_IRON_SHOVEL = ITEM_REGISTRY.register("copper_iron_shovel",
            () -> new ShovelItem(Tiers.IRON, 1.5f * 1.5f, -3, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_IRON_PICKAXE = ITEM_REGISTRY.register("copper_iron_pickaxe",
            () -> new PickaxeItem(Tiers.IRON, (int) (1 * 1.5f), -2.8f, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_IRON_AXE = ITEM_REGISTRY.register("copper_iron_axe",
            () -> new AxeItem(Tiers.IRON, 6 * 1.5f, -3.1f, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_IRON_HOE = ITEM_REGISTRY.register("copper_iron_hoe",
            () -> new HoeItem(Tiers.IRON, -2, -1, new Item.Properties().durability(Tiers.IRON.getUses() * 2)));

    // Gold

    public static final RegistryObject<Item> COPPER_GOLDEN_SWORD = ITEM_REGISTRY.register("copper_golden_sword",
            () -> new SwordItem(Tiers.GOLD, (int) (3 * 1.5f), -2.4f, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_GOLDEN_SHOVEL = ITEM_REGISTRY.register("copper_golden_shovel",
            () -> new ShovelItem(Tiers.GOLD, 1.5f * 1.5f, -3, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_GOLDEN_PICKAXE = ITEM_REGISTRY.register("copper_golden_pickaxe",
            () -> new PickaxeItem(Tiers.GOLD, (int) (1 * 1.5f), -2.8f, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_GOLDEN_AXE = ITEM_REGISTRY.register("copper_golden_axe",
            () -> new AxeItem(Tiers.GOLD, 6 * 1.5f, -3, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_GOLDEN_HOE = ITEM_REGISTRY.register("copper_golden_hoe",
            () -> new HoeItem(Tiers.GOLD, 1, -3, new Item.Properties().durability(Tiers.GOLD.getUses() * 2)));

    // Diamond

    public static final RegistryObject<Item> COPPER_DIAMOND_SWORD = ITEM_REGISTRY.register("copper_diamond_sword",
            () -> new SwordItem(Tiers.DIAMOND, (int) (3 * 1.5f), -2.4f, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_DIAMOND_SHOVEL = ITEM_REGISTRY.register("copper_diamond_shovel",
            () ->  new ShovelItem(Tiers.DIAMOND, 1.5f * 1.5f, -3, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_DIAMOND_PICKAXE = ITEM_REGISTRY.register("copper_diamond_pickaxe",
            () ->  new PickaxeItem(Tiers.DIAMOND, 1, -2.8f, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_DIAMOND_AXE = ITEM_REGISTRY.register("copper_diamond_axe",
            () -> new AxeItem(Tiers.DIAMOND, 5 * 1.5f, -3, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_DIAMOND_HOE = ITEM_REGISTRY.register("copper_diamond_hoe",
            () -> new HoeItem(Tiers.DIAMOND, -3, 0, new Item.Properties().durability(Tiers.DIAMOND.getUses() * 2)));

    // Netherite

    public static final RegistryObject<Item> COPPER_NETHERITE_SWORD = ITEM_REGISTRY.register("copper_netherite_sword",
            () -> new SwordItem(Tiers.NETHERITE, (int) (3 * 1.5f), -2.4f, new Item.Properties().fireResistant().durability(Tiers.NETHERITE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_NETHERITE_SHOVEL = ITEM_REGISTRY.register("copper_netherite_shovel",
            () -> new ShovelItem(Tiers.NETHERITE, 1.5f * 1.5f, -3, new Item.Properties().fireResistant().durability(Tiers.NETHERITE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_NETHERITE_PICKAXE = ITEM_REGISTRY.register("copper_netherite_pickaxe",
            () -> new PickaxeItem(Tiers.NETHERITE, 1, -2.8f, new Item.Properties().fireResistant().durability(Tiers.NETHERITE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_NETHERITE_AXE = ITEM_REGISTRY.register("copper_netherite_axe",
            () -> new AxeItem(Tiers.NETHERITE, 5 * 1.5f, -3, new Item.Properties().fireResistant().durability(Tiers.NETHERITE.getUses() * 2)));

    public static final RegistryObject<Item> COPPER_NETHERITE_HOE = ITEM_REGISTRY.register("copper_netherite_hoe",
            () -> new HoeItem(Tiers.NETHERITE, -4, 0, new Item.Properties().fireResistant().durability(Tiers.NETHERITE.getUses() * 2)));

    // Functions

    public static void register(IEventBus eventBus) {
        ITEM_REGISTRY.register(eventBus);

        EnhancedTools.LOGGER.info("Registered Items.");
    }
}

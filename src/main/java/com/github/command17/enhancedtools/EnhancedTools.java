package com.github.command17.enhancedtools;

import com.github.command17.enhancedtools.config.ModCommonConfig;
import com.github.command17.enhancedtools.enchantment.ModEnchantments;
import com.github.command17.enhancedtools.item.ModItems;
import com.github.command17.enhancedtools.item.tab.ModCreativeModeTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EnhancedTools.MOD_ID)
public class EnhancedTools {
    public static final String MOD_ID = "enhancedtools";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EnhancedTools() {
        LOGGER.info("Initializing...");

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::commonSetup);

        ModItems.register(eventBus);
        ModEnchantments.register(eventBus);
        ModCreativeModeTabs.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfig.PAIR.getValue());

        LOGGER.info("Initialized.");
    }

    public static ResourceLocation resource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static ResourceLocation mcResource(String name) {
        return new ResourceLocation(name);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    private void addEnchantmentBookToCreativeModeTab(BuildCreativeModeTabContentsEvent event, Enchantment enchantment) {
        for (int i = 1; i <= enchantment.getMaxLevel(); i++) event.accept(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(enchantment, i)));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeModeTabs.ENHANCED_TOOLS_TAB.getKey()) {
            addEnchantmentBookToCreativeModeTab(event, ModEnchantments.EXPLOSIVE_ARROWS.get());
            addEnchantmentBookToCreativeModeTab(event, ModEnchantments.HAMMERING.get());

            event.accept(ModItems.COPPER_ENHANCING_SMITHING_TEMPLATE);

            event.accept(ModItems.IRON_ADZE);
            event.accept(ModItems.GOLDEN_ADZE);
            event.accept(ModItems.DIAMOND_ADZE);
            event.accept(ModItems.NETHERITE_ADZE);

            event.accept(ModItems.IRON_HAMMER);
            event.accept(ModItems.GOLDEN_HAMMER);
            event.accept(ModItems.DIAMOND_HAMMER);
            event.accept(ModItems.NETHERITE_HAMMER);

            event.accept(ModItems.COPPER_IRON_ADZE);
            event.accept(ModItems.COPPER_GOLDEN_ADZE);
            event.accept(ModItems.COPPER_DIAMOND_ADZE);
            event.accept(ModItems.COPPER_NETHERITE_ADZE);

            event.accept(ModItems.COPPER_IRON_HAMMER);
            event.accept(ModItems.COPPER_GOLDEN_HAMMER);
            event.accept(ModItems.COPPER_DIAMOND_HAMMER);
            event.accept(ModItems.COPPER_NETHERITE_HAMMER);

            event.accept(ModItems.COPPER_BOW);
            event.accept(ModItems.COPPER_CROSSBOW);

            event.accept(ModItems.COPPER_WOODEN_SWORD);
            event.accept(ModItems.COPPER_WOODEN_SHOVEL);
            event.accept(ModItems.COPPER_WOODEN_PICKAXE);
            event.accept(ModItems.COPPER_WOODEN_AXE);
            event.accept(ModItems.COPPER_WOODEN_HOE);

            event.accept(ModItems.COPPER_STONE_SWORD);
            event.accept(ModItems.COPPER_STONE_SHOVEL);
            event.accept(ModItems.COPPER_STONE_PICKAXE);
            event.accept(ModItems.COPPER_STONE_AXE);
            event.accept(ModItems.COPPER_STONE_HOE);

            event.accept(ModItems.COPPER_IRON_SWORD);
            event.accept(ModItems.COPPER_IRON_SHOVEL);
            event.accept(ModItems.COPPER_IRON_PICKAXE);
            event.accept(ModItems.COPPER_IRON_AXE);
            event.accept(ModItems.COPPER_IRON_HOE);

            event.accept(ModItems.COPPER_GOLDEN_SWORD);
            event.accept(ModItems.COPPER_GOLDEN_SHOVEL);
            event.accept(ModItems.COPPER_GOLDEN_PICKAXE);
            event.accept(ModItems.COPPER_GOLDEN_AXE);
            event.accept(ModItems.COPPER_GOLDEN_HOE);

            event.accept(ModItems.COPPER_DIAMOND_SWORD);
            event.accept(ModItems.COPPER_DIAMOND_SHOVEL);
            event.accept(ModItems.COPPER_DIAMOND_PICKAXE);
            event.accept(ModItems.COPPER_DIAMOND_AXE);
            event.accept(ModItems.COPPER_DIAMOND_HOE);

            event.accept(ModItems.COPPER_NETHERITE_SWORD);
            event.accept(ModItems.COPPER_NETHERITE_SHOVEL);
            event.accept(ModItems.COPPER_NETHERITE_PICKAXE);
            event.accept(ModItems.COPPER_NETHERITE_AXE);
            event.accept(ModItems.COPPER_NETHERITE_HOE);
        }
    }
}

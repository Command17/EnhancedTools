package com.github.command17.enhancedtools.enchantment;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.CopperBowItem;
import com.github.command17.enhancedtools.item.CopperCrossbowItem;
import com.github.command17.enhancedtools.item.HammerItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final EnchantmentCategory COPPER_PROJECTILE_SHOOTER = EnchantmentCategory.create("copper_projectile_shooter", (item) -> (item instanceof CopperBowItem) || (item instanceof CopperCrossbowItem));
    public static final EnchantmentCategory HAMMER = EnchantmentCategory.create("hammer", (item) -> item instanceof HammerItem);

    private static final DeferredRegister<Enchantment> ENCHANTMENT_REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EnhancedTools.MOD_ID);

    public static final RegistryObject<Enchantment> EXPLOSIVE_ARROWS = ENCHANTMENT_REGISTRY.register("explosive_arrows",
            () -> new ExplosiveArrowEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    public static final RegistryObject<Enchantment> HAMMERING = ENCHANTMENT_REGISTRY.register("hammering",
            () -> new BasicEnchantment(3, Enchantment.Rarity.RARE, HAMMER, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENT_REGISTRY.register(eventBus);

        EnhancedTools.LOGGER.info("Registered Enchantments.");
    }
}

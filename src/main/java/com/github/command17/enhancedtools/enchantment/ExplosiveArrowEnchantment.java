package com.github.command17.enhancedtools.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;
import org.jetbrains.annotations.NotNull;

public class ExplosiveArrowEnchantment extends BasicEnchantment {
    public ExplosiveArrowEnchantment(Rarity rarity, EquipmentSlot... slots) {
        super(1, rarity, ModEnchantments.COPPER_PROJECTILE_SHOOTER, slots);
    }

    @Override
    protected boolean checkCompatibility(@NotNull Enchantment enchantment) {
        if (enchantment instanceof ArrowDamageEnchantment) return false;
        if (enchantment instanceof ArrowKnockbackEnchantment) return false;
        if (enchantment instanceof ArrowPiercingEnchantment) return false;
        if (enchantment instanceof ArrowFireEnchantment) return false;

        return super.checkCompatibility(enchantment);
    }

    @Override
    public int getMinCost(int level) {
        return 20;
    }

    @Override
    public int getMaxCost(int level) {
        return 50;
    }
}

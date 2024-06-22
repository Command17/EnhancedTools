package com.github.command17.enhancedtools.item;

import com.github.command17.enhancedtools.enchantment.ModEnchantments;
import com.github.command17.enhancedtools.util.IExplosiveArrow;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class CopperBowItem extends BowItem {
    public CopperBowItem(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int duration) {
        if (livingEntity instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;

            ItemStack itemStack = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - duration;

            i = ForgeEventFactory.onArrowLoose(stack, level, player, i, !itemStack.isEmpty() || flag);

            if (i < 0) return;

            if (!itemStack.isEmpty() || flag) {
                if (itemStack.isEmpty()) itemStack = new ItemStack(Items.ARROW);

                float f = getPowerForTime(i);

                if (!(f < 0.1)) {
                    boolean flag1 = player.isCreative() || itemStack.getItem() instanceof ArrowItem && ((ArrowItem) itemStack.getItem()).isInfinite(itemStack, stack, player);

                    if (!level.isClientSide) {
                        ArrowItem arrowItem = (ArrowItem) (itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);

                        AbstractArrow arrow = arrowItem.createArrow(level, itemStack, player);
                        arrow = this.customArrow(arrow);
                        arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, f * 3 * 1.5f, 0);

                        if (f == 1) arrow.setCritArrow(true);

                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);

                        if (j > 0) arrow.setBaseDamage(arrow.getBaseDamage() + j * 0.5 + 0.5);

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);

                        if (k > 0) arrow.setKnockback(k);

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) arrow.setSecondsOnFire(100);

                        if (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.EXPLOSIVE_ARROWS.get(), stack) > 0) ((IExplosiveArrow) arrow).EnhancedTools$setExplosive(true);

                        stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(player.getUsedItemHand()));

                        if (flag1 || player.getAbilities().instabuild && (itemStack.is(Items.SPECTRAL_ARROW) || itemStack.is(Items.TIPPED_ARROW))) arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;

                        level.addFreshEntity(arrow);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1, 1 / (level.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);

                    if (!flag1 && !player.isCreative()) {
                        itemStack.shrink(1);

                        if (itemStack.isEmpty()) player.getInventory().removeItem(itemStack);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 300;
    }
}

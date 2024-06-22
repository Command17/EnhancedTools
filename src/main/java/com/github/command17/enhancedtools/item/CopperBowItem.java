package com.github.command17.enhancedtools.item;

import com.github.command17.enhancedtools.enchantment.ModEnchantments;
import com.github.command17.enhancedtools.util.IExplosiveArrow;
import net.minecraft.server.level.ServerLevel;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CopperBowItem extends BowItem {
    public CopperBowItem(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int duration) {
        if (livingEntity instanceof Player player) {
            ItemStack itemStack = player.getProjectile(stack);

            if (!itemStack.isEmpty()) {
                int i = this.getUseDuration(stack, livingEntity) - duration;

                float f = getPowerForTime(i) * 1.5f;

                if (!((double) f < 0.1)) {
                    List<ItemStack> list = draw(stack, itemStack, player);

                    if (list instanceof ServerLevel serverlevel && !list.isEmpty())
                        this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f * 3, 1, f == 1, null);

                    level.playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.ARROW_SHOOT,
                            SoundSource.PLAYERS,
                            1,
                            1 / (level.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f
                    );
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public int getBurnTime(@NotNull ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return 300;
    }
}

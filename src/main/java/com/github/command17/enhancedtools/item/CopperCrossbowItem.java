package com.github.command17.enhancedtools.item;

import com.github.command17.enhancedtools.mixin.ICrossbowAccessorMixin;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class CopperCrossbowItem extends CrossbowItem {
    public CopperCrossbowItem(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);

        if (chargedprojectiles != null && !chargedprojectiles.isEmpty()) {
            this.performShooting(level, player, hand, stack, getShootingPower(chargedprojectiles), 1.0F, null);

            return InteractionResultHolder.consume(stack);
        } else if (!player.getProjectile(stack).isEmpty()) {
            ((ICrossbowAccessorMixin) this).setStartSoundPlayed(false);
            ((ICrossbowAccessorMixin) this).setMidLoadSoundPlayed(false);

            player.startUsingItem(hand);

            return InteractionResultHolder.consume(stack);
        } else return InteractionResultHolder.fail(stack);
    }

    public static float getShootingPower(ChargedProjectiles projectiles) {
        return projectiles.contains(Items.FIREWORK_ROCKET) ? 1.6f * 1.5f : 3.15f * 1.5f;
    }

    @Override
    public int getBurnTime(@NotNull ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 300;
    }
}

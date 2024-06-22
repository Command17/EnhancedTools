package com.github.command17.enhancedtools.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class HammerItem extends UniversalDiggerItem {
    public HammerItem(float attackDamage, float attackSpeed, Tier tier, Properties properties) {
        super(attackDamage, attackSpeed, tier, BlockTags.MINEABLE_WITH_PICKAXE, List.of(
                BlockTags.MINEABLE_WITH_SHOVEL,
                BlockTags.MINEABLE_WITH_HOE,
                BlockTags.MINEABLE_WITH_AXE
        ), properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) return this.speed;

        return super.getDestroySpeed(stack, state);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) return true;

        return super.isCorrectToolForDrops(stack, state);
    }
}

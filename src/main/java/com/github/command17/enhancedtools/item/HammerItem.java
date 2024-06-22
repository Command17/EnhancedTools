package com.github.command17.enhancedtools.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class HammerItem extends UniversalDiggerItem {
    public HammerItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, List.of(
                BlockTags.MINEABLE_WITH_SHOVEL,
                BlockTags.MINEABLE_WITH_HOE,
                BlockTags.MINEABLE_WITH_AXE
        ), properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Tool tool = stack.get(DataComponents.TOOL);

        if (state.is(Blocks.COBWEB) && tool != null) {
            for (Tool.Rule rule : tool.rules()) {
                if (rule.speed().isPresent() && state.is(rule.blocks())) return rule.speed().get();
            }
        }

        return super.getDestroySpeed(stack, state);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) return true;

        return super.isCorrectToolForDrops(stack, state);
    }
}

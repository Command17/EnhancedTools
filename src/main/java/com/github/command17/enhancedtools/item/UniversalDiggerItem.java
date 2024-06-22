package com.github.command17.enhancedtools.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class UniversalDiggerItem extends DiggerItem {
    private final List<TagKey<Block>> otherTagKeys;

    public UniversalDiggerItem(Tier tier, TagKey<Block> mainTagKey, List<TagKey<Block>> otherTagKeys, Properties properties) {
        super(tier, mainTagKey, properties);

        this.otherTagKeys = otherTagKeys;
    }

    @ParametersAreNonnullByDefault
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Tool tool = stack.get(DataComponents.TOOL);

        for (TagKey<Block> tagKey: this.otherTagKeys) {
            if (state.is(tagKey) && tool != null) {
                for (Tool.Rule rule : tool.rules()) {
                    if (rule.speed().isPresent() && state.is(rule.blocks())) return rule.speed().get();
                }
            }
        }

        return super.getDestroySpeed(stack, state);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        for (TagKey<Block> tagKey: this.otherTagKeys) if (state.is(tagKey)) return true;

        return super.isCorrectToolForDrops(stack, state);
    }
}

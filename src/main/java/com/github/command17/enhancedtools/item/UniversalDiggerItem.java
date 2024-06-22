package com.github.command17.enhancedtools.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class UniversalDiggerItem extends DiggerItem {
    private final List<TagKey<Block>> otherTagKeys;

    public UniversalDiggerItem(float attackDamage, float attackSpeed, Tier tier, TagKey<Block> mainTagKey, List<TagKey<Block>> otherTagKeys, Properties properties) {
        super(attackDamage, attackSpeed, tier, mainTagKey, properties);

        this.otherTagKeys = otherTagKeys;
    }

    @ParametersAreNonnullByDefault
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        for (TagKey<Block> tagKey: this.otherTagKeys) if (state.is(tagKey)) return this.speed;

        return super.getDestroySpeed(stack, state);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        for (TagKey<Block> tagKey: this.otherTagKeys) if (state.is(tagKey)) return true;

        return super.isCorrectToolForDrops(stack, state);
    }
}

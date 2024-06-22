package com.github.command17.enhancedtools.item;

import com.github.command17.enhancedtools.config.ModCommonConfig;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;

public class AdzeItem extends UniversalDiggerItem {
    public AdzeItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_AXE, List.of(BlockTags.MINEABLE_WITH_SHOVEL), properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) && ModCommonConfig.adzesAllowToolActions.get();
    }

    @Override
    @NotNull
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();

        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        Optional<BlockState> stripOptional = Optional.ofNullable(state.getToolModifiedState(context, ToolActions.AXE_STRIP, false));
        Optional<BlockState> scrapeOptional = stripOptional.isPresent() ?
                Optional.empty() : Optional.ofNullable(state.getToolModifiedState(context, ToolActions.AXE_SCRAPE, false));

        Optional<BlockState> waxOffOptional = stripOptional.isEmpty() && scrapeOptional.isEmpty() ?
                Optional.ofNullable(state.getToolModifiedState(context, ToolActions.AXE_WAX_OFF, false)) : Optional.empty();

        ItemStack stack = context.getItemInHand();

        Optional<BlockState> currentOptional = Optional.empty();

        if (stripOptional.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1, 1);

            currentOptional = stripOptional;
        } else if (scrapeOptional.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1, 1);
            level.levelEvent(player, 3005, pos, 0);

            currentOptional = scrapeOptional;
        } else if (waxOffOptional.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1, 1);
            level.levelEvent(player, 3004, pos, 0);

            currentOptional = waxOffOptional;
        }

        if (currentOptional.isPresent()) {
            if (player instanceof ServerPlayer) CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);

            level.setBlock(pos, currentOptional.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, currentOptional.get()));

            if (player != null) stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else return InteractionResult.PASS;
    }
}

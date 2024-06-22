package com.github.command17.enhancedtools.event;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.enchantment.ModEnchantments;
import com.github.command17.enhancedtools.item.HammerItem;
import com.github.command17.enhancedtools.item.ModItems;
import com.github.command17.enhancedtools.util.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedTools.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEvents {
    @SubscribeEvent
    public static void addVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.TOOLSMITH || event.getType() == VillagerProfession.WEAPONSMITH) {
            event.getTrades().get(3).add((trade, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, rand.nextInt(4, 7)),
                    new ItemStack(Items.COPPER_BLOCK),
                    new ItemStack(ModItems.COPPER_ENHANCING_SMITHING_TEMPLATE.get()),
                    3,
                    5,
                    0.02f
            ));
        }
    }

    @SubscribeEvent
    public static void breakBlockEvent(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Level level = player.level();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        ItemStack stack = player.getMainHandItem();

        if (!stack.isEmpty() && stack.getItem() instanceof HammerItem
                && EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.HAMMERING.get(), stack) > 0
                && !player.isCreative() && !player.isShiftKeyDown()) {

            BlockUtil.findBlocksWithHammering(stack, player, pos, level).forEach((otherPos) -> {
                BlockState otherState = level.getBlockState(otherPos);

                if (otherPos != pos && BlockUtil.canMineOther(stack, state, otherState)) {
                    level.destroyBlock(otherPos, false, player);

                    otherState.getBlock().playerDestroy(level, player, otherPos, otherState, level.getBlockEntity(otherPos), stack);

                    if (player.getRandom().nextBoolean()) stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                }
            });
        }
    }
}

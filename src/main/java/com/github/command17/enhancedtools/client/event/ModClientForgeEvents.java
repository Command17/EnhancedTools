package com.github.command17.enhancedtools.client.event;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.enchantment.ModEnchantments;
import com.github.command17.enhancedtools.item.HammerItem;
import com.github.command17.enhancedtools.item.ModItems;
import com.github.command17.enhancedtools.mixin.client.ILevelRendererAccessor;
import com.github.command17.enhancedtools.util.BlockUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedTools.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientForgeEvents {
    @SubscribeEvent
    public static void ModifyFOVEvent(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();

        ItemStack stack = player.getUseItem();

        float f = event.getFovModifier();

        if (player.isUsingItem()) {
            if (stack.is(ModItems.COPPER_BOW.get())) {
                int i = player.getTicksUsingItem();

                float f1 = i / 20f;

                if (f1 > 1) f1 = 1;
                else f1 *= f1;

                f *= 1 - f1 * 0.15f;
            } else if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isScoping()) {
                event.setNewFovModifier(0.1f);

                return;
            }
        }

        event.setNewFovModifier(f);
    }

    @SubscribeEvent
    public static void renderBlockOutlineEvent(RenderHighlightEvent.Block event) {
        Level level = Minecraft.getInstance().level;
        Player player = Minecraft.getInstance().player;

        if (level != null && player != null) {
            ItemStack stack = player.getMainHandItem();

            if (!stack.isEmpty() && stack.getItem() instanceof HammerItem
                    && EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.HAMMERING.get(), stack) > 0
                    && !player.isCreative() && !player.isShiftKeyDown()) {
                BlockPos pos = event.getTarget().getBlockPos();
                BlockState state = level.getBlockState(pos);

                Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();

                Vec3 camPos = camera.getPosition();

                double camX = camPos.x;
                double camY = camPos.y;
                double camZ = camPos.z;

                LevelRenderer renderer = event.getLevelRenderer();

                PoseStack poseStack = event.getPoseStack();
                MultiBufferSource.BufferSource bufferSource = ((ILevelRendererAccessor) renderer).getRenderBuffers().bufferSource();
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());

                BlockUtil.findBlocksWithHammering(stack, player, pos, level).forEach((otherPos) -> {
                    BlockState otherState = level.getBlockState(otherPos);

                    if (level.getWorldBorder().isWithinBounds(otherPos) && !otherState.isAir() && BlockUtil.canMineOther(stack, state, otherState)) {
                        ILevelRendererAccessor
                                .renderShape(
                                        poseStack,
                                        vertexConsumer,
                                        state.getShape(level, otherPos, CollisionContext.of(player)),
                                        otherPos.getX() - camX,
                                        otherPos.getY() - camY,
                                        otherPos.getZ() - camZ,
                                        0,
                                        0,
                                        0,
                                        0.4f
                                );
                    }
                });
            }
        }
    }
}

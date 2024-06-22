package com.github.command17.enhancedtools.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LevelRenderer.class)
public interface ILevelRendererAccessor {
    @Accessor("renderBuffers")
    RenderBuffers getRenderBuffers();

    @Invoker("renderShape")
    static void renderShape(PoseStack stack, VertexConsumer vertexConsumer, VoxelShape voxelShape, double x, double y, double z, float a, float b, float c, float d) {
        throw new AssertionError();
    }
}
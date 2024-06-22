package com.github.command17.enhancedtools.mixin;

import com.github.command17.enhancedtools.config.ModCommonConfig;
import com.github.command17.enhancedtools.util.IExplosiveArrow;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
public abstract class ExplosiveArrowMixin extends Entity implements IExplosiveArrow {
    @Unique
    private boolean EnhancedTools$isExplosive = false;

    public ExplosiveArrowMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void EnhancedTools$tick(CallbackInfo ci) {
        if (this.EnhancedTools$isExplosive()) {
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0.1f, 0.1, 0.1);
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void EnhancedTools$addAdditionalSaveData(CompoundTag tag, CallbackInfo ci) {
        tag.putBoolean("enhancedtools.explosive", this.EnhancedTools$isExplosive());
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void EnhancedTools$readAdditionalSaveData(CompoundTag tag, CallbackInfo ci) {
        this.EnhancedTools$setExplosive(tag.getBoolean("enhancedtools.explosive"));
    }

    @Inject(method = "onHitBlock", at = @At("TAIL"))
    public void EnhancedTools$onHitBlock(BlockHitResult hitResult, CallbackInfo ci) {
        if (this.EnhancedTools$isExplosive() && !this.level().isClientSide) this.EnhancedTools$explode();
    }

    @Inject(method = "onHitEntity", at = @At("TAIL"))
    public void EnhancedTools$onHitEntity(EntityHitResult hitResult, CallbackInfo ci) {
        if (this.EnhancedTools$isExplosive() && !this.level().isClientSide) this.EnhancedTools$explode();
    }

    @Unique
    private void EnhancedTools$explode() {
        this.level().explode(this, this.getX(), this.getY(0.0625), this.getZ(), ModCommonConfig.explosiveArrowsExplosionStrength.get(),
                ModCommonConfig.explosiveArrowsDestroyBlocks.get() ? Level.ExplosionInteraction.TNT : Level.ExplosionInteraction.NONE);

        this.discard();
    }

    @Override
    public void EnhancedTools$setExplosive(boolean value) {
        this.EnhancedTools$isExplosive = value;
    }

    @Override
    public boolean EnhancedTools$isExplosive() {
        return this.EnhancedTools$isExplosive;
    }
}

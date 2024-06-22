package com.github.command17.enhancedtools.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(CrossbowItem.class)
public interface ICrossbowAccessorMixin {
    @Accessor("startSoundPlayed")
    boolean getStartSoundPlayed();

    @Accessor("midLoadSoundPlayed")
    boolean getMidLoadSoundPlayed();

    @Accessor("startSoundPlayed")
    void setStartSoundPlayed(boolean value);

    @Accessor("midLoadSoundPlayed")
    void setMidLoadSoundPlayed(boolean value);

    @Invoker("getChargedProjectiles")
    static List<ItemStack> getChargedProjectiles(ItemStack stack) {
        throw new AssertionError();
    }

    @Invoker("onCrossbowShot")
    static void onCrossbowShot(Level level, LivingEntity entity, ItemStack stack) {
        throw new AssertionError();
    }

    @Invoker("getShotPitches")
    static float[] getShotPitches(RandomSource random) {
        throw new AssertionError();
    }
}

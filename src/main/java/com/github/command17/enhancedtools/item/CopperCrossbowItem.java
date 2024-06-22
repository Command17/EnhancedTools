package com.github.command17.enhancedtools.item;

import com.github.command17.enhancedtools.enchantment.ModEnchantments;
import com.github.command17.enhancedtools.mixin.ICrossbowAccessorMixin;
import com.github.command17.enhancedtools.util.IExplosiveArrow;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CopperCrossbowItem extends CrossbowItem {
    public CopperCrossbowItem(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (isCharged(stack)) {
            performShooting(level, player, hand, stack, this.getShootingPower(stack), -1);
            setCharged(stack, false);

            return InteractionResultHolder.consume(stack);
        } else if (!player.getProjectile(stack).isEmpty()) {
            if (!isCharged(stack)) {
                ((ICrossbowAccessorMixin) this).setStartSoundPlayed(false);
                ((ICrossbowAccessorMixin) this).setMidLoadSoundPlayed(false);

                player.startUsingItem(hand);
            }

            return InteractionResultHolder.consume(stack);
        } else {
            return InteractionResultHolder.fail(stack);
        }
    }

    private static void shootProjectile(Level level, LivingEntity entity, InteractionHand hand, ItemStack stack, ItemStack arrowStack, float p, boolean b, float x, float y, float z) {
        if (!level.isClientSide) {
            boolean flag = arrowStack.is(Items.FIREWORK_ROCKET);

            Projectile projectile;

            if (flag) projectile = new FireworkRocketEntity(level, arrowStack, entity, entity.getX(), entity.getEyeY() - 0.15000000596046448, entity.getZ(), true);
            else {
                projectile = getArrow(level, entity, stack, arrowStack);

                if (b || z != 0) ((AbstractArrow) projectile).pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }

            if (entity instanceof CrossbowAttackMob crossbowAttackMob) {
                crossbowAttackMob.shootCrossbowProjectile(crossbowAttackMob.getTarget(), stack, projectile, z);
            } else {
                Vec3 vec31 = entity.getUpVector(1);
                Quaternionf quaternionf = (new Quaternionf()).setAngleAxis(z * 0.017453292f, vec31.x, vec31.y, vec31.z);
                Vec3 vec3 = entity.getViewVector(1);
                Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);

                projectile.shoot(vector3f.x(), vector3f.y(), vector3f.z(), x, y);
            }

            stack.hurtAndBreak(flag ? 3 : 1, entity, (e) -> e.broadcastBreakEvent(hand));

            level.addFreshEntity(projectile);
            level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 1, p);
        }

    }

    private static AbstractArrow getArrow(Level level, LivingEntity entity, ItemStack stack, ItemStack arrowStack) {
        ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
        AbstractArrow arrow = arrowItem.createArrow(level, arrowStack, entity);

        if (entity instanceof Player) arrow.setCritArrow(true);

        if (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.EXPLOSIVE_ARROWS.get(), stack) > 0) ((IExplosiveArrow) arrow).EnhancedTools$setExplosive(true);

        arrow.setSoundEvent(SoundEvents.CROSSBOW_HIT);
        arrow.setShotFromCrossbow(true);

        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, stack);

        if (i > 0) arrow.setPierceLevel((byte) i);

        return arrow;
    }

    public static void performShooting(@NotNull Level level, LivingEntity entity, @NotNull InteractionHand hand, @NotNull ItemStack stack, float v, float w) {
        if (entity instanceof Player player) {
            if (ForgeEventFactory.onArrowLoose(stack, entity.level(), player, 1, true) < 0) return;
        }

        List<ItemStack> list = ICrossbowAccessorMixin.getChargedProjectiles(stack);
        float[] afloat = ICrossbowAccessorMixin.getShotPitches(entity.getRandom());

        for(int i = 0; i < list.size(); ++i) {
            ItemStack itemstack = (ItemStack)list.get(i);
            boolean flag = entity instanceof Player && ((Player) entity).isCreative();

            if (!itemstack.isEmpty()) {
                if (i == 0) {
                    shootProjectile(level, entity, hand, stack, itemstack, afloat[i], flag, v, w, 0);
                } else if (i == 1) {
                    shootProjectile(level, entity, hand, stack, itemstack, afloat[i], flag, v, w, -10);
                } else if (i == 2) {
                    shootProjectile(level, entity, hand, stack, itemstack, afloat[i], flag, v, w, 10);
                }
            }
        }

        ICrossbowAccessorMixin.onCrossbowShot(level, entity, stack);
    }

    public float getShootingPower(ItemStack stack) {
        return containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6f * 1.5f : 3.15f * 1.5f;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 300;
    }
}

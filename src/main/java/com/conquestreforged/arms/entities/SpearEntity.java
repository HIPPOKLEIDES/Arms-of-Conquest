package com.conquestreforged.arms.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpearEntity extends AbstractArrow {

    private ItemStack thrownStack;
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;
    Item spearItem;
    EntityType spearEntityType;

    public SpearEntity(EntityType<? extends SpearEntity> entityType, Level world, Item spearItem) {
        super(entityType, world);
        this.spearItem = spearItem;
        this.thrownStack = new ItemStack(spearItem);
    }

    public SpearEntity(Level world, LivingEntity livingEntity, ItemStack itemStack, EntityType spearEntityType, Item spearItem) {
        super(spearEntityType, livingEntity, world);
        this.spearEntityType = spearEntityType;
        this.thrownStack = new ItemStack(spearItem);
        this.thrownStack = itemStack.copy();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        Entity playerEntity = this.getOwner();
        if ((this.dealtDamage || this.isNoPhysics()) && playerEntity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.level.isClientSide && this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.remove(RemovalReason.KILLED);
            }
        }
        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity playerEntity = this.getOwner();
        if (playerEntity != null && playerEntity.isAlive()) {
            return !(playerEntity instanceof ServerPlayer) || !playerEntity.isSpectator();
        } else {
            return false;
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.thrownStack.copy();
    }

    @Override
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return this.dealtDamage ? null : super.findHitEntity(startVec, endVec);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityRayTraceResult) {
        Entity entityHit = entityRayTraceResult.getEntity();
        float f = 8.0F;
        if (entityHit instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) entityHit;
            f += EnchantmentHelper.getDamageBonus(this.thrownStack, livingentity.getMobType());
        }

        Entity entityPlayer = this.getOwner();
        DamageSource damagesource = DamageSource.trident(this, (entityPlayer == null ? this : entityPlayer));
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
        if (entityHit.hurt(damagesource, f)) {
            if (entityHit.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entityHit instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity) entityHit;
                if (entityPlayer instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, entityPlayer);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity) entityPlayer, livingentity1);
                }
                this.doPostHurtEffects(livingentity1);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        if (this.level instanceof ServerLevel && this.level.isThundering() && EnchantmentHelper.hasChanneling(this.thrownStack)) {
            BlockPos blockpos = entityHit.blockPosition();
            if (this.level.canSeeSky(blockpos)) {
                LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(this.level);
                lightningboltentity.moveTo(Vec3.atBottomCenterOf(blockpos));
                lightningboltentity.setCause(entityPlayer instanceof ServerPlayer ? (ServerPlayer)entityPlayer : null);
                this.level.addFreshEntity(lightningboltentity);
                soundevent = SoundEvents.TRIDENT_THUNDER;
                f1 = 5.0F;
            }
        }

        this.playSound(soundevent, f1, 1.0F);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    public void playerTouch(Player playerHit) {
        Entity entityShooter = this.getOwner();
        if (entityShooter == null || entityShooter.getUUID() == playerHit.getUUID()) {
            super.playerTouch(playerHit);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundNBT) {
        super.readAdditionalSaveData(compoundNBT);
        if (compoundNBT.contains("Spear", 10)) {
            this.thrownStack = ItemStack.of(compoundNBT.getCompound("Spear"));
        }

        this.dealtDamage = compoundNBT.getBoolean("DealtDamage");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundNBT) {
        super.addAdditionalSaveData(compoundNBT);
        compoundNBT.put("Spear", this.thrownStack.save(new CompoundTag()));
        compoundNBT.putBoolean("DealtDamage", this.dealtDamage);
    }

    /**Tells when to remove the entity, I think*/
    @Override
    protected void tickDespawn() {
        if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    @Override
    protected float getWaterInertia() {
        return 0.99F;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean shouldRender(double val1, double val2, double val3) {
        return true;
    }

}

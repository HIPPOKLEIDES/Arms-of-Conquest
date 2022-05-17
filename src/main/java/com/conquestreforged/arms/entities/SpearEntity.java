package com.conquestreforged.arms.entities;

import com.conquestreforged.arms.init.ItemInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpearEntity extends AbstractArrowEntity {

    private ItemStack thrownStack;
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;


    public SpearEntity(EntityType<? extends SpearEntity> entityType, World world) {
        super(entityType, world);
        this.thrownStack = new ItemStack(ItemInit.spear_iron);
    }

    public SpearEntity(World world, LivingEntity livingEntity, ItemStack itemStack) {
        super(EntityTypes.SPEAR_IRON, livingEntity, world);
        this.thrownStack = new ItemStack(ItemInit.spear_iron);
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
                if (!this.level.isClientSide && this.pickup == AbstractArrowEntity.PickupStatus.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.remove();
            }
        }
        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity playerEntity = this.getOwner();
        if (playerEntity != null && playerEntity.isAlive()) {
            return !(playerEntity instanceof ServerPlayerEntity) || !playerEntity.isSpectator();
        } else {
            return false;
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.thrownStack.copy();
    }

    @Override
    protected EntityRayTraceResult findHitEntity(Vector3d startVec, Vector3d endVec) {
        return this.dealtDamage ? null : super.findHitEntity(startVec, endVec);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult entityRayTraceResult) {
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
        if (this.level instanceof ServerWorld && this.level.isThundering() && EnchantmentHelper.hasChanneling(this.thrownStack)) {
            BlockPos blockpos = entityHit.blockPosition();
            if (this.level.canSeeSky(blockpos)) {
                LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(this.level);
                lightningboltentity.moveTo(Vector3d.atBottomCenterOf(blockpos));
                lightningboltentity.setCause(entityPlayer instanceof ServerPlayerEntity ? (ServerPlayerEntity)entityPlayer : null);
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
    public void playerTouch(PlayerEntity playerHit) {
        Entity entityShooter = this.getOwner();
        if (entityShooter == null || entityShooter.getUUID() == playerHit.getUUID()) {
            super.playerTouch(playerHit);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compoundNBT) {
        super.readAdditionalSaveData(compoundNBT);
        if (compoundNBT.contains("Spear", 10)) {
            this.thrownStack = ItemStack.of(compoundNBT.getCompound("Spear"));
        }

        this.dealtDamage = compoundNBT.getBoolean("DealtDamage");
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compoundNBT) {
        super.addAdditionalSaveData(compoundNBT);
        compoundNBT.put("Spear", this.thrownStack.save(new CompoundNBT()));
        compoundNBT.putBoolean("DealtDamage", this.dealtDamage);
    }

    /**Tells when to remove the entity, I think*/
    @Override
    protected void tickDespawn() {
        if (this.pickup != AbstractArrowEntity.PickupStatus.ALLOWED) {
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

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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class SpearEntity extends AbstractArrowEntity {

    private ItemStack thrownStack;
    private boolean dealtDamage;

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
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerData() {
        super.registerData();
    }

    @Override
    public void tick() {
        if (this.timeInGround > 4) {
            this.dealtDamage = true;
        }
        Entity playerEntity = this.getShooter();
        if ((this.dealtDamage || this.getNoClip()) && playerEntity != null) {
            if (!this.shouldReturnToThrower()) {
                if (!this.world.isRemote && this.pickupStatus == PickupStatus.ALLOWED) {
                    this.entityDropItem(this.getArrowStack(), 0.1F);
                }
                this.remove();
            }
        }
        super.tick();
    }

    private boolean shouldReturnToThrower() {
        Entity playerEntity = this.getShooter();
        if (playerEntity != null && playerEntity.isAlive()) {
            return !(playerEntity instanceof ServerPlayerEntity) || !playerEntity.isSpectator();
        } else {
            return false;
        }
    }

    @Override
    protected ItemStack getArrowStack() {
        return this.thrownStack.copy();
    }

    @Override
    protected EntityRayTraceResult rayTraceEntities(Vec3d startVec, Vec3d endVec) {
        return this.dealtDamage ? null : super.rayTraceEntities(startVec, endVec);
    }

    @Override
    protected void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
        Entity entityHit = entityRayTraceResult.getEntity();
        float f = 8.0F;
        if (entityHit instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) entityHit;
            f += EnchantmentHelper.getModifierForCreature(this.thrownStack, livingentity.getCreatureAttribute());
        }

        Entity entityPlayer = this.getShooter();
        DamageSource damagesource = DamageSource.causeTridentDamage(this, (entityPlayer == null ? this : entityPlayer));
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entityHit.attackEntityFrom(damagesource, f)) {
            if (entityHit.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entityHit instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity) entityHit;
                if (entityPlayer instanceof LivingEntity) {
                    EnchantmentHelper.applyThornEnchantments(livingentity1, entityPlayer);
                    EnchantmentHelper.applyArthropodEnchantments((LivingEntity) entityPlayer, livingentity1);
                }
                this.arrowHit(livingentity1);
            }
        }

        this.setMotion(this.getMotion().mul(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        if (this.world instanceof ServerWorld && this.world.isThundering() && EnchantmentHelper.hasChanneling(this.thrownStack)) {
            BlockPos blockpos = entityHit.getPosition();
            if (this.world.canSeeSky(blockpos)) {
                LightningBoltEntity lightningboltentity = new LightningBoltEntity(this.world, (double) blockpos.getX() + 0.5D, (double) blockpos.getY(), (double) blockpos.getZ() + 0.5D, false);
                lightningboltentity.setCaster(entityPlayer instanceof ServerPlayerEntity ? (ServerPlayerEntity) entityPlayer : null);
                ((ServerWorld) this.world).addLightningBolt(lightningboltentity);
                soundevent = SoundEvents.ITEM_TRIDENT_THUNDER;
                f1 = 5.0F;
            }
        }

        this.playSound(soundevent, f1, 1.0F);
    }

    @Override
    protected SoundEvent getHitEntitySound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    @Override
    public void onCollideWithPlayer(PlayerEntity playerHit) {
        Entity entityShooter = this.getShooter();
        if (entityShooter == null || entityShooter.getUniqueID() == playerHit.getUniqueID()) {
            super.onCollideWithPlayer(playerHit);
        }
    }

    @Override
    public void readAdditional(CompoundNBT compoundNBT) {
        super.readAdditional(compoundNBT);
        if (compoundNBT.contains("Spear", 10)) {
            this.thrownStack = ItemStack.read(compoundNBT.getCompound("Spear"));
        }

        this.dealtDamage = compoundNBT.getBoolean("DealtDamage");
    }

    @Override
    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.put("Spear", this.thrownStack.write(new CompoundNBT()));
        compoundNBT.putBoolean("DealtDamage", this.dealtDamage);
    }

    /**Tells when to remove the entity, I think*/
    @Override
    protected void func_225516_i_() {
        if (this.pickupStatus != AbstractArrowEntity.PickupStatus.ALLOWED) {
            super.func_225516_i_();
        }
    }

    @Override
    protected float getWaterDrag() {
        return 0.99F;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRender3d(double val1, double val2, double val3) {
        return true;
    }

}

package com.conquestreforged.arms.events;

import com.conquestreforged.arms.network.NetworkHandler;
import com.conquestreforged.arms.network.PacketOverextendedReachAttack;
import com.conquestreforged.arms.util.ModTags;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.AttackIndicatorStatus;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    @SubscribeEvent
    public static void onMouseOver(RenderGameOverlayEvent.Post overlayEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        Player playerEntity = minecraft.player;
        ItemStack weapon = playerEntity.getMainHandItem();
        if (isValuableBlock(weapon.getItem()) && getEntityMouseOverExtension(7.0F) instanceof EntityHitResult) {

            if (minecraft.gameMode.getPlayerMode() != GameType.SPECTATOR || isTargetNamedMenuProvider(minecraft.hitResult)) {
                int scaledHeight = minecraft.getWindow().getGuiScaledHeight();
                int scaledWidth = minecraft.getWindow().getGuiScaledWidth();

                if (minecraft.options.attackIndicator == AttackIndicatorStatus.CROSSHAIR) {
                    float f = minecraft.player.getAttackStrengthScale(0.0F);
                    boolean flag = false;
                    if (minecraft.getCameraEntity() != null && minecraft.getCameraEntity() instanceof LivingEntity && f >= 1.0F) {
                        flag = minecraft.player.getCurrentItemAttackStrengthDelay() > 5.0F;
                        flag = flag & minecraft.getCameraEntity().isAlive();
                    }
                    int j = scaledHeight / 2 - 7 + 16;
                    int k = scaledWidth / 2 - 8;
                    if (flag) {
                        RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
                        minecraft.gui.blit(overlayEvent.getMatrixStack(), k, j, 68, 94, 16, 16);
                    }
                }

            }
        }
    }

    private static boolean isTargetNamedMenuProvider(HitResult rayTraceIn) {
        Minecraft minecraft = Minecraft.getInstance();
        if (rayTraceIn == null) {
            return false;
        } else if (rayTraceIn.getType() == HitResult.Type.ENTITY) {
            return ((EntityHitResult)rayTraceIn).getEntity() instanceof MenuProvider;
        } else if (rayTraceIn.getType() == HitResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockHitResult)rayTraceIn).getBlockPos();
            Level world = minecraft.level;
            return world.getBlockState(blockpos).getMenuProvider(world, blockpos) != null;
        } else {
            return false;
        }
    }

    @SubscribeEvent
    public static void onMouseInputEvent(InputEvent.MouseInputEvent mouseInputEvent) {
        KeyMapping attackKey = Minecraft.getInstance().options.keyAttack;
        if (mouseInputEvent.getButton() == attackKey.getKey().getValue() && mouseInputEvent.getAction() == 1) {
            checkWeaponReach();
        }
    }

    @SubscribeEvent
    public static void onKeyInputEvent(InputEvent.KeyInputEvent keyInputEvent) {
        KeyMapping attackKey = Minecraft.getInstance().options.keyAttack;
        if (keyInputEvent.getKey() == attackKey.getKey().getValue() && keyInputEvent.getAction() == 1) {
            checkWeaponReach();
        }
    }

    private static void checkWeaponReach() {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (minecraft.level != null && minecraft.screen == null && !minecraft.isPaused() && player != null) {
            ItemStack weapon = player.getMainHandItem();
            if (isValuableBlock(weapon.getItem())) {
                //Log.info("Attempting Reach Attack!");
                float reach = 7.0F;
                HitResult rayTraceResult = getEntityMouseOverExtension(reach);
                if (rayTraceResult instanceof EntityHitResult) {
                    Entity entityHit = ((EntityHitResult)rayTraceResult).getEntity();
                    if (entityHit != null && entityHit.invulnerableTime == 0 && entityHit != player && entityHit != player.getVehicle()) {
                        float velocity = 0.0F;
                        if (player.getVehicle() != null) {
                            Entity riding = player.getVehicle();
                            Vec3 vec = riding.getDeltaMovement();
                            velocity = (float)vec.length();
                        }

                        NetworkHandler.sendPacketToServer(new PacketOverextendedReachAttack(entityHit.getId()));
                        //Log.info("Overextended Reach Packet sent");
                    }
                }
            }
        }
    }

    private static HitResult getEntityMouseOverExtension (float reach) {
        HitResult result = null;
        Minecraft minecraft = Minecraft.getInstance();
        Entity viewedEntity = minecraft.getCameraEntity();
        //Log.info("getEntityMouseOverExtension check1");
        //Log.info(viewedEntity.toString());
        if (viewedEntity != null) {
            double d0 = reach;
            HitResult rayTraceResult = viewedEntity.pick(d0, 0.0F, false);
            Vec3 eyePos = viewedEntity.getEyePosition(0.0F);
            boolean flag = false;
            double d1 = d0;
            if(minecraft.gameMode.hasFarPickRange() && d0 < 6.0D) {
                d1 = 6.0D;
                d0 = d1;
            } else if (d0 > (double)reach) {
                flag = true;
            }

            d1 *= d1;
            if (rayTraceResult != null) {
                d1 = rayTraceResult.getLocation().distanceToSqr(eyePos);
            }

            Vec3 lookVec = viewedEntity.getViewVector(1.0F);
            Vec3 attackVec = eyePos.add(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0);
            AABB expBounds = viewedEntity.getBoundingBox().expandTowards(lookVec.scale(d0)).inflate(1.0D, 1.0D, 1.0D);
            EntityHitResult entityRayTraceResult = ProjectileUtil.getEntityHitResult(viewedEntity, eyePos, attackVec, expBounds, (entity) -> {
                return !entity.isSpectator();
            }, d1 );

            //Log.info("getEntityMouseOverExtension check2");
            if (entityRayTraceResult != null) {
                Vec3 hitVec = entityRayTraceResult.getLocation();
                double d2 = eyePos.distanceToSqr(hitVec);
                if (flag && d2 > (double)(reach * reach)) {
                    //Log.info("getEntityMouseOverExtension miss1");
                    result = BlockHitResult.miss(hitVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(hitVec));
                } else if (d2 < d1 || result == null) {
                    //Log.info("getEntityMouseOverExtension success");
                    result = entityRayTraceResult;
                }
            } else {
                //Log.info("getEntityMouseOverExtension miss2");
                result = BlockHitResult.miss(attackVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(attackVec));
            }
        }
        return (HitResult)result;
    }

    private static boolean isValuableBlock(Item item) {
        return Registry.ITEM.getHolderOrThrow(Registry.ITEM.getResourceKey(item).get()).is(ModTags.Items.SPEARS);
    }

}

package com.conquestreforged.arms.events;

import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.network.NetworkHandler;
import com.conquestreforged.arms.network.PacketOverextendedReachAttack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.settings.AttackIndicatorStatus;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jline.utils.Log;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    @SubscribeEvent
    public static void onMouseOver(RenderGameOverlayEvent.Post overlayEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        PlayerEntity playerEntity = minecraft.player;
        ItemStack weapon = playerEntity.getMainHandItem();
        if (weapon.getItem() instanceof ModSpear && getEntityMouseOverExtension(7.0F) instanceof EntityRayTraceResult) {

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
                        minecraft.getTextureManager().bind((AbstractGui.GUI_ICONS_LOCATION));
                        minecraft.gui.blit(overlayEvent.getMatrixStack(), k, j, 68, 94, 16, 16);
                    }
                }

            }
        }
    }

    private static boolean isTargetNamedMenuProvider(RayTraceResult rayTraceIn) {
        Minecraft minecraft = Minecraft.getInstance();
        if (rayTraceIn == null) {
            return false;
        } else if (rayTraceIn.getType() == RayTraceResult.Type.ENTITY) {
            return ((EntityRayTraceResult)rayTraceIn).getEntity() instanceof INamedContainerProvider;
        } else if (rayTraceIn.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult)rayTraceIn).getBlockPos();
            World world = minecraft.level;
            return world.getBlockState(blockpos).getMenuProvider(world, blockpos) != null;
        } else {
            return false;
        }
    }

    @SubscribeEvent
    public static void onMouseInputEvent(InputEvent.MouseInputEvent mouseInputEvent) {
        KeyBinding attackKey = Minecraft.getInstance().options.keyAttack;
        if (mouseInputEvent.getButton() == attackKey.getKey().getValue() && mouseInputEvent.getAction() == 1) {
            checkWeaponReach();
        }
    }

    @SubscribeEvent
    public static void onKeyInputEvent(InputEvent.KeyInputEvent keyInputEvent) {
        KeyBinding attackKey = Minecraft.getInstance().options.keyAttack;
        if (keyInputEvent.getKey() == attackKey.getKey().getValue() && keyInputEvent.getAction() == 1) {
            checkWeaponReach();
        }
    }

    private static void checkWeaponReach() {
        Minecraft minecraft = Minecraft.getInstance();
        PlayerEntity player = minecraft.player;
        if (minecraft.level != null && minecraft.screen == null && !minecraft.isPaused() && player != null) {
            ItemStack weapon = player.getMainHandItem();
            if (weapon.getItem() instanceof ModSpear) {
                //Log.info("Attempting Reach Attack!");
                float reach = 7.0F;
                RayTraceResult rayTraceResult = getEntityMouseOverExtension(reach);
                if (rayTraceResult instanceof EntityRayTraceResult) {
                    Entity entityHit = ((EntityRayTraceResult)rayTraceResult).getEntity();
                    if (entityHit != null && entityHit.invulnerableTime == 0 && entityHit != player && entityHit != player.getVehicle()) {
                        float velocity = 0.0F;
                        if (player.getVehicle() != null) {
                            Entity riding = player.getVehicle();
                            Vector3d vec = riding.getDeltaMovement();
                            velocity = (float)vec.length();
                        }

                        NetworkHandler.sendPacketToServer(new PacketOverextendedReachAttack(entityHit.getId()));
                        //Log.info("Overextended Reach Packet sent");
                    }
                }
            }
        }
    }

    private static RayTraceResult getEntityMouseOverExtension (float reach) {
        RayTraceResult result = null;
        Minecraft minecraft = Minecraft.getInstance();
        Entity viewedEntity = minecraft.getCameraEntity();
        //Log.info("getEntityMouseOverExtension check1");
        //Log.info(viewedEntity.toString());
        if (viewedEntity != null) {
            double d0 = reach;
            RayTraceResult rayTraceResult = viewedEntity.pick(d0, 0.0F, false);
            Vector3d eyePos = viewedEntity.getEyePosition(0.0F);
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

            Vector3d lookVec = viewedEntity.getViewVector(1.0F);
            Vector3d attackVec = eyePos.add(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0);
            AxisAlignedBB expBounds = viewedEntity.getBoundingBox().expandTowards(lookVec.scale(d0)).inflate(1.0D, 1.0D, 1.0D);
            EntityRayTraceResult entityRayTraceResult = ProjectileHelper.getEntityHitResult(viewedEntity, eyePos, attackVec, expBounds, (entity) -> {
                return Boolean.TRUE;
            }, d1 );

            //Log.info("getEntityMouseOverExtension check2");
            if (entityRayTraceResult != null) {
                Vector3d hitVec = entityRayTraceResult.getLocation();
                double d2 = eyePos.distanceToSqr(hitVec);
                if (flag && d2 > (double)(reach * reach)) {
                    //Log.info("getEntityMouseOverExtension miss1");
                    result = BlockRayTraceResult.miss(hitVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(hitVec));
                } else if (d2 < d1 || result == null) {
                    //Log.info("getEntityMouseOverExtension success");
                    result = entityRayTraceResult;
                }
            } else {
                //Log.info("getEntityMouseOverExtension miss2");
                result = BlockRayTraceResult.miss(attackVec, Direction.getNearest(lookVec.x, lookVec.y, lookVec.z), new BlockPos(attackVec));
            }
        }
        return (RayTraceResult)result;
    }

}

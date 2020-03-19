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
        ItemStack weapon = playerEntity.getHeldItemMainhand();
        if (weapon.getItem() instanceof ModSpear && getEntityMouseOverExtension(7.0F) instanceof EntityRayTraceResult) {

            if (minecraft.playerController.getCurrentGameType() != GameType.SPECTATOR || isTargetNamedMenuProvider(minecraft.objectMouseOver)) {
                int scaledHeight = minecraft.getMainWindow().getScaledHeight();
                int scaledWidth = minecraft.getMainWindow().getScaledWidth();

                if (minecraft.gameSettings.attackIndicator == AttackIndicatorStatus.CROSSHAIR) {
                    float f = minecraft.player.getCooledAttackStrength(0.0F);
                    boolean flag = false;
                    if (minecraft.getRenderViewEntity() != null && minecraft.getRenderViewEntity() instanceof LivingEntity && f >= 1.0F) {
                        flag = minecraft.player.getCooldownPeriod() > 5.0F;
                        flag = flag & minecraft.getRenderViewEntity().isAlive();
                    }
                    int j = scaledHeight / 2 - 7 + 16;
                    int k = scaledWidth / 2 - 8;
                    if (flag) {
                        minecraft.getTextureManager().bindTexture((AbstractGui.GUI_ICONS_LOCATION));
                        minecraft.ingameGUI.blit(k, j, 68, 94, 16, 16);
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
            BlockPos blockpos = ((BlockRayTraceResult)rayTraceIn).getPos();
            World world = minecraft.world;
            return world.getBlockState(blockpos).getContainer(world, blockpos) != null;
        } else {
            return false;
        }
    }

    @SubscribeEvent
    public static void onMouseInputEvent(InputEvent.MouseInputEvent mouseInputEvent) {
        KeyBinding attackKey = Minecraft.getInstance().gameSettings.keyBindAttack;
        if (mouseInputEvent.getButton() == attackKey.getKey().getKeyCode() && mouseInputEvent.getAction() == 1) {
            checkWeaponReach();
        }
    }

    @SubscribeEvent
    public static void onKeyInputEvent(InputEvent.KeyInputEvent keyInputEvent) {
        KeyBinding attackKey = Minecraft.getInstance().gameSettings.keyBindAttack;
        if (keyInputEvent.getKey() == attackKey.getKey().getKeyCode() && keyInputEvent.getAction() == 1) {
            checkWeaponReach();
        }
    }

    private static void checkWeaponReach() {
        Minecraft minecraft = Minecraft.getInstance();
        PlayerEntity player = minecraft.player;
        if (minecraft.world != null && minecraft.currentScreen == null && !minecraft.isGamePaused() && player != null) {
            ItemStack weapon = player.getHeldItemMainhand();
            if (weapon.getItem() instanceof ModSpear) {
                Log.info("Attempting Reach Attack!");
                float reach = 7.0F;
                RayTraceResult rayTraceResult = getEntityMouseOverExtension(reach);
                if (rayTraceResult instanceof EntityRayTraceResult) {
                    Entity entityHit = ((EntityRayTraceResult)rayTraceResult).getEntity();
                    if (entityHit != null && entityHit.hurtResistantTime == 0 && entityHit != player && entityHit != player.getRidingEntity()) {
                        NetworkHandler.sendPacketToServer(new PacketOverextendedReachAttack(entityHit.getEntityId()));
                        Log.info("Overextended Reach Packet sent");
                    }
                }
            }
        }
    }

    private static RayTraceResult getEntityMouseOverExtension (float reach) {
        RayTraceResult result = null;
        Minecraft minecraft = Minecraft.getInstance();
        Entity viewedEntity = minecraft.getRenderViewEntity();
        //Log.info("getEntityMouseOverExtension check1");
        //Log.info(viewedEntity.toString());
        if (viewedEntity != null) {
            double d0 = reach;
            RayTraceResult rayTraceResult = viewedEntity.pick(d0, 0.0F, false);
            Vec3d eyePos = viewedEntity.getEyePosition(0.0F);
            boolean flag = false;
            double d1 = d0;
            if(minecraft.playerController.extendedReach() && d0 < 6.0D) {
                d1 = 6.0D;
                d0 = d1;
            } else if (d0 > (double)reach) {
                flag = true;
            }

            if (rayTraceResult != null) {
                d1 = rayTraceResult.getHitVec().squareDistanceTo(eyePos);
            }

            Vec3d lookVec = viewedEntity.getLook(1.0F);
            Vec3d attackVec = eyePos.add(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0);
            AxisAlignedBB expBounds = viewedEntity.getBoundingBox().expand(lookVec.scale(d0)).grow(1.0D, 1.0D, 1.0D);
            EntityRayTraceResult entityRayTraceResult = ProjectileHelper.rayTraceEntities(viewedEntity, eyePos, attackVec, expBounds, (entity) -> !entity.isSpectator() && entity.canBeCollidedWith(), d1 );

            //Log.info("getEntityMouseOverExtension check2");
            if (entityRayTraceResult != null) {
                Vec3d hitVec = entityRayTraceResult.getHitVec();
                double d2 = eyePos.squareDistanceTo(hitVec);
                if (flag && d2 > (double)(reach * reach)) {
                    result = BlockRayTraceResult.createMiss(hitVec, Direction.getFacingFromVector(lookVec.x, lookVec.y, lookVec.z), new BlockPos(hitVec));
                } else if (d2 < d1 || result == null) {
                    result = entityRayTraceResult;
                }
            } else {
                result = BlockRayTraceResult.createMiss(attackVec, Direction.getFacingFromVector(lookVec.x, lookVec.y, lookVec.z), new BlockPos(attackVec));
            }
        }
        return (RayTraceResult)result;
    }

}

package com.conquestreforged.arms.network;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.jline.utils.Log;

import java.util.function.Supplier;

public class PacketOverextendedReachAttack {
    private int entityID;

    public PacketOverextendedReachAttack(int entityID) {
        this.entityID = entityID;
    }

    public static void encode(PacketOverextendedReachAttack packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.entityID);
    }

    public static PacketOverextendedReachAttack decode(FriendlyByteBuf buf) {
        return new PacketOverextendedReachAttack(buf.readInt());
    }

    public static class Handler {
        public Handler() {
        }

        public static void handle(PacketOverextendedReachAttack packet, Supplier<NetworkEvent.Context> ctx) {
            if (packet != null) {
                ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
                    ServerPlayer player = ((NetworkEvent.Context)ctx.get()).getSender();
                    Entity target = player.level.getEntity(packet.entityID);
                    if (player != null && target != null) {
                        Log.info("Victim of attack: " + target.toString());
                        ItemStack weapon = player.getMainHandItem();
                        {
                             { {
                                    //temp value
                                    float reach = ((ModSpear)weapon.getItem()).getSpearLength();
                                    double distanceSquared = player.distanceToSqr(target);
                                    double reachSquared = (double)(reach * reach);
                                    if (reachSquared >= distanceSquared) {
                                        player.attack(target);
                                        Log.info("Attacking victim!");
                                    }
                                }

                                player.swing(InteractionHand.MAIN_HAND);
                                player.resetAttackStrengthTicker();
                            }

                        }
                    }
                });
            }
        }
    }
}

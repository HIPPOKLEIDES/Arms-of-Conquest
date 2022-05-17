package com.conquestreforged.arms.network;

import com.conquestreforged.arms.items.ModSpear;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent;
import org.jline.utils.Log;

import java.util.function.Supplier;

public class PacketOverextendedReachAttack {
    private int entityID;

    public PacketOverextendedReachAttack(int entityID) {
        this.entityID = entityID;
    }

    public static void encode(PacketOverextendedReachAttack packet, PacketBuffer buf) {
        buf.writeInt(packet.entityID);
    }

    public static PacketOverextendedReachAttack decode(PacketBuffer buf) {
        return new PacketOverextendedReachAttack(buf.readInt());
    }

    public static class Handler {
        public Handler() {
        }

        public static void handle(PacketOverextendedReachAttack packet, Supplier<NetworkEvent.Context> ctx) {
            if (packet != null) {
                ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
                    ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                    Entity target = player.level.getEntity(packet.entityID);
                    if (player != null && target != null) {
                        Log.info("Victim of attack: " + target.toString());
                        ItemStack weapon = player.getMainHandItem();
                        if (weapon.getItem() instanceof ModSpear) {
                             { {
                                    //temp value
                                    float reach = 7.0F;
                                    double distanceSquared = player.distanceToSqr(target);
                                    double reachSquared = (double)(reach * reach);
                                    if (reachSquared >= distanceSquared) {
                                        player.attack(target);
                                        Log.info("Attacking victim!");
                                    }
                                }

                                player.swing(Hand.MAIN_HAND);
                                player.resetAttackStrengthTicker();
                            }

                        }
                    }
                });
            }
        }
    }
}

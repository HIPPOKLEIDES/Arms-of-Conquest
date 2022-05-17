package com.conquestreforged.arms.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {
    protected static final String PROTOCOL_VERSION = "1";
    protected static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("arms_of_conquest", "network")).clientAcceptedVersions("1"::equals).serverAcceptedVersions("1"::equals).networkProtocolVersion(() -> {
        return "1";
    }).simpleChannel();
    protected static int nextPacketID = 0;

    public NetworkHandler() {
    }

    public static void init() {
        INSTANCE.registerMessage(getNextPacketID(), PacketOverextendedReachAttack.class, PacketOverextendedReachAttack::encode, PacketOverextendedReachAttack::decode, PacketOverextendedReachAttack.Handler::handle);
    }

    public static int getNextPacketID() {
        int id = nextPacketID++;
        return id;
    }

    public static void sendPacketTo(Object packet, ServerPlayerEntity player) {
        if (!(player instanceof FakePlayer)) {
            INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }

    }

    public static void sendPacketToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}

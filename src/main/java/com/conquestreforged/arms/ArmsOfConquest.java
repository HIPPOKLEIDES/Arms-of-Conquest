package com.conquestreforged.arms;


import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("arms_of_conquest")
public class ArmsOfConquest {
    public static final String MOD_ID = "arms_of_conquest";

    public ArmsOfConquest() {
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);
        // Register the setup method for modloading
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);

        ItemInit.REGISTER.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onSetup(FMLCommonSetupEvent ev) {
        ev.enqueueWork(() -> {
            NetworkHandler.init();
        });
    }
}

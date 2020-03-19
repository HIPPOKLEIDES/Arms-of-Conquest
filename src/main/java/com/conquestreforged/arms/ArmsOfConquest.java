package com.conquestreforged.arms;

import com.conquestreforged.arms.network.NetworkHandler;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jline.utils.Log;

@Mod("arms_of_conquest")
public class ArmsOfConquest {
    public static final String MOD_ID = "arms_of_conquest";

    public ArmsOfConquest() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);
    }

    private void onSetup(FMLCommonSetupEvent ev) {
        Log.info("Setting up Spartan Weaponry!");
        DeferredWorkQueue.runLater(() -> {
            NetworkHandler.init();
        });
    }
}

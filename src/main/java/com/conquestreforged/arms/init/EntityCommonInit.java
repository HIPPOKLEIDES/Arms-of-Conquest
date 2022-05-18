package com.conquestreforged.arms.init;

import com.conquestreforged.arms.entities.EntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityCommonInit {

    @SubscribeEvent
    public static void entities(RegistryEvent.Register<EntityType<?>> event) {
        registerWeapons(event.getRegistry());
    }

    private static void registerWeapons(IForgeRegistry<EntityType<?>> registry) {
          registry.register(EntityTypes.SPEAR_IRON);
    }
}

package com.conquestreforged.arms.init;

import com.conquestreforged.arms.items.ModSpear;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static Item spear_iron = new ModSpear(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "spear_iron"));

    @SubscribeEvent
    public static void init(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(spear_iron);
    }
}

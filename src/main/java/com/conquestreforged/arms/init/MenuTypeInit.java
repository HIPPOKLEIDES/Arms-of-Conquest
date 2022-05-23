package com.conquestreforged.arms.init;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.screens.ArmorStationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeInit {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, ArmsOfConquest.MOD_ID);

    public static final RegistryObject<MenuType<ArmorStationMenu>> ARMS_STATION_MENU = registerMenuType((p1, p2, p3) -> new ArmorStationMenu(p1, p2), "arms_station_menu");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
}

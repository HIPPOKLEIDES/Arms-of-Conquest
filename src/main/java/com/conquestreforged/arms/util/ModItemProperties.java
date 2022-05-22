package com.conquestreforged.arms.util;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.ModShield;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.stream.Collectors;

public class ModItemProperties {

    public static final ResourceLocation HAS_PROP = new ResourceLocation(ArmsOfConquest.MOD_ID, "blocking");

    public static void addCustomItemProperties() {
        //Create properties for Shield items
        List<RegistryObject<Item>> shields = ItemInit.REGISTER.getEntries().stream()
                .filter(shield -> shield.get() instanceof ModShield)
                .collect(Collectors.toList());
        shields.forEach(shield -> makeShield(shield.get()));


    }

    private static void makeShield(Item item) {
        ItemProperties.register(item, new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) -> {
            return p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F;
        });
    }
}

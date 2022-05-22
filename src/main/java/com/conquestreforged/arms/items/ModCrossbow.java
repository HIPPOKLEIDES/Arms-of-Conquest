package com.conquestreforged.arms.items;

import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;

public class ModCrossbow extends CrossbowItem {
    public ModCrossbow(Properties props) {
        super(props);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 72000;
        //return super.getUseDuration(itemStack);
    }
}

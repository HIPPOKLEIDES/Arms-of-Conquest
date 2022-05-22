package com.conquestreforged.arms.items;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class ModShield extends ShieldItem {
    public ModShield(Properties props) {
        super(props);
    }

    @Override
    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return true;
    }
}

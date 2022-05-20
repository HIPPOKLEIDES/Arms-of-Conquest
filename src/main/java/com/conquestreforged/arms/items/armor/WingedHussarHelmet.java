package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.ArmsOfConquest;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class WingedHussarHelmet extends ArmorModelItem {


    public WingedHussarHelmet(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
    }

    @Override
    public HumanoidModel<?> getModelInstance() {
        return null;
    }

    //@Override
    //protected <A extends HumanoidModel<?>> A getBaseModelInstance() {
    //    return (A) ModelWingedHussarHelmet.INSTANCE;
    //}

    protected <A extends HumanoidModel<?>> A displays(A armorModel, EquipmentSlot slot) {
        armorModel.head.visible = false;
        armorModel.hat.visible = false;
        armorModel.body.visible = false;
        armorModel.rightArm.visible = false;
        armorModel.leftArm.visible = false;
        armorModel.rightLeg.visible = false;
        armorModel.leftLeg.visible = false;
        return armorModel;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return ArmsOfConquest.MOD_ID + ":textures/models/armor/" + "winged_hussar" + "_layer_1.png";
    }
}

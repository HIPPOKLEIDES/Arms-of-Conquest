package com.conquestreforged.arms.items.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;

public class WingedHussarBoots extends ArmorModelItem {


    public WingedHussarBoots(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
    }

    @Override
    public HumanoidModel<?> getModelInstance() {
        return null;
    }

    //@Override
    //protected <A extends HumanoidModel<?>> A getBaseModelInstance() {
    //    return (A) ModelWingedHussarBoots.INSTANCE;
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
}

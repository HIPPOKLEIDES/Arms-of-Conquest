package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelWingedHussarBoots;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarLegs;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;

import net.minecraft.world.item.Item.Properties;

public class WingedHussarBoots extends ArmorModelItem {


    public WingedHussarBoots(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
    }

    @Override
    protected <A extends HumanoidModel<?>> A getBaseModelInstance() {
        return (A) ModelWingedHussarBoots.INSTANCE;
    }

    @Override
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

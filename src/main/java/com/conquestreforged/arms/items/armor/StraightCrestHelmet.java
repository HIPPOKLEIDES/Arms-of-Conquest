package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelFlatCrestHelmet;
import com.conquestreforged.arms.items.armor.models.ModelStraightCrestHelmet;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterial;

import net.minecraft.world.item.Item.Properties;

public class StraightCrestHelmet extends ArmorModelItem {


    public StraightCrestHelmet(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
    }

    @Override
    protected <A extends HumanoidModel<?>> A getBaseModelInstance() {
        return (A) ModelStraightCrestHelmet.INSTANCE;
    }

    @Override
    protected <A extends HumanoidModel<?>> A displays(A armorModel, EquipmentSlot slot) {
        armorModel.head.visible = true;
        armorModel.hat.visible = true;
        armorModel.body.visible = false;
        armorModel.rightArm.visible = false;
        armorModel.leftArm.visible = false;
        armorModel.rightLeg.visible = false;
        armorModel.leftLeg.visible = false;
        return armorModel;
    }
}

package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelFlatCrestHelmet;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;

public class FlatCrestHelmet extends ArmorModelItem {


    public FlatCrestHelmet(IArmorMaterial material, EquipmentSlotType head, Properties props) {
        super(material, head, props);
    }

    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelFlatCrestHelmet.INSTANCE;
    }

    @Override
    protected <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot) {
        armorModel.bipedHead.showModel = true;
        armorModel.bipedHeadwear.showModel = true;
        armorModel.bipedBody.showModel = false;
        armorModel.bipedRightArm.showModel = false;
        armorModel.bipedLeftArm.showModel = false;
        armorModel.bipedRightLeg.showModel = false;
        armorModel.bipedLeftLeg.showModel = false;
        return armorModel;
    }
}

package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelStraightCrestHelmet;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarChest;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;

public class WingedHussarChest extends ArmorModelItem {


    public WingedHussarChest(IArmorMaterial material, EquipmentSlotType head, Properties props) {
        super(material, head, props);
    }

    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelWingedHussarChest.INSTANCE;
    }

    @Override
    protected <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot) {
        armorModel.bipedHead.showModel = false;
        armorModel.bipedHeadwear.showModel = false;
        armorModel.bipedBody.showModel = false;
        armorModel.bipedRightArm.showModel = false;
        armorModel.bipedLeftArm.showModel = false;
        armorModel.bipedRightLeg.showModel = false;
        armorModel.bipedLeftLeg.showModel = false;
        return armorModel;
    }
}

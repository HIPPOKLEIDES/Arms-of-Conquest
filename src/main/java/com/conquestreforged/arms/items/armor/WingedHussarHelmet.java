package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarHelmet;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarLegs;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class WingedHussarHelmet extends ArmorModelItem {


    public WingedHussarHelmet(IArmorMaterial material, EquipmentSlotType head, Properties props) {
        super(material, head, props);
    }

    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelWingedHussarHelmet.INSTANCE;
    }

    @Override
    protected <A extends BipedModel<?>> A displays(A armorModel, EquipmentSlotType slot) {
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
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return ArmsOfConquest.MOD_ID + ":textures/models/armor/" + "winged_hussar" + "_layer_1.png";
    }
}

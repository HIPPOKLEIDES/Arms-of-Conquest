package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarChest;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarLegs;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class WingedHussarPants extends ArmorModelItem {


    public WingedHussarPants(IArmorMaterial material, EquipmentSlotType head, Properties props) {
        super(material, head, props);
    }

    @Override
    protected <A extends BipedModel<?>> A getBaseModelInstance() {
        return (A) ModelWingedHussarLegs.INSTANCE;
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

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return ArmsOfConquest.MOD_ID + ":textures/models/armor/" + "winged_hussar" + "_layer_1.png";
    }
}

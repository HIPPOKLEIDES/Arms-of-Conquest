package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelFlatCrestHelmet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;

public class FlatCrestHelmet extends ArmorModelItem {

    public FlatCrestHelmet(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
    }

    @Override
    public HumanoidModel<?> getModelInstance() {
        return new ModelFlatCrestHelmet(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlatCrestHelmet.LAYER_LOCATION));
    }
}

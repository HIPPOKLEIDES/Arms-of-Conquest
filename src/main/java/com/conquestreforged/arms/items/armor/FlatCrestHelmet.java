package com.conquestreforged.arms.items.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import java.lang.reflect.InvocationTargetException;

public class FlatCrestHelmet<T> extends ArmorModelItem {

    private final Class<T> model;
    private final ModelLayerLocation layerLocation;
    private final String armorTexture;

    public FlatCrestHelmet(ArmorMaterial material, EquipmentSlot head, Properties props, Class<T> model, ModelLayerLocation layerLocation, String armorTexture) {
        super(material, head, props);
        this.model = model;
        this.layerLocation = layerLocation;
        this.armorTexture = armorTexture;

    }

    @Override
    public HumanoidModel<?> getModelInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (HumanoidModel<?>) model.getConstructor(ModelPart.class).newInstance(Minecraft.getInstance().getEntityModels().bakeLayer(layerLocation));
        //return new ModelFlatCrestHelmet(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlatCrestHelmet.LAYER_LOCATION));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return armorTexture;
    }
}

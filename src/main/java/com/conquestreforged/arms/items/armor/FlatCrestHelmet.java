package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelFlatCrestHelmet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;

import java.lang.reflect.InvocationTargetException;

public class FlatCrestHelmet<T> extends ArmorModelItem {

    private Class<T> model;
    private ModelLayerLocation layerLocation;

    public FlatCrestHelmet(ArmorMaterial material, EquipmentSlot head, Properties props, Class<T> model, ModelLayerLocation layerLocation) {
        super(material, head, props);
        this.model = model;
        this.layerLocation = layerLocation;

    }

    @Override
    public HumanoidModel<?> getModelInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (HumanoidModel<?>) model.getConstructor(ModelPart.class).newInstance(Minecraft.getInstance().getEntityModels().bakeLayer(layerLocation));
        //return new ModelFlatCrestHelmet(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlatCrestHelmet.LAYER_LOCATION));
    }
}

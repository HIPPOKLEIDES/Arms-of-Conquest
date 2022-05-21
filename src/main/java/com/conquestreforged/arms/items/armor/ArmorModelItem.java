package com.conquestreforged.arms.items.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

public class ArmorModelItem<T> extends ArmorItem {

    private final Class<T> model;
    private final ModelLayerLocation layerLocation;
    private final String armorTexture;

    public ArmorModelItem(ArmorMaterial material, EquipmentSlot head, Properties props, Class<T> model, ModelLayerLocation layerLocation, String armorTexture) {
        super(material, head, props);
        this.model = model;
        this.layerLocation = layerLocation;
        this.armorTexture = armorTexture;

    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                try {
                    return getModelInstance();
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public HumanoidModel<?> getModelInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (HumanoidModel<?>) model.getConstructor(ModelPart.class).newInstance(Minecraft.getInstance().getEntityModels().bakeLayer(layerLocation));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return armorTexture;
    }
}

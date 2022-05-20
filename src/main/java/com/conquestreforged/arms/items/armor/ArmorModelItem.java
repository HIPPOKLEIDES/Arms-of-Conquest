package com.conquestreforged.arms.items.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public abstract class ArmorModelItem extends ArmorItem {

    private HumanoidModel model;

    public ArmorModelItem(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
        this.model = model;
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                return getModelInstance();
            }
        });
    }

    public abstract  HumanoidModel<?> getModelInstance();

    /*static class ModelSupplier implements IItemRenderProperties {

        private HumanoidModel instance;

        public ModelSupplier(HumanoidModel instance) {
            this.instance = instance;
        }

        @Override
        public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
            if (instance == null) instance = new ModelFlatCrestHelmet(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlatCrestHelmet.LAYER_LOCATION));
            return instance;
        }
    }*/
}

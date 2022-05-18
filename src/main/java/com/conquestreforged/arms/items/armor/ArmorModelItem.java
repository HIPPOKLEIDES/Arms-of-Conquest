package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelFlatCrestHelmet;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.function.Consumer;

public abstract class ArmorModelItem extends ArmorItem {
    public ArmorModelItem(ArmorMaterial material, EquipmentSlot head, Properties props) {
        super(material, head, props);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new ModelSupplier());
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A defaultModel) {
        if (itemStack != null) {
            if (itemStack.getItem() instanceof ArmorItem && defaultModel != null && armorSlot != null) {
                A armorModel = this.getBaseModelInstance();
                armorModel = displays(armorModel, armorSlot);

                armorModel.crouching = defaultModel.crouching;
                armorModel.riding = defaultModel.riding;
                armorModel.young = defaultModel.young;
                armorModel.rightArmPose = defaultModel.rightArmPose;
                armorModel.leftArmPose = defaultModel.leftArmPose;

                return armorModel;
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    protected abstract <A extends HumanoidModel<?>> A getBaseModelInstance();

    @OnlyIn(Dist.CLIENT)
    protected abstract <A extends HumanoidModel<?>> A displays(A armorModel, EquipmentSlot slot);

    static class ModelSupplier implements IItemRenderProperties {
        public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel _default) {
            return ModelFlatCrestHelmet.INSTANCE;
        }
    }
}

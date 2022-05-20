package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelWingedHussarHelmet<T extends LivingEntity> extends HumanoidModel<T> {
    //private final ModelPart helmet;

    //public static final ModelWingedHussarHelmet<LivingEntity> INSTANCE = new ModelWingedHussarHelmet<LivingEntity>();

    public ModelWingedHussarHelmet(ModelPart root) {
        super(root);
        /*super(1, 0, 128, 128);
        texWidth = 128;
        texHeight = 128;

        helmet = new ModelPart(this);
        helmet.setPos(0.0F, 24.5F, 0.0F);
        helmet.texOffs(0, 32).addBox(-4.0F, -32.5F, -4.0F, 8.0F, 8.0F, 8.0F, 0.55F, false);
        helmet.texOffs(0, 48).addBox(-3.5F, -33.65F, -3.5F, 7.0F, 7.0F, 7.0F, 0.5F, false);
        helmet.texOffs(17, 112).addBox(-4.5F, -29.68F, -7.5F, 9.0F, 0.0F, 12.0F, 0.55F, false);
        helmet.texOffs(32, 32).addBox(-4.0F, -32.5F, -4.0F, 8.0F, 8.0F, 8.0F, 1.05F, false);
        helmet.texOffs(32, 48).addBox(-4.0F, -32.5F, -4.0F, 8.0F, 8.0F, 8.0F, 1.55F, false);
        helmet.texOffs(4, 99).addBox(0.61F, -38.73F, -5.06F, 0.0F, 8.0F, 9.0F, 0.61F, false);
        
        this.head.addChild(helmet);

         */
    }

    @Override
    public void renderToBuffer(PoseStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.head.visible = true;
        super.renderToBuffer(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }
}

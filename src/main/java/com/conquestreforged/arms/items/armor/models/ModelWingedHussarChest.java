package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

/**
 * ModelCenturionHelmet - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelWingedHussarChest<T extends LivingEntity> extends HumanoidModel<T> {
    //private final ModelPart Chestplate;
    //private final ModelPart Back;
    //private final ModelPart Back2;
    //private final ModelPart rightarm;
    //private final ModelPart leftarm;
    //private final ModelPart rightleg;
    //private final ModelPart leftleg;

    //public static final ModelWingedHussarChest<LivingEntity> INSTANCE = new ModelWingedHussarChest<LivingEntity>();

    public ModelWingedHussarChest(ModelPart root) {
        super(root);

        /*super(0, 0, 128, 128);
        texWidth = 128;
        texHeight = 128;

        Chestplate = new ModelPart(this);
        Chestplate.setPos(0.0F, 24.0F, 0.0F);
        Chestplate.texOffs(64, 0).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.262F, false);
        Chestplate.texOffs(102, 13).addBox(-4.0F, -24.0F, -2.5F, 8.0F, 14.0F, 5.0F, 0.263F, false);
        Chestplate.texOffs(64, 20).addBox(0.0F, -43.5F, 2.5F, 0.0F, 32.0F, 12.0F, 0.0F, false);

        Back = new ModelPart(this);
        Back.setPos(-1.0F, 0.0F, 1.0F);
        Chestplate.addChild(Back);
        setRotateAngle(Back, 0.0F, 0.3491F, 0.0F);
        Back.texOffs(88, 20).addBox(3.5F, -43.5F, 2.5F, 0.0F, 32.0F, 12.0F, 0.0F, false);

        Back2 = new ModelPart(this);
        Back2.setPos(0.5F, 0.0F, 1.0F);
        Chestplate.addChild(Back2);
        setRotateAngle(Back2, 0.0F, -0.3491F, 0.0F);
        Back2.texOffs(88, 20).addBox(-3.0302F, -43.5F, 2.329F, 0.0F, 32.0F, 12.0F, 0.0F, false);

        rightarm = new ModelPart(this);
        rightarm.setPos(0.0F, 24.0F, 0.0F);
        rightarm.texOffs(112, 32).addBox(-3.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.259F, false);

        leftarm = new ModelPart(this);
        leftarm.setPos(0.0F, 24.0F, 0.0F);
        leftarm.texOffs(112, 48).addBox(-1.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.259F, false);

        rightleg = new ModelPart(this);
        rightleg.setPos(0.0F, 24.0F, 0.0F);
        rightleg.texOffs(80, 16).addBox(-1.98F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.261F, false);

        leftleg = new ModelPart(this);
        leftleg.setPos(0.0F, 24.0F, 0.0F);
        leftleg.texOffs(64, 16).addBox(-2.02F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2615F, false);

        this.rightArm.addChild(rightarm);
        this.leftArm.addChild(leftarm);
        this.rightLeg.addChild(rightleg);
        this.leftLeg.addChild(leftleg);

        this.body.addChild(Chestplate);

         */

    }

    @Override
    public void renderToBuffer(PoseStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.body.visible = true;
        this.rightLeg.visible = true;
        this.leftLeg.visible = true;
        super.renderToBuffer(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

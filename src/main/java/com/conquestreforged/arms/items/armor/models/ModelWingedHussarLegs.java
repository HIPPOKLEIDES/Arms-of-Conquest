package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

/**
 * ModelCenturionHelmet - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelWingedHussarLegs<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer Chestplate;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;

    public static final ModelWingedHussarLegs<LivingEntity> INSTANCE = new ModelWingedHussarLegs<LivingEntity>();

    public ModelWingedHussarLegs() {
        super(0, 0, 128, 128);
        texWidth = 128;
        texHeight = 128;

        Chestplate = new ModelRenderer(this);
        Chestplate.setPos(0.0F, 24.0F, 0.0F);
        Chestplate.texOffs(64, 64).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.261F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setPos(0.0F, 24.0F, 0.0F);
        rightarm.texOffs(96, 64).addBox(-3.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setPos(0.0F, 24.0F, 0.0F);
        leftarm.texOffs(96, 80).addBox(-1.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setPos(0.0F, 24.0F, 0.0F);
        rightleg.texOffs(80, 80).addBox(-1.98F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(0.0F, 24.0F, 0.0F);
        leftleg.texOffs(64, 80).addBox(-2.02F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.253F, false);

        this.rightArm.addChild(rightarm);
        this.leftArm.addChild(leftarm);
        this.rightLeg.addChild(rightleg);
        this.leftLeg.addChild(leftleg);

        this.body.addChild(Chestplate);

    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.leftArm.visible = true;
        this.rightArm.visible = true;
        this.body.visible = true;
        this.rightLeg.visible = true;
        this.leftLeg.visible = true;
        super.renderToBuffer(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

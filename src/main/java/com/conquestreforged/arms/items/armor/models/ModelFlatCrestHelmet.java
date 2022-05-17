package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

/**
 * ModelCenturionHelmet - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelFlatCrestHelmet<T extends LivingEntity> extends BipedModel<T> {
    public ModelRenderer crest_rl;
    public ModelRenderer neck;

    public static final ModelFlatCrestHelmet<LivingEntity> INSTANCE = new ModelFlatCrestHelmet<LivingEntity>();

    //delta parameter is scale
    public ModelFlatCrestHelmet() {
        super(1, 0, 64, 64);
        this.texWidth = 64;
        this.texHeight = 64;
        this.crest_rl = new ModelRenderer(this, 0, 40);
        this.crest_rl.setPos(0.0F, 0.0F, 0.0F);
        this.crest_rl.addBox(-12.0F, -24.0F, 0.0F, 24, 24, 0, 2.0F);
        this.neck = new ModelRenderer(this, 8, 16);
        this.neck.setPos(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-8.0F, -3.0F, -9.0F, 16, 0, 16, 2.0F);
        this.setRotateAngle(neck, -0.39269908169872414F, 0.0F, 0.0F);

        this.crest_rl.addChild(neck);
        this.head.addChild(crest_rl);

        //this.shape15 = new ModelRenderer(this, 0, 0);
        //this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.shape15.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        //this.shape15_1 = new ModelRenderer(this, 32, 0);
        //this.shape15_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.shape15_1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.head.visible = true;
        super.renderToBuffer(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

        //this.shape16_1.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //this.shape15.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //this.shape16.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //GlStateManager.pushMatrix();
        //GlStateManager.translatef(0, 0, 0);
        //GlStateManager.translatef(this.shape15_1.rotationPointX * p_225598_8_, this.shape15_1.rotationPointY * p_225598_8_, this.shape15_1.rotationPointZ * p_225598_8_);
        ;
        //GlStateManager.translatef(-0, -0, -0);
        //GlStateManager.translatef(-this.shape15_1.rotationPointX * p_225598_8_, -this.shape15_1.rotationPointY * p_225598_8_, -this.shape15_1.rotationPointZ * p_225598_8_);
        //this.shape15_1.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //GlStateManager.popMatrix();

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

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
public class ModelStraightCrestHelmet<T extends LivingEntity> extends BipedModel<T> {
    public ModelRenderer helmet_main;
    public ModelRenderer neck;
    public ModelRenderer helmet_main_outer;
    public ModelRenderer crest_fb;
    public ModelRenderer helmet_main_outer_2;

    public static final ModelStraightCrestHelmet<LivingEntity> INSTANCE = new ModelStraightCrestHelmet<LivingEntity>();

    public ModelStraightCrestHelmet() {
        super(0, 0, 64, 64);
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.neck = new ModelRenderer(this, -16, 40);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-8.0F, -3.4F, -9.1F, 16, 0, 16, 0.0F);
        this.setRotateAngle(neck, -0.39269908169872414F, 0.0F, 0.0F);
        this.crest_fb = new ModelRenderer(this, 0, -8);
        this.crest_fb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.crest_fb.addBox(0.0F, -24.0F, -6.0F, 0, 24, 24, 0.0F);
        this.helmet_main_outer_2 = new ModelRenderer(this, 24, 48);
        this.helmet_main_outer_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helmet_main_outer_2.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.99F);

        this.crest_fb.addChild(neck);
        this.crest_fb.addChild(helmet_main_outer_2);
        this.bipedHead.addChild(crest_fb);

        //this.shape15 = new ModelRenderer(this, 0, 0);
        //this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.shape15.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        //this.shape15_1 = new ModelRenderer(this, 32, 0);
        //this.shape15_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.shape15_1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.bipedHead.showModel = true;
        super.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

        //this.shape16_1.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //this.shape15.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //this.shape16.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //GlStateManager.pushMatrix();
        //GlStateManager.translatef(0, 0, 0);
        //GlStateManager.translatef(this.shape15_1.rotationPointX * p_225598_8_, this.shape15_1.rotationPointY * p_225598_8_, this.shape15_1.rotationPointZ * p_225598_8_);
        //GlStateManager.scalef(1.125F, 1.125F, 1.125F);
        //GlStateManager.translatef(-0, -0, -0);
        //GlStateManager.translatef(-this.shape15_1.rotationPointX * p_225598_8_, -this.shape15_1.rotationPointY * p_225598_8_, -this.shape15_1.rotationPointZ * p_225598_8_);
        //this.shape15_1.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        //GlStateManager.popMatrix();

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

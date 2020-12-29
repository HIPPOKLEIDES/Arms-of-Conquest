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
        textureWidth = 128;
        textureHeight = 128;

        Chestplate = new ModelRenderer(this);
        Chestplate.setRotationPoint(0.0F, 24.0F, 0.0F);
        Chestplate.setTextureOffset(64, 64).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.261F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightarm.setTextureOffset(96, 64).addBox(-3.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftarm.setTextureOffset(96, 80).addBox(-1.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightleg.setTextureOffset(80, 80).addBox(-1.98F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftleg.setTextureOffset(64, 80).addBox(-2.02F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.253F, false);

        this.bipedRightArm.addChild(rightarm);
        this.bipedLeftArm.addChild(leftarm);
        this.bipedRightLeg.addChild(rightleg);
        this.bipedLeftLeg.addChild(leftleg);

        this.bipedBody.addChild(Chestplate);

    }

    @Override
    public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.bipedLeftArm.showModel = true;
        this.bipedRightArm.showModel = true;
        this.bipedBody.showModel = true;
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;
        super.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

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

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
public class ModelWingedHussarChest<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer Chestplate;
    private final ModelRenderer Back;
    private final ModelRenderer Back2;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;

    public static final ModelWingedHussarChest<LivingEntity> INSTANCE = new ModelWingedHussarChest<LivingEntity>();

    public ModelWingedHussarChest() {
        super(0, 0, 128, 128);
        textureWidth = 128;
        textureHeight = 128;

        Chestplate = new ModelRenderer(this);
        Chestplate.setRotationPoint(0.0F, 24.0F, 0.0F);
        Chestplate.setTextureOffset(64, 0).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.262F, false);
        Chestplate.setTextureOffset(102, 13).addBox(-4.0F, -24.0F, -2.5F, 8.0F, 14.0F, 5.0F, 0.263F, false);
        Chestplate.setTextureOffset(64, 20).addBox(0.0F, -43.5F, 2.5F, 0.0F, 32.0F, 12.0F, 0.0F, false);

        Back = new ModelRenderer(this);
        Back.setRotationPoint(-1.0F, 0.0F, 1.0F);
        Chestplate.addChild(Back);
        setRotateAngle(Back, 0.0F, 0.3491F, 0.0F);
        Back.setTextureOffset(88, 20).addBox(3.5F, -43.5F, 2.5F, 0.0F, 32.0F, 12.0F, 0.0F, false);

        Back2 = new ModelRenderer(this);
        Back2.setRotationPoint(0.5F, 0.0F, 1.0F);
        Chestplate.addChild(Back2);
        setRotateAngle(Back2, 0.0F, -0.3491F, 0.0F);
        Back2.setTextureOffset(88, 20).addBox(-3.0302F, -43.5F, 2.329F, 0.0F, 32.0F, 12.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightarm.setTextureOffset(112, 32).addBox(-3.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.259F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftarm.setTextureOffset(112, 48).addBox(-1.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.259F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightleg.setTextureOffset(80, 16).addBox(-1.98F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.261F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftleg.setTextureOffset(64, 16).addBox(-2.02F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2615F, false);

        this.bipedRightArm.addChild(rightarm);
        this.bipedLeftArm.addChild(leftarm);
        this.bipedRightLeg.addChild(rightleg);
        this.bipedLeftLeg.addChild(leftleg);

        this.bipedBody.addChild(Chestplate);

    }

    @Override
    public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
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

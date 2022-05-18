package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

/**
 * ModelCenturionHelmet - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelFlatCrestHelmet<T extends LivingEntity> extends HumanoidModel<T> {
    public ModelPart crest_rl;
    public ModelPart neck;

    private final ModelPart head;

    public static final ModelFlatCrestHelmet<LivingEntity> INSTANCE = new ModelFlatCrestHelmet<>(Minecraft.getInstance().getEntityModels().bakeLayer(new ModelLayerLocation(new ResourceLocation(MOD_ID, "centurion_helmet"), "main")));

    public ModelFlatCrestHelmet(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale2x = new CubeDeformation(2.0F, 2.0F, 2.0F);

        //Crest
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 40).addBox(-12.0F, -24.0F, 0.0F, 24, 24, 0, scale2x), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Neck
        PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -3.0F, -9.0F, 16, 0, 16, scale2x), PartPose.rotation(-0.39F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);

        //super(1, 0, 64, 64);
        //this.texWidth = 64;
        //this.texHeight = 64;
        //this.crest_rl = new ModelPart(this, 0, 40);
        //this.crest_rl.setPos(0.0F, 0.0F, 0.0F);
        //this.crest_rl.addBox(-12.0F, -24.0F, 0.0F, 24, 24, 0, 2.0F);
        //this.neck = new ModelPart(this, 8, 16);
        //this.neck.setPos(0.0F, 0.0F, 0.0F);
        //this.neck.addBox(-8.0F, -3.0F, -9.0F, 16, 0, 16, 2.0F);
        //this.setRotateAngle(neck, -0.39269908169872414F, 0.0F, 0.0F);

        //this.crest_rl.addChild(neck);
        //this.head.addChild(crest_rl);

        //this.shape15 = new ModelRenderer(this, 0, 0);
        //this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.shape15.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        //this.shape15_1 = new ModelRenderer(this, 32, 0);
        //this.shape15_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.shape15_1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.head.visible = true;
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        super.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

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
    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

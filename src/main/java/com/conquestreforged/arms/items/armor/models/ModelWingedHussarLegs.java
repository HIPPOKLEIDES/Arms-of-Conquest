package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

public class ModelWingedHussarLegs<T extends LivingEntity> extends HumanoidModel<T> {
    private final ModelPart chest;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "winged_hussar_legs"), "main");

    public ModelWingedHussarLegs(ModelPart root) {
        super(root);
        this.chest = root.getChild("body");
        this.rightarm = root.getChild("right_arm");
        this.leftarm = root.getChild("left_arm");
        this.rightleg = root.getChild("right_leg");
        this.leftleg = root.getChild("left_leg");

        /*super(0, 0, 128, 128);
        texWidth = 128;
        texHeight = 128;

        Chestplate = new ModelPart(this);
        Chestplate.setPos(0.0F, 24.0F, 0.0F);
        Chestplate.texOffs(64, 64).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.261F, false);

        rightarm = new ModelPart(this);
        rightarm.setPos(0.0F, 24.0F, 0.0F);
        rightarm.texOffs(96, 64).addBox(-3.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        leftarm = new ModelPart(this);
        leftarm.setPos(0.0F, 24.0F, 0.0F);
        leftarm.texOffs(96, 80).addBox(-1.0F, -26.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        rightleg = new ModelPart(this);
        rightleg.setPos(0.0F, 24.0F, 0.0F);
        rightleg.texOffs(80, 80).addBox(-1.98F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.252F, false);

        leftleg = new ModelPart(this);
        leftleg.setPos(0.0F, 24.0F, 0.0F);
        leftleg.texOffs(64, 80).addBox(-2.02F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.253F, false);

        this.rightArm.addChild(rightarm);
        this.leftArm.addChild(leftarm);
        this.rightLeg.addChild(rightleg);
        this.leftLeg.addChild(leftleg);

        this.body.addChild(Chestplate);

         */

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale2 = new CubeDeformation(0.261F, 0.261F, 0.261F);
        CubeDeformation scale3 = new CubeDeformation(0.253F, 0.253F, 0.253F);
        CubeDeformation scale4 = new CubeDeformation(0.252F, 0.252F, 0.252F);

        //Chestplate
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 64).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, scale2), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(96, 64).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(96, 80).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(80, 80).addBox(-1.98F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(64, 80).addBox(-2.02F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale3), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Parts are unused and not rendered but necessary to "add"" to avoid crash
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.leftArm.visible = true;
        this.rightArm.visible = true;
        this.body.visible = true;
        this.rightLeg.visible = true;
        this.leftLeg.visible = true;
        chest.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);

    }


}

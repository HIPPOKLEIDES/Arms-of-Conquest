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

public class ModelWingedHussarChest<T extends LivingEntity> extends HumanoidModel<T> {
    private final ModelPart body;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "winged_hussar"), "main");

    public ModelWingedHussarChest(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.rightarm = root.getChild("right_arm");
        this.leftarm = root.getChild("left_arm");
        this.rightleg = root.getChild("right_leg");
        this.leftleg = root.getChild("left_leg");
        /*super(0, 0, 128, 128);
        texWidth = 128;
        texHeight = 128;


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

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale0 = new CubeDeformation(0.262F, 0.262F, 0.262F);
        CubeDeformation scale1 = new CubeDeformation(0.263F, 0.263F, 0.263F);
        CubeDeformation scale2 = new CubeDeformation(0.261F, 0.261F, 0.261F);
        CubeDeformation scale3 = new CubeDeformation(0.2615F, 0.2615F, 0.2615F);
        CubeDeformation scale4 = new CubeDeformation(0.259F, 0.259F, 0.259F);

        //Chestplate
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, scale0), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body1 = body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(102, 13).addBox(-4.0F, 0.0F, -2.5F, 8.0F, 14.0F, 5.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(64, 20).addBox(0.0F, -19.5F, 2.5F, 0.0F, 32.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Wings
        PartDefinition back1 = body2.addOrReplaceChild("back1", CubeListBuilder.create().texOffs(87, 20).addBox(3.5F, -19.5F, 2.5F, 0.0F, 32.0F, 12.0F, scale2), PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.0F, 0.3491F, 0.0F));
        PartDefinition back2 = back1.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(87, 20).addBox(-3.0302F, -19.5F, 2.329F, 0.0F, 32.0F, 12.0F, scale3), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, 5.6509F, 0.0F));

        //Arms
        PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(112, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(112, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));


        //Right Foot
        PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(80, 16).addBox(-1.98F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Left Foot
        PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(64, 16).addBox(-2.02F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale2), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Parts are unused and not rendered but necessary to "add"" to avoid crash
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        this.leftleg.visible = true;
        this.rightleg.visible = true;
        leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);

    }

}

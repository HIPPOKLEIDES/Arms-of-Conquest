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

public class ModelWingedHussarHelmet<T extends LivingEntity> extends HumanoidModel<T> {

    private final ModelPart head;

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "winged_hussar_helmet"), "main");

    public ModelWingedHussarHelmet(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
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

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale0 = new CubeDeformation(0.55F, 0.55F, 0.55F);
        CubeDeformation scale1 = new CubeDeformation(0.5F, 0.5F, 0.5F);
        CubeDeformation scale2 = new CubeDeformation(1.05F, 1.05F, 1.05F);
        CubeDeformation scale3 = new CubeDeformation(1.55F, 1.55F, 1.55F);
        CubeDeformation scale4 = new CubeDeformation(0.61F, 0.61F, 0.61F);

        //Helmet
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8F, -4.0F, 8.0F, 8.0F, 8.0F, scale0), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head1 = head.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 16).addBox(-3.5F, -9.15F, -3.5F, 7.0F, 7.0F, 7.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head2 = head1.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(17, 48).addBox(-4.5F, -5.18F, -7.5F, 9.0F, 0.0F, 12.0F, scale0), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head3 = head2.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, scale2), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head4 = head3.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(32, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, scale3), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head5 = head4.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(4, 35).addBox(0.61F, -14.23F, -5.06F, 0.0F, 8.0F, 9.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));


        //Parts are unused and not rendered but necessary to "add"" to avoid crash
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(-5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-1.9F, 12.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}

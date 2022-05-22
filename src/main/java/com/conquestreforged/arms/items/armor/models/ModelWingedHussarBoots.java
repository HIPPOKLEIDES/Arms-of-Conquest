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

public class ModelWingedHussarBoots<T extends LivingEntity> extends HumanoidModel<T> {
    private final ModelPart rightleg;
    private final ModelPart leftleg;

    //Winged Hussar chest also uses right_leg and left_leg, so texture here needs to be separate
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "winged_hussar_boots"), "main");

    public ModelWingedHussarBoots(ModelPart root) {
        super(root);
        this.rightleg = root.getChild("right_leg");
        this.leftleg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale1 = new CubeDeformation(0.265F, 0.265F, 0.265F);
        CubeDeformation scale2 = new CubeDeformation(0.266F, 0.266F, 0.266F);

        //Right Foot
        PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(112, 80).addBox(-1.98F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Left Foot
        PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(112, 64).addBox(-2.02F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale2), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Parts are unused and not rendered but necessary to "add"" to avoid crash
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(-5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(5.0F, 2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

}

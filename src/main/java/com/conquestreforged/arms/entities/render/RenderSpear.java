package com.conquestreforged.arms.entities.render;

import com.conquestreforged.arms.entities.SpearEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

@OnlyIn(Dist.CLIENT)
public class RenderSpear extends EntityRenderer<SpearEntity> {

    public static final ResourceLocation SPEAR = new ResourceLocation(MOD_ID, "textures/entity/spear.png");
    private final ModelSpear spearModel = new ModelSpear();

    public RenderSpear(EntityRendererProvider.Context p_i48828_1_) {
        super(p_i48828_1_);
    }

    @Override
    public void render(SpearEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.yRotO) - 90.0F));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.xRotO) + 90.0F));
        VertexConsumer ivertexbuilder = net.minecraft.client.renderer.entity.ItemRenderer.getFoilBufferDirect(bufferIn, this.spearModel.renderType(this.getTextureLocation(entityIn)), false, false);
        this.spearModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(SpearEntity entity) {
        return SPEAR;
    }

}

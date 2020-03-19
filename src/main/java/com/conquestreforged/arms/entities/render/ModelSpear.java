package com.conquestreforged.arms.entities.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelSpear extends Model {
    private final ModelRenderer modelRenderer = new ModelRenderer(32, 32, 0, 3);

    public ModelSpear() {
        super(RenderType::getEntitySolid);
        /**1st parameter centers it, 2nd transforms it so that it'll stick into blocks, 5th increases length of the spear*/
        this.modelRenderer.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 28.0F, 1.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}

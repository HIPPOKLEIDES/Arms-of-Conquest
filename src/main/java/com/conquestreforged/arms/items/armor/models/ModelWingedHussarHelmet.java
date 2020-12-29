package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelWingedHussarHelmet<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer helmet;

    public static final ModelWingedHussarHelmet<LivingEntity> INSTANCE = new ModelWingedHussarHelmet<LivingEntity>();

    public ModelWingedHussarHelmet() {
        super(1, 0, 128, 128);
        textureWidth = 128;
        textureHeight = 128;

        helmet = new ModelRenderer(this);
        helmet.setRotationPoint(0.0F, 24.5F, 0.0F);
        helmet.setTextureOffset(0, 32).addBox(-4.0F, -32.5F, -4.0F, 8.0F, 8.0F, 8.0F, 0.55F, false);
        helmet.setTextureOffset(0, 48).addBox(-3.5F, -33.65F, -3.5F, 7.0F, 7.0F, 7.0F, 0.5F, false);
        helmet.setTextureOffset(17, 112).addBox(-4.5F, -29.68F, -7.5F, 9.0F, 0.0F, 12.0F, 0.55F, false);
        helmet.setTextureOffset(32, 32).addBox(-4.0F, -32.5F, -4.0F, 8.0F, 8.0F, 8.0F, 1.05F, false);
        helmet.setTextureOffset(32, 48).addBox(-4.0F, -32.5F, -4.0F, 8.0F, 8.0F, 8.0F, 1.55F, false);
        helmet.setTextureOffset(4, 99).addBox(0.61F, -38.73F, -5.06F, 0.0F, 8.0F, 9.0F, 0.61F, false);
        
        this.bipedHead.addChild(helmet);
    }

    @Override
    public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.bipedHead.showModel = true;
        super.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }
}

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
public class ModelWingedHussarBoots<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;

    public static final ModelWingedHussarBoots<LivingEntity> INSTANCE = new ModelWingedHussarBoots<LivingEntity>();

    public ModelWingedHussarBoots() {
        super(0, 0, 128, 128);
        textureWidth = 128;
        textureHeight = 128;

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightleg.setTextureOffset(112, 80).addBox(-1.98F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.265F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftleg.setTextureOffset(112, 64).addBox(-2.02F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.266F, false);

        this.bipedRightLeg.addChild(rightleg);
        this.bipedLeftLeg.addChild(leftleg);

    }

    @Override
    public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;
        super.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

    }

}

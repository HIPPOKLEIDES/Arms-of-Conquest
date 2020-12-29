package com.conquestreforged.arms.items.armor;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class GladiatorHelmetModel<T extends LivingEntity> extends BipedModel<T> {
	private ModelRenderer bone;

	public static final GladiatorHelmetModel<LivingEntity> INSTANCE = new GladiatorHelmetModel<LivingEntity>();

	public ModelRenderer head01;
	public ModelRenderer muzzle;
	public ModelRenderer lowerJaw01;
	public ModelRenderer lAnter01;
	public ModelRenderer rAnter01;
	public ModelRenderer lowerJaw02;
	public ModelRenderer lAnter02;
	public ModelRenderer lAnter03a;
	public ModelRenderer lAnter03b;
	public ModelRenderer lAnter03c;
	public ModelRenderer lAnter03d;
	public ModelRenderer lAnter04;
	public ModelRenderer lAnter05a1;
	public ModelRenderer lAnter06a;
	public ModelRenderer lAnter07a;
	public ModelRenderer lAnter05b;
	public ModelRenderer lAnter05a2;
	public ModelRenderer lAnter05a3;
	public ModelRenderer lAnter05a4;
	public ModelRenderer lAnter06b;
	public ModelRenderer lAnter06c;
	public ModelRenderer lAnter07b;
	public ModelRenderer lAnter07c;
	public ModelRenderer lAnter07d;
	public ModelRenderer lAnter07e;
	public ModelRenderer rAnter02;
	public ModelRenderer rAnter03a;
	public ModelRenderer rAnter03b;
	public ModelRenderer rAnter03c;
	public ModelRenderer rAnter03d;
	public ModelRenderer rAnter04;
	public ModelRenderer rAnter05a1;
	public ModelRenderer rAnter06a;
	public ModelRenderer rAnter07a;
	public ModelRenderer rAnter05b;
	public ModelRenderer rAnter05a2;
	public ModelRenderer rAnter05a3;
	public ModelRenderer rAnter05a4;
	public ModelRenderer rAnter06b;
	public ModelRenderer rAnter06c;
	public ModelRenderer rAnter07b;
	public ModelRenderer rAnter07c;
	public ModelRenderer rAnter07d;
	public ModelRenderer rAnter07e;

	public GladiatorHelmetModel() {
		super(0, 0, 128, 128);
		this.textureWidth = 128;
		this.textureHeight = 128;

		this.lAnter05a1 = new ModelRenderer(this, 60, 20);
		this.lAnter05a1.setRotationPoint(0.3F, -0.2F, 0.5F);
		this.lAnter05a1.addBox(-0.2F, -0.2F, -5.4F, 1, 1, 6, 0.0F);
		this.setRotateAngle(this.lAnter05a1, -0.27314402793711257F, -0.45378560551852565F, 0.0F);
		this.lAnter06b = new ModelRenderer(this, 60, 20);
		this.lAnter06b.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.lAnter06b.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(this.lAnter06b, 0.22759093446006054F, 0.0F, 0.0F);
		this.rAnter05b = new ModelRenderer(this, 60, 20);
		this.rAnter05b.mirror = true;
		this.rAnter05b.setRotationPoint(0.0F, 0.0F, -5.3F);
		this.rAnter05b.addBox(-0.5F, -0.5F, -5.6F, 1, 1, 6, 0.0F);
		this.setRotateAngle(this.rAnter05b, 0.18203784098300857F, -0.18203784098300857F, 0.0F);
		this.lAnter06a = new ModelRenderer(this, 60, 20);
		this.lAnter06a.setRotationPoint(-0.3F, 0.3F, 4.2F);
		this.lAnter06a.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(this.lAnter06a, -0.7740535232594852F, 0.0F, -1.1838568316277536F);
		this.rAnter03d = new ModelRenderer(this, 60, 20);
		this.rAnter03d.mirror = true;
		this.rAnter03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter03d.addBox(-0.8F, -0.8F, -6.0F, 1, 1, 5, 0.0F);
		this.lAnter01 = new ModelRenderer(this, 60, 20);
		this.lAnter01.setRotationPoint(2.4F, -2.5F, -7.6F);
		this.lAnter01.addBox(-1.5F, -1.5F, -6.5F, 3, 3, 7, 0.0F);
		this.setRotateAngle(this.lAnter01, -0.4363323129985824F, -0.45378560551852565F, 0.0F);
		this.rAnter06b = new ModelRenderer(this, 60, 20);
		this.rAnter06b.mirror = true;
		this.rAnter06b.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.rAnter06b.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(this.rAnter06b, 0.22759093446006054F, 0.0F, 0.0F);
		this.lAnter03b = new ModelRenderer(this, 60, 20);
		this.lAnter03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter03b.addBox(-0.8F, -0.2F, -6.0F, 1, 1, 5, 0.0F);
		this.rAnter05a1 = new ModelRenderer(this, 60, 20);
		this.rAnter05a1.mirror = true;
		this.rAnter05a1.setRotationPoint(-0.3F, -0.2F, 0.5F);
		this.rAnter05a1.addBox(-0.2F, -0.2F, -5.4F, 1, 1, 6, 0.0F);
		this.setRotateAngle(this.rAnter05a1, -0.27314402793711257F, 0.45378560551852565F, 0.0F);
		this.rAnter03c = new ModelRenderer(this, 60, 20);
		this.rAnter03c.mirror = true;
		this.rAnter03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter03c.addBox(-0.2F, -0.8F, -6.0F, 1, 1, 5, 0.0F);
		this.lowerJaw01 = new ModelRenderer(this, 109, 11);
		this.lowerJaw01.setRotationPoint(0.0F, 4.7F, -1.9F);
		this.lowerJaw01.addBox(-3.2F, 0.0F, -0.2F, 7, 7, 2, 0.0F);
		this.setRotateAngle(this.lowerJaw01, -0.045553093477052F, 0.0F, 0.0F);
		this.rAnter05a2 = new ModelRenderer(this, 60, 20);
		this.rAnter05a2.mirror = true;
		this.rAnter05a2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter05a2.addBox(-0.8F, -0.2F, -5.4F, 1, 1, 6, 0.0F);
		this.lAnter05b = new ModelRenderer(this, 60, 20);
		this.lAnter05b.setRotationPoint(0.0F, 0.0F, -5.3F);
		this.lAnter05b.addBox(-0.5F, -0.5F, -5.6F, 1, 1, 6, 0.0F);
		this.setRotateAngle(this.lAnter05b, 0.18203784098300857F, 0.18203784098300857F, 0.0F);
		this.lAnter06c = new ModelRenderer(this, 60, 20);
		this.lAnter06c.setRotationPoint(0.0F, 2.8F, 0.1F);
		this.lAnter06c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(this.lAnter06c, -0.4553564018453205F, 0.0F, 0.0F);
		this.lowerJaw02 = new ModelRenderer(this, 101, 11);
		this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lowerJaw02.addBox(-3.8F, 0.0F, -0.2F, 1, 7, 2, 0.0F);
		this.rAnter01 = new ModelRenderer(this, 60, 20);
		this.rAnter01.mirror = true;
		this.rAnter01.setRotationPoint(-2.4F, -2.5F, -7.6F);
		this.rAnter01.addBox(-1.5F, -1.5F, -6.5F, 3, 3, 7, 0.0F);
		this.setRotateAngle(this.rAnter01, -0.4363323129985824F, 0.45378560551852565F, 0.0F);
		this.lAnter07e = new ModelRenderer(this, 60, 20);
		this.lAnter07e.setRotationPoint(0.0F, 3.7F, 0.0F);
		this.lAnter07e.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(this.lAnter07e, -0.40980330836826856F, 0.0F, 0.0F);
		this.head01 = new ModelRenderer(this, 59, 0);
		this.head01.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head01.addBox(-5.0F, -4.8F, -8.8F, 10, 11, 9, 0.0F);
		this.setRotateAngle(this.head01, -1.5707963267948966F, 0.0F, 0.0F);
		this.rAnter07d = new ModelRenderer(this, 60, 20);
		this.rAnter07d.mirror = true;
		this.rAnter07d.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter07d.addBox(-0.8F, 0.0F, -0.2F, 1, 4, 1, 0.0F);
		this.rAnter07c = new ModelRenderer(this, 60, 20);
		this.rAnter07c.mirror = true;
		this.rAnter07c.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter07c.addBox(-0.2F, 0.0F, -0.2F, 1, 4, 1, 0.0F);
		this.lAnter03a = new ModelRenderer(this, 60, 20);
		this.lAnter03a.setRotationPoint(0.1F, 0.0F, -3.7F);
		this.lAnter03a.addBox(-0.2F, -0.2F, -6.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(this.lAnter03a, 0.0F, 0.091106186954104F, 0.0F);
		this.rAnter07a = new ModelRenderer(this, 60, 20);
		this.rAnter07a.mirror = true;
		this.rAnter07a.setRotationPoint(0.3F, 0.4F, 8.2F);
		this.rAnter07a.addBox(-0.2F, 0.0F, -0.8F, 1, 4, 1, 0.0F);
		this.lAnter05a3 = new ModelRenderer(this, 60, 20);
		this.lAnter05a3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter05a3.addBox(-0.2F, -0.8F, -5.4F, 1, 1, 6, 0.0F);
		this.lAnter07d = new ModelRenderer(this, 60, 20);
		this.lAnter07d.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter07d.addBox(-0.8F, 0.0F, -0.2F, 1, 4, 1, 0.0F);
		this.rAnter03a = new ModelRenderer(this, 60, 20);
		this.rAnter03a.mirror = true;
		this.rAnter03a.setRotationPoint(-0.1F, 0.0F, -3.7F);
		this.rAnter03a.addBox(-0.2F, -0.2F, -6.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(this.rAnter03a, 0.0F, -0.091106186954104F, 0.0F);
		this.rAnter04 = new ModelRenderer(this, 60, 20);
		this.rAnter04.mirror = true;
		this.rAnter04.setRotationPoint(0.0F, 0.0F, -5.7F);
		this.rAnter04.addBox(-0.5F, -0.5F, -4.6F, 1, 1, 5, 0.0F);
		this.setRotateAngle(this.rAnter04, 0.22759093446006054F, -0.18203784098300857F, 0.0F);
		this.muzzle = new ModelRenderer(this, 102, 0);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-4.0F, 4.5F, -6.5F, 8, 7, 4, 0.0F);
		this.setRotateAngle(this.muzzle, 0.136659280431156F, 0.0F, 0.0F);
		this.rAnter06c = new ModelRenderer(this, 60, 20);
		this.rAnter06c.mirror = true;
		this.rAnter06c.setRotationPoint(0.0F, 2.8F, 0.1F);
		this.rAnter06c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(this.rAnter06c, -0.4553564018453205F, 0.0F, 0.0F);
		this.rAnter05a4 = new ModelRenderer(this, 60, 20);
		this.rAnter05a4.mirror = true;
		this.rAnter05a4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter05a4.addBox(-0.8F, -0.8F, -5.4F, 1, 1, 6, 0.0F);
		this.lAnter05a4 = new ModelRenderer(this, 60, 20);
		this.lAnter05a4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter05a4.addBox(-0.8F, -0.8F, -5.4F, 1, 1, 6, 0.0F);
		this.rAnter05a3 = new ModelRenderer(this, 60, 20);
		this.rAnter05a3.mirror = true;
		this.rAnter05a3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter05a3.addBox(-0.2F, -0.8F, -5.4F, 1, 1, 6, 0.0F);
		this.lAnter07b = new ModelRenderer(this, 60, 20);
		this.lAnter07b.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter07b.addBox(-0.8F, 0.0F, -0.8F, 1, 4, 1, 0.0F);
		this.lAnter04 = new ModelRenderer(this, 60, 20);
		this.lAnter04.setRotationPoint(0.0F, 0.0F, -5.7F);
		this.lAnter04.addBox(-0.5F, -0.5F, -4.6F, 1, 1, 5, 0.0F);
		this.setRotateAngle(this.lAnter04, 0.22759093446006054F, 0.18203784098300857F, 0.0F);
		this.rAnter07b = new ModelRenderer(this, 60, 20);
		this.rAnter07b.mirror = true;
		this.rAnter07b.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter07b.addBox(-0.8F, 0.0F, -0.8F, 1, 4, 1, 0.0F);
		this.lAnter07c = new ModelRenderer(this, 60, 20);
		this.lAnter07c.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter07c.addBox(-0.2F, 0.0F, -0.2F, 1, 4, 1, 0.0F);
		this.lAnter07a = new ModelRenderer(this, 60, 20);
		this.lAnter07a.setRotationPoint(-0.3F, 0.4F, 8.2F);
		this.lAnter07a.addBox(-0.2F, 0.0F, -0.8F, 1, 4, 1, 0.0F);
		this.lAnter02 = new ModelRenderer(this, 60, 20);
		this.lAnter02.setRotationPoint(0.0F, 0.0F, -5.9F);
		this.lAnter02.addBox(-1.0F, -1.0F, -5.5F, 2, 2, 6, 0.0F);
		this.setRotateAngle(this.lAnter02, 0.0F, 0.091106186954104F, 0.0F);
		this.rAnter06a = new ModelRenderer(this, 60, 20);
		this.rAnter06a.mirror = true;
		this.rAnter06a.setRotationPoint(0.3F, 0.3F, 4.2F);
		this.rAnter06a.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(this.rAnter06a, -0.7740535232594852F, 0.0F, 1.1838568316277536F);
		this.rAnter07e = new ModelRenderer(this, 60, 20);
		this.rAnter07e.mirror = true;
		this.rAnter07e.setRotationPoint(0.0F, 3.7F, 0.0F);
		this.rAnter07e.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(this.rAnter07e, -0.40980330836826856F, 0.0F, 0.0F);
		this.lAnter03d = new ModelRenderer(this, 60, 20);
		this.lAnter03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter03d.addBox(-0.8F, -0.8F, -6.0F, 1, 1, 5, 0.0F);
		this.rAnter03b = new ModelRenderer(this, 60, 20);
		this.rAnter03b.mirror = true;
		this.rAnter03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rAnter03b.addBox(-0.8F, -0.2F, -6.0F, 1, 1, 5, 0.0F);
		this.rAnter02 = new ModelRenderer(this, 60, 20);
		this.rAnter02.mirror = true;
		this.rAnter02.setRotationPoint(0.0F, 0.0F, -5.9F);
		this.rAnter02.addBox(-1.0F, -1.0F, -5.5F, 2, 2, 6, 0.0F);
		this.setRotateAngle(this.rAnter02, 0.0F, -0.091106186954104F, 0.0F);
		this.lAnter03c = new ModelRenderer(this, 60, 20);
		this.lAnter03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter03c.addBox(-0.2F, -0.8F, -6.0F, 1, 1, 5, 0.0F);
		this.lAnter05a2 = new ModelRenderer(this, 60, 20);
		this.lAnter05a2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lAnter05a2.addBox(-0.8F, -0.2F, -5.4F, 1, 1, 6, 0.0F);
		this.lAnter03a.addChild(this.lAnter05a1);
		this.lAnter06a.addChild(this.lAnter06b);
		this.rAnter05a1.addChild(this.rAnter05b);
		this.lAnter03a.addChild(this.lAnter06a);
		this.rAnter03a.addChild(this.rAnter03d);
		this.head01.addChild(this.lAnter01);
		this.rAnter06a.addChild(this.rAnter06b);
		this.lAnter03a.addChild(this.lAnter03b);
		this.rAnter03a.addChild(this.rAnter05a1);
		this.rAnter03a.addChild(this.rAnter03c);
		this.head01.addChild(this.lowerJaw01);
		this.rAnter05a1.addChild(this.rAnter05a2);
		this.lAnter05a1.addChild(this.lAnter05b);
		this.lAnter06b.addChild(this.lAnter06c);
		this.lowerJaw01.addChild(this.lowerJaw02);
		this.head01.addChild(this.rAnter01);
		this.lAnter07a.addChild(this.lAnter07e);
		this.rAnter07a.addChild(this.rAnter07d);
		this.rAnter07a.addChild(this.rAnter07c);
		this.lAnter02.addChild(this.lAnter03a);
		this.rAnter03a.addChild(this.rAnter07a);
		this.lAnter05a1.addChild(this.lAnter05a3);
		this.lAnter07a.addChild(this.lAnter07d);
		this.rAnter02.addChild(this.rAnter03a);
		this.rAnter03a.addChild(this.rAnter04);
		this.head01.addChild(this.muzzle);
		this.rAnter06b.addChild(this.rAnter06c);
		this.rAnter05a1.addChild(this.rAnter05a4);
		this.lAnter05a1.addChild(this.lAnter05a4);
		this.rAnter05a1.addChild(this.rAnter05a3);
		this.lAnter07a.addChild(this.lAnter07b);
		this.lAnter03a.addChild(this.lAnter04);
		this.rAnter07a.addChild(this.rAnter07b);
		this.lAnter07a.addChild(this.lAnter07c);
		this.lAnter03a.addChild(this.lAnter07a);
		this.lAnter01.addChild(this.lAnter02);
		this.rAnter03a.addChild(this.rAnter06a);
		this.rAnter07a.addChild(this.rAnter07e);
		this.lAnter03a.addChild(this.lAnter03d);
		this.rAnter03a.addChild(this.rAnter03b);
		this.rAnter01.addChild(this.rAnter02);
		this.lAnter03a.addChild(this.lAnter03c);
		this.lAnter05a1.addChild(this.lAnter05a2);

		this.bipedHead.addChild(this.head01);
	}

	@Override
	public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
		this.bipedHead.showModel = true;
		super.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
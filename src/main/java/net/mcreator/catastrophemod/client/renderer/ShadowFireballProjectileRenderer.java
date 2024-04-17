package net.mcreator.catastrophemod.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.catastrophemod.entity.ShadowFireballProjectileEntity;
import net.mcreator.catastrophemod.client.model.Modelshadowfire_ball;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ShadowFireballProjectileRenderer extends EntityRenderer<ShadowFireballProjectileEntity> {
	private static final ResourceLocation texture = new ResourceLocation("catastrophe_mod:textures/entities/shadowfire_ball.png");
	private final Modelshadowfire_ball model;

	public ShadowFireballProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelshadowfire_ball(context.bakeLayer(Modelshadowfire_ball.LAYER_LOCATION));
	}

	@Override
	public void render(ShadowFireballProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(ShadowFireballProjectileEntity entity) {
		return texture;
	}
}

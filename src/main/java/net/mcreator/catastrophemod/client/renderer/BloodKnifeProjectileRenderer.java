package net.mcreator.catastrophemod.client.renderer;

import com.mojang.math.Axis;

public class BloodKnifeProjectileRenderer extends EntityRenderer<BloodKnifeProjectileEntity> {

	private static final ResourceLocation texture = new ResourceLocation("catastrophe_mod:textures/entities/blood_knife.png");

	private final Modelblood_knife model;

	public BloodKnifeProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelblood_knife(context.bakeLayer(Modelblood_knife.LAYER_LOCATION));
	}

	@Override
	public void render(BloodKnifeProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(BloodKnifeProjectileEntity entity) {
		return texture;
	}

}

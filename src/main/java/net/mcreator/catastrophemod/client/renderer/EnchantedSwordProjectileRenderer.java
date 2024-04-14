package net.mcreator.catastrophemod.client.renderer;

import com.mojang.math.Axis;

public class EnchantedSwordProjectileRenderer extends EntityRenderer<EnchantedSwordProjectileEntity> {

	private static final ResourceLocation texture = new ResourceLocation("catastrophe_mod:textures/entities/enchanted_sword.png");

	private final Modelenchanted_sword model;

	public EnchantedSwordProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelenchanted_sword(context.bakeLayer(Modelenchanted_sword.LAYER_LOCATION));
	}

	@Override
	public void render(EnchantedSwordProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(EnchantedSwordProjectileEntity entity) {
		return texture;
	}

}

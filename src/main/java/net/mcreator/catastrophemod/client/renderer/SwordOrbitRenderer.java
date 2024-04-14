
package net.mcreator.catastrophemod.client.renderer;

public class SwordOrbitRenderer extends GeoEntityRenderer<SwordOrbitEntity> {
	public SwordOrbitRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SwordOrbitModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(SwordOrbitEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SwordOrbitEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(SwordOrbitEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
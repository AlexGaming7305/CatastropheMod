
package net.mcreator.catastrophemod.client.renderer;

public class AtlanticSeaNettleRenderer extends GeoEntityRenderer<AtlanticSeaNettleEntity> {
	public AtlanticSeaNettleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AtlanticSeaNettleModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new AtlanticSeaNettleLayer(this));
	}

	@Override
	public RenderType getRenderType(AtlanticSeaNettleEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AtlanticSeaNettleEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(AtlanticSeaNettleEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
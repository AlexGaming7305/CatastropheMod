
package net.mcreator.catastrophemod.client.renderer;

public class EarthboundFistRenderer extends GeoEntityRenderer<EarthboundFistEntity> {
	public EarthboundFistRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new EarthboundFistModel());
		this.shadowRadius = 0.4f;
	}

	@Override
	public RenderType getRenderType(EarthboundFistEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, EarthboundFistEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
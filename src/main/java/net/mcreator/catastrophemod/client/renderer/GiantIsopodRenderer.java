
package net.mcreator.catastrophemod.client.renderer;

public class GiantIsopodRenderer extends GeoEntityRenderer<GiantIsopodEntity> {
	public GiantIsopodRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GiantIsopodModel());
		this.shadowRadius = 0.6f;
	}

	@Override
	public RenderType getRenderType(GiantIsopodEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GiantIsopodEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}

package net.mcreator.catastrophemod.client.renderer;

public class SilkMothRenderer extends GeoEntityRenderer<SilkMothEntity> {
	public SilkMothRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SilkMothModel());
		this.shadowRadius = 0.3f;
	}

	@Override
	public RenderType getRenderType(SilkMothEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SilkMothEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
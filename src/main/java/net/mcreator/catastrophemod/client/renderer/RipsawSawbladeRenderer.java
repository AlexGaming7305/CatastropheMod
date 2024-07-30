
package net.mcreator.catastrophemod.client.renderer;

public class RipsawSawbladeRenderer extends GeoEntityRenderer<RipsawSawbladeEntity> {
	public RipsawSawbladeRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new RipsawSawbladeModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new RipsawSawbladeLayer(this));
	}

	@Override
	public RenderType getRenderType(RipsawSawbladeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, RipsawSawbladeEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
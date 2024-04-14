
package net.mcreator.catastrophemod.client.renderer;

public class HermitCrabMinionRenderer extends GeoEntityRenderer<HermitCrabMinionEntity> {
	public HermitCrabMinionRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new HermitCrabMinionModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(HermitCrabMinionEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, HermitCrabMinionEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
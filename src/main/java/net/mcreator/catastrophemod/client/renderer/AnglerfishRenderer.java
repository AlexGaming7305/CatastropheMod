
package net.mcreator.catastrophemod.client.renderer;

public class AnglerfishRenderer extends GeoEntityRenderer<AnglerfishEntity> {
	public AnglerfishRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AnglerfishModel());
		this.shadowRadius = 0.2f;
		this.addRenderLayer(new AnglerfishLayer(this));
	}

	@Override
	public RenderType getRenderType(AnglerfishEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AnglerfishEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
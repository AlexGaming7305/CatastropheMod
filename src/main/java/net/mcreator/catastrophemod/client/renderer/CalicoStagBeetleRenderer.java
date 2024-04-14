
package net.mcreator.catastrophemod.client.renderer;

public class CalicoStagBeetleRenderer extends GeoEntityRenderer<CalicoStagBeetleEntity> {
	public CalicoStagBeetleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CalicoStagBeetleModel());
		this.shadowRadius = 0.8f;
	}

	@Override
	public RenderType getRenderType(CalicoStagBeetleEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CalicoStagBeetleEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
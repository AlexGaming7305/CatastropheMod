
package net.mcreator.catastrophemod.client.renderer;

public class SporeZombieRenderer extends GeoEntityRenderer<SporeZombieEntity> {
	public SporeZombieRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SporeZombieModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(SporeZombieEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SporeZombieEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
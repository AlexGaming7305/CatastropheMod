
package net.mcreator.catastrophemod.client.renderer;

public class ShootingStarRenderer extends GeoEntityRenderer<ShootingStarEntity> {
	public ShootingStarRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ShootingStarModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ShootingStarLayer(this));
	}

	@Override
	public RenderType getRenderType(ShootingStarEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ShootingStarEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
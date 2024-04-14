
package net.mcreator.catastrophemod.client.renderer;

public class CharredSkeletonGuardRenderer extends GeoEntityRenderer<CharredSkeletonGuardEntity> {
	public CharredSkeletonGuardRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CharredSkeletonGuardModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(CharredSkeletonGuardEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CharredSkeletonGuardEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
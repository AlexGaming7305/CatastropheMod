
package net.mcreator.catastrophemod.client.renderer;

public class NightfallsDemiseProjectileRenderer extends GeoEntityRenderer<NightfallsDemiseProjectileEntity> {
	public NightfallsDemiseProjectileRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new NightfallsDemiseProjectileModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new NightfallsDemiseProjectileLayer(this));
	}

	@Override
	public RenderType getRenderType(NightfallsDemiseProjectileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, NightfallsDemiseProjectileEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
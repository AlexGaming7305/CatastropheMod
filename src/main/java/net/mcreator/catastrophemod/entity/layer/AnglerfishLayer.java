package net.mcreator.catastrophemod.entity.layer;

public class AnglerfishLayer extends GeoRenderLayer<AnglerfishEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("catastrophe_mod", "textures/entities/anglerfish_glow.png");

	public AnglerfishLayer(GeoRenderer<AnglerfishEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, AnglerfishEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
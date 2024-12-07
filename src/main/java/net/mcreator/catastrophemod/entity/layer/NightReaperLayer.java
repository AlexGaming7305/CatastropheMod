package net.mcreator.catastrophemod.entity.layer;

public class NightReaperLayer extends GeoRenderLayer<NightReaperEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("catastrophe_mod", "textures/entities/night_reaper_glow.png");

	public NightReaperLayer(GeoRenderer<NightReaperEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, NightReaperEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
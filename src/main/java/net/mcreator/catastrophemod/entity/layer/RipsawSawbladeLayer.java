package net.mcreator.catastrophemod.entity.layer;

public class RipsawSawbladeLayer extends GeoRenderLayer<RipsawSawbladeEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("catastrophe_mod", "textures/entities/saw_blade_texture_glow.png");

	public RipsawSawbladeLayer(GeoRenderer<RipsawSawbladeEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, RipsawSawbladeEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
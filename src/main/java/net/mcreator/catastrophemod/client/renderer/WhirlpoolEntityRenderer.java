
package net.mcreator.catastrophemod.client.renderer;

public class WhirlpoolEntityRenderer extends HumanoidMobRenderer<WhirlpoolEntityEntity, HumanoidModel<WhirlpoolEntityEntity>> {

	public WhirlpoolEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(WhirlpoolEntityEntity entity) {
		return new ResourceLocation("catastrophe_mod:textures/entities/de53bebf305511ede59c1c41302a39811a24f468.png");
	}

}

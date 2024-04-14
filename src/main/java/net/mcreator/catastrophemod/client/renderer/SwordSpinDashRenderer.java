
package net.mcreator.catastrophemod.client.renderer;

public class SwordSpinDashRenderer extends MobRenderer<SwordSpinDashEntity, Modelfirefly<SwordSpinDashEntity>> {

	public SwordSpinDashRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirefly(context.bakeLayer(Modelfirefly.LAYER_LOCATION)), 0f);

	}

	@Override
	public ResourceLocation getTextureLocation(SwordSpinDashEntity entity) {
		return new ResourceLocation("catastrophe_mod:textures/entities/de53bebf305511ede59c1c41302a39811a24f468.png");
	}

}

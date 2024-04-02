
package net.mcreator.catastrophemod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.catastrophemod.entity.WraithDashEntity;
import net.mcreator.catastrophemod.client.model.Modelfirefly;

public class WraithDashRenderer extends MobRenderer<WraithDashEntity, Modelfirefly<WraithDashEntity>> {
	public WraithDashRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirefly(context.bakeLayer(Modelfirefly.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(WraithDashEntity entity) {
		return new ResourceLocation("catastrophe_mod:textures/entities/de53bebf305511ede59c1c41302a39811a24f468.png");
	}
}


package net.mcreator.catastrophemod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.catastrophemod.entity.TiaDashEntity;
import net.mcreator.catastrophemod.client.model.Modelfirefly;

public class TiaDashRenderer extends MobRenderer<TiaDashEntity, Modelfirefly<TiaDashEntity>> {
	public TiaDashRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfirefly(context.bakeLayer(Modelfirefly.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(TiaDashEntity entity) {
		return new ResourceLocation("catastrophe_mod:textures/entities/de53bebf305511ede59c1c41302a39811a24f468.png");
	}
}

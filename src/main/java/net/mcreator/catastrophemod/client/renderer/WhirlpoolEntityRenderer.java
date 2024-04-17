
package net.mcreator.catastrophemod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.catastrophemod.entity.WhirlpoolEntityEntity;

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

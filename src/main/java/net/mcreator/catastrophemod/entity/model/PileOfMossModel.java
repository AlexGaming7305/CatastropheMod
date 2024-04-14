package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class PileOfMossModel extends GeoModel<PileOfMossEntity> {
	@Override
	public ResourceLocation getAnimationResource(PileOfMossEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/pile_of_moss.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PileOfMossEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/pile_of_moss.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PileOfMossEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
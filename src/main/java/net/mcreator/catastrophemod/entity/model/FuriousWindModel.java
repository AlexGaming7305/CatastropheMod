package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class FuriousWindModel extends GeoModel<FuriousWindEntity> {
	@Override
	public ResourceLocation getAnimationResource(FuriousWindEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/furious_wind.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FuriousWindEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/furious_wind.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FuriousWindEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
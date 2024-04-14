package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class EarthShockwaveModel extends GeoModel<EarthShockwaveEntity> {
	@Override
	public ResourceLocation getAnimationResource(EarthShockwaveEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/earth_shockwave.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EarthShockwaveEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/earth_shockwave.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EarthShockwaveEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class ShootingStarModel extends GeoModel<ShootingStarEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShootingStarEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/shooting_star.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShootingStarEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/shooting_star.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShootingStarEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
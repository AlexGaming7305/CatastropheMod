package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class SwordOrbitModel extends GeoModel<SwordOrbitEntity> {
	@Override
	public ResourceLocation getAnimationResource(SwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/swordspin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/swordspin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
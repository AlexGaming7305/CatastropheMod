package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class SwordspinModel extends GeoModel<SwordspinEntity> {
	@Override
	public ResourceLocation getAnimationResource(SwordspinEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/swordspin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SwordspinEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/swordspin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SwordspinEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
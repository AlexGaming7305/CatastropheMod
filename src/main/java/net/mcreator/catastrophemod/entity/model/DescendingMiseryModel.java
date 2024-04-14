package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class DescendingMiseryModel extends GeoModel<DescendingMiseryEntity> {
	@Override
	public ResourceLocation getAnimationResource(DescendingMiseryEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/descending_misery.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DescendingMiseryEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/descending_misery.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DescendingMiseryEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
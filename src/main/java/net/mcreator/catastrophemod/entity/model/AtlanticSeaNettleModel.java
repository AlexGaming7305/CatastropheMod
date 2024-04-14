package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class AtlanticSeaNettleModel extends GeoModel<AtlanticSeaNettleEntity> {
	@Override
	public ResourceLocation getAnimationResource(AtlanticSeaNettleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/atlantic_sea_nettle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AtlanticSeaNettleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/atlantic_sea_nettle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AtlanticSeaNettleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
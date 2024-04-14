package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class LightningBladeModel extends GeoModel<LightningBladeEntity> {
	@Override
	public ResourceLocation getAnimationResource(LightningBladeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/lightning_blade.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LightningBladeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/lightning_blade.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LightningBladeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class AcidTarantulaMinionModel extends GeoModel<AcidTarantulaMinionEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcidTarantulaMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/acid_tarantula.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcidTarantulaMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/acid_tarantula.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcidTarantulaMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
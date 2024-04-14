package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class ShadowflameSpearsModel extends GeoModel<ShadowflameSpearsEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShadowflameSpearsEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/shadowflame_spears.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShadowflameSpearsEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/shadowflame_spears.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShadowflameSpearsEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
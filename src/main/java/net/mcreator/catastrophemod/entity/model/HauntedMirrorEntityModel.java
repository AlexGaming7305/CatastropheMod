package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class HauntedMirrorEntityModel extends GeoModel<HauntedMirrorEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(HauntedMirrorEntityEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/haunted_mirror.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HauntedMirrorEntityEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/haunted_mirror.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HauntedMirrorEntityEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
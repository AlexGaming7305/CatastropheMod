package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class DiamondDetonationBombModel extends GeoModel<DiamondDetonationBombEntity> {
	@Override
	public ResourceLocation getAnimationResource(DiamondDetonationBombEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/diamond_detonation_bomb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DiamondDetonationBombEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/diamond_detonation_bomb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DiamondDetonationBombEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
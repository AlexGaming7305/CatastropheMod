package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.ThornTentacleEntity;

public class ThornTentacleModel extends GeoModel<ThornTentacleEntity> {
	@Override
	public ResourceLocation getAnimationResource(ThornTentacleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/thorn_tenticle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ThornTentacleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/thorn_tenticle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ThornTentacleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.OceanicSplashEntity;

public class OceanicSplashModel extends GeoModel<OceanicSplashEntity> {
	@Override
	public ResourceLocation getAnimationResource(OceanicSplashEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/oceanic_splash.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OceanicSplashEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/oceanic_splash.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OceanicSplashEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

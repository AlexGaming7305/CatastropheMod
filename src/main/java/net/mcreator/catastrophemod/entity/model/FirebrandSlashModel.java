package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.FirebrandSlashEntity;

public class FirebrandSlashModel extends GeoModel<FirebrandSlashEntity> {
	@Override
	public ResourceLocation getAnimationResource(FirebrandSlashEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/firebrand_slash.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FirebrandSlashEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/firebrand_slash.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FirebrandSlashEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

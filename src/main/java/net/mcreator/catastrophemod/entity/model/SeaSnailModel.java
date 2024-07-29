package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.SeaSnailEntity;

public class SeaSnailModel extends GeoModel<SeaSnailEntity> {
	@Override
	public ResourceLocation getAnimationResource(SeaSnailEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/sea_snail.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SeaSnailEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/sea_snail.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SeaSnailEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

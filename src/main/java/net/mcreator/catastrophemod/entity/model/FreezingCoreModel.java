package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.FreezingCoreEntity;

public class FreezingCoreModel extends GeoModel<FreezingCoreEntity> {
	@Override
	public ResourceLocation getAnimationResource(FreezingCoreEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/freezing_core.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FreezingCoreEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/freezing_core.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FreezingCoreEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.ShadeEntity;

public class ShadeModel extends GeoModel<ShadeEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShadeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/shade.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShadeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/shade.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShadeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

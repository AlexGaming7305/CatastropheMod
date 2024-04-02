package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.AnglerfishEntity;

public class AnglerfishModel extends GeoModel<AnglerfishEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnglerfishEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/anglerfish.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnglerfishEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/anglerfish.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnglerfishEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

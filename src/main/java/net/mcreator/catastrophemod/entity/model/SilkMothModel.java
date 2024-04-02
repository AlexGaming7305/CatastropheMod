package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.SilkMothEntity;

public class SilkMothModel extends GeoModel<SilkMothEntity> {
	@Override
	public ResourceLocation getAnimationResource(SilkMothEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/silk_moth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SilkMothEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/silk_moth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SilkMothEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

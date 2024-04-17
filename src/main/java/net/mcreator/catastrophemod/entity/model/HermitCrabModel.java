package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.HermitCrabEntity;

public class HermitCrabModel extends GeoModel<HermitCrabEntity> {
	@Override
	public ResourceLocation getAnimationResource(HermitCrabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/hermit_crab.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HermitCrabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/hermit_crab.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HermitCrabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

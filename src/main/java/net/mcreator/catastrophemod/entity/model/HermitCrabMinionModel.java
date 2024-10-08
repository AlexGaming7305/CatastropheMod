package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.HermitCrabMinionEntity;

public class HermitCrabMinionModel extends GeoModel<HermitCrabMinionEntity> {
	@Override
	public ResourceLocation getAnimationResource(HermitCrabMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/hermit_crab.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HermitCrabMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/hermit_crab.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HermitCrabMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

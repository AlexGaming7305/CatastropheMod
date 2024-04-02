package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.EarthboundFistEntity;

public class EarthboundFistModel extends GeoModel<EarthboundFistEntity> {
	@Override
	public ResourceLocation getAnimationResource(EarthboundFistEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/earthbound_fist.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EarthboundFistEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/earthbound_fist.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EarthboundFistEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

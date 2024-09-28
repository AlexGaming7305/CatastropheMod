package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.FriendlySwordOrbitEntity;

public class FriendlySwordOrbitModel extends GeoModel<FriendlySwordOrbitEntity> {
	@Override
	public ResourceLocation getAnimationResource(FriendlySwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/friendly_sword_orbit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FriendlySwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/friendly_sword_orbit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FriendlySwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

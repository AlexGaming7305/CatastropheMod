package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.EnchantedSwordOrbitEntity;

public class EnchantedSwordOrbitModel extends GeoModel<EnchantedSwordOrbitEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnchantedSwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/enchanted_sword_orbit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnchantedSwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/enchanted_sword_orbit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnchantedSwordOrbitEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
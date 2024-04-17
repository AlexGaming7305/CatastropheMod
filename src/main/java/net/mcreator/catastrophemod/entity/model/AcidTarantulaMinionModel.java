package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.AcidTarantulaMinionEntity;

public class AcidTarantulaMinionModel extends GeoModel<AcidTarantulaMinionEntity> {
	@Override
	public ResourceLocation getAnimationResource(AcidTarantulaMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/acid_tarantula.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AcidTarantulaMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/acid_tarantula.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AcidTarantulaMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

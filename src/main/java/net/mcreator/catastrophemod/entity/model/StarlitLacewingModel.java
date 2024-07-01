package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.StarlitLacewingEntity;

public class StarlitLacewingModel extends GeoModel<StarlitLacewingEntity> {
	@Override
	public ResourceLocation getAnimationResource(StarlitLacewingEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/starlit_lacewing.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StarlitLacewingEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/starlit_lacewing.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StarlitLacewingEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

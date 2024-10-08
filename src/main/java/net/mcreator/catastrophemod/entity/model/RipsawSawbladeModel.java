package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.RipsawSawbladeEntity;

public class RipsawSawbladeModel extends GeoModel<RipsawSawbladeEntity> {
	@Override
	public ResourceLocation getAnimationResource(RipsawSawbladeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/ripsaw_sawblade.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RipsawSawbladeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/ripsaw_sawblade.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RipsawSawbladeEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

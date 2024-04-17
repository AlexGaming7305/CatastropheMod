package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.SporeZombieEntity;

public class SporeZombieModel extends GeoModel<SporeZombieEntity> {
	@Override
	public ResourceLocation getAnimationResource(SporeZombieEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/spore_zombie.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SporeZombieEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/spore_zombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SporeZombieEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

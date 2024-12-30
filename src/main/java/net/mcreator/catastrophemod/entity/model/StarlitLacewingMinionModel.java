package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.StarlitLacewingMinionEntity;

public class StarlitLacewingMinionModel extends GeoModel<StarlitLacewingMinionEntity> {
	@Override
	public ResourceLocation getAnimationResource(StarlitLacewingMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/starlit_lacewing.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StarlitLacewingMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/starlit_lacewing.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StarlitLacewingMinionEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

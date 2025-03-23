package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.TideSlashProjectileEntity;

public class TideSlashProjectileModel extends GeoModel<TideSlashProjectileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TideSlashProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/tide_slash_projectile.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TideSlashProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/tide_slash_projectile.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TideSlashProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

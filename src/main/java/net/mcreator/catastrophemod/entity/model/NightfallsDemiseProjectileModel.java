package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.NightfallsDemiseProjectileEntity;

public class NightfallsDemiseProjectileModel extends GeoModel<NightfallsDemiseProjectileEntity> {
	@Override
	public ResourceLocation getAnimationResource(NightfallsDemiseProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/nightfalls_demise.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NightfallsDemiseProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/nightfalls_demise.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NightfallsDemiseProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

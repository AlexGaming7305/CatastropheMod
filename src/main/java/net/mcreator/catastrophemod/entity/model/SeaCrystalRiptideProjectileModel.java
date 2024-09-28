package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.SeaCrystalRiptideProjectileEntity;

public class SeaCrystalRiptideProjectileModel extends GeoModel<SeaCrystalRiptideProjectileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SeaCrystalRiptideProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/sea_crystal_riptide.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SeaCrystalRiptideProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/sea_crystal_riptide.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SeaCrystalRiptideProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

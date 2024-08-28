package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.ElectrifiedSwordProjectileEntity;

public class ElectrifiedSwordProjectileModel extends GeoModel<ElectrifiedSwordProjectileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ElectrifiedSwordProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/electrified_sword_projectile.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElectrifiedSwordProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/electrified_sword_projectile.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElectrifiedSwordProjectileEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

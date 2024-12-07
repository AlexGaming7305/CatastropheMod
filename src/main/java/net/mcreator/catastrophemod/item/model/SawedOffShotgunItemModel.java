package net.mcreator.catastrophemod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.item.SawedOffShotgunItem;

public class SawedOffShotgunItemModel extends GeoModel<SawedOffShotgunItem> {
	@Override
	public ResourceLocation getAnimationResource(SawedOffShotgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/sawed_off_shotgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SawedOffShotgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/sawed_off_shotgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SawedOffShotgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/sawed_off_shotgun.png");
	}
}

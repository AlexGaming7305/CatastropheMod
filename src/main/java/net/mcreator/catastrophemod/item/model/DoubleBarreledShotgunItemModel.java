package net.mcreator.catastrophemod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.item.DoubleBarreledShotgunItem;

public class DoubleBarreledShotgunItemModel extends GeoModel<DoubleBarreledShotgunItem> {
	@Override
	public ResourceLocation getAnimationResource(DoubleBarreledShotgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/double_barreled_shotgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DoubleBarreledShotgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/double_barreled_shotgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DoubleBarreledShotgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/double_barreled_shotgun.png");
	}
}

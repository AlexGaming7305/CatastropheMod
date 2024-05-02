package net.mcreator.catastrophemod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.item.RustgunItem;

public class RustgunItemModel extends GeoModel<RustgunItem> {
	@Override
	public ResourceLocation getAnimationResource(RustgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/rustgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RustgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/rustgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RustgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/rustgun_texture.png");
	}
}

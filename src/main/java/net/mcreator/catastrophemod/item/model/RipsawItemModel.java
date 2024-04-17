package net.mcreator.catastrophemod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.item.RipsawItem;

public class RipsawItemModel extends GeoModel<RipsawItem> {
	@Override
	public ResourceLocation getAnimationResource(RipsawItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/ripsaw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RipsawItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/ripsaw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RipsawItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/ripsaw_texture.png");
	}
}

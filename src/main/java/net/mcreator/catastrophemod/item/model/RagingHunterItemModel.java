package net.mcreator.catastrophemod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.item.RagingHunterItem;

public class RagingHunterItemModel extends GeoModel<RagingHunterItem> {
	@Override
	public ResourceLocation getAnimationResource(RagingHunterItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/raging_hunter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RagingHunterItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/raging_hunter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RagingHunterItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/raging_hunter.png");
	}
}

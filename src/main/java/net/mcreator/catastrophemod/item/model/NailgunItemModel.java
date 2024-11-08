package net.mcreator.catastrophemod.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.item.NailgunItem;

public class NailgunItemModel extends GeoModel<NailgunItem> {
	@Override
	public ResourceLocation getAnimationResource(NailgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/nailgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NailgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/nailgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NailgunItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/nailgun_texture.png");
	}
}

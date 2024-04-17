package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.NatureBlessedSpiritEntity;

public class NatureBlessedSpiritModel extends GeoModel<NatureBlessedSpiritEntity> {
	@Override
	public ResourceLocation getAnimationResource(NatureBlessedSpiritEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/nature_blessed_spirit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NatureBlessedSpiritEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/nature_blessed_spirit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NatureBlessedSpiritEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}

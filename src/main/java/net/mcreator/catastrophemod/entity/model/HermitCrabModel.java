package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.HermitCrabEntity;

public class HermitCrabModel extends GeoModel<HermitCrabEntity> {
	@Override
	public ResourceLocation getAnimationResource(HermitCrabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/hermit_crab.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HermitCrabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/hermit_crab.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HermitCrabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(HermitCrabEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("hermit_crab");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}

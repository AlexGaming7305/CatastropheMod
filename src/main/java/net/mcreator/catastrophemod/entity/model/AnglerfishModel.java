package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class AnglerfishModel extends GeoModel<AnglerfishEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnglerfishEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/anglerfish.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnglerfishEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/anglerfish.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnglerfishEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(AnglerfishEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("anglerfish");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
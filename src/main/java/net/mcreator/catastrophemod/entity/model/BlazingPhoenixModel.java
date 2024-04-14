package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class BlazingPhoenixModel extends GeoModel<BlazingPhoenixEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlazingPhoenixEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/blazing_phoenix.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlazingPhoenixEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/blazing_phoenix.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlazingPhoenixEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BlazingPhoenixEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class NettleModel extends GeoModel<NettleEntity> {
	@Override
	public ResourceLocation getAnimationResource(NettleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/nettle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NettleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/nettle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NettleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(NettleEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
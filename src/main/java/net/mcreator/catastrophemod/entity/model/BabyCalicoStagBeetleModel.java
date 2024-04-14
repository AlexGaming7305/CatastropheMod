package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class BabyCalicoStagBeetleModel extends GeoModel<BabyCalicoStagBeetleEntity> {
	@Override
	public ResourceLocation getAnimationResource(BabyCalicoStagBeetleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/baby_calico_stag_beetle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BabyCalicoStagBeetleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/baby_calico_stag_beetle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BabyCalicoStagBeetleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BabyCalicoStagBeetleEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
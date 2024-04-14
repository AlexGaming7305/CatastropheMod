package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class CalicoStagBeetleModel extends GeoModel<CalicoStagBeetleEntity> {
	@Override
	public ResourceLocation getAnimationResource(CalicoStagBeetleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/calico_stag_beetle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CalicoStagBeetleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/calico_stag_beetle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CalicoStagBeetleEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(CalicoStagBeetleEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
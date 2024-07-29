package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class GiantIsopodModel extends GeoModel<GiantIsopodEntity> {
	@Override
	public ResourceLocation getAnimationResource(GiantIsopodEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/giant_isopod.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GiantIsopodEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/giant_isopod.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GiantIsopodEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(GiantIsopodEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("giant_isopod");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class CrystalSpearStabModel extends GeoModel<CrystalSpearStabEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrystalSpearStabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/amethyst_spear_stab.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrystalSpearStabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/amethyst_spear_stab.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrystalSpearStabEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(CrystalSpearStabEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("amethyst_spear_stab");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
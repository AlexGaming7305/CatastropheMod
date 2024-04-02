package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.EarthboundWraithEntity;

public class EarthboundWraithModel extends GeoModel<EarthboundWraithEntity> {
	@Override
	public ResourceLocation getAnimationResource(EarthboundWraithEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/earthbound_wraith.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EarthboundWraithEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/earthbound_wraith.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EarthboundWraithEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(EarthboundWraithEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}

package net.mcreator.catastrophemod.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.entity.MineralWraithEntity;

public class MineralWraithModel extends GeoModel<MineralWraithEntity> {
	@Override
	public ResourceLocation getAnimationResource(MineralWraithEntity entity) {
		return new ResourceLocation("catastrophe_mod", "animations/mineral_wraith.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MineralWraithEntity entity) {
		return new ResourceLocation("catastrophe_mod", "geo/mineral_wraith.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MineralWraithEntity entity) {
		return new ResourceLocation("catastrophe_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MineralWraithEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.SilkMothEntity;

public class SilkMothOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("sleeping") == false) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FLYING_SPEED).setBaseValue(0.5);
			if (entity.getPersistentData().getBoolean("mulberry_silk_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("mulberry_silk_moth");
			} else if (entity.getPersistentData().getBoolean("luna_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("luna_moth");
			} else if (entity.getPersistentData().getBoolean("cecropia_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("cecropia_moth");
			} else if (entity.getPersistentData().getBoolean("polyphemus_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("polyphemus_moth");
			} else if (entity.getPersistentData().getBoolean("comet_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("comet_moth");
			} else if (entity.getPersistentData().getBoolean("rosy_maple_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("rosy_maple_moth");
			}
			if (entity instanceof SilkMothEntity) {
				((SilkMothEntity) entity).setAnimation("empty");
			}
		} else if (entity.getPersistentData().getBoolean("sleeping") == true) {
			if (entity instanceof SilkMothEntity) {
				((SilkMothEntity) entity).setAnimation("animation.silk_moth.rest");
			}
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FLYING_SPEED).setBaseValue(0);
			if (entity.getPersistentData().getBoolean("mulberry_silk_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("mulberry_silk_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("luna_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("luna_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("cecropia_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("cecropia_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("polyphemus_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("polyphemus_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("comet_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("comet_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("rosy_maple_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("rosy_maple_moth_rest");
			}
		}
		if (world instanceof Level _lvl30 && _lvl30.isDay() && entity.onGround()) {
			entity.getPersistentData().putBoolean("sleeping", true);
		} else {
			entity.getPersistentData().putBoolean("sleeping", false);
		}
		if (world instanceof Level _lvl34 && _lvl34.isDay()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 0.01), (entity.getDeltaMovement().z())));
		}
		if (entity.getY() >= world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) + 8) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 0.02), (entity.getDeltaMovement().z())));
		}
	}
}

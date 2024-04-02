package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.SilkMothEntity;

public class SilkMothOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double spawn = 0;
		double yaw = 0;
		double pitch = 0;
		boolean nospinning = false;
		if (entity.getPersistentData().getBoolean("sleeping") == false) {
			if (entity.getPersistentData().getBoolean("cecropia_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("cecropia_moth");
			} else if (entity.getPersistentData().getBoolean("luna_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("luna_moth");
			} else if (entity.getPersistentData().getBoolean("mulberry_silk_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("mulberry_silk_moth");
			} else if (entity.getPersistentData().getBoolean("polyphemus_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("polyphemus_moth");
			} else if (entity.getPersistentData().getBoolean("comet_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("comet_moth");
			}
		}
		if (world instanceof Level _lvl11 && _lvl11.isDay() && entity.onGround()) {
			entity.getPersistentData().putBoolean("sleeping", true);
		} else {
			entity.getPersistentData().putBoolean("sleeping", false);
		}
		if (entity.getPersistentData().getBoolean("sleeping") == true) {
			if (entity instanceof SilkMothEntity) {
				((SilkMothEntity) entity).setAnimation("animation.silk_moth.rest");
			}
			if (entity.getPersistentData().getBoolean("cecropia_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("cecropia_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("luna_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("luna_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("mulberry_silk_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("mulberry_silk_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("polyphemus_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("polyphemus_moth_rest");
			}
			if (entity.getPersistentData().getBoolean("comet_moth") == true) {
				if (entity instanceof SilkMothEntity animatable)
					animatable.setTexture("comet_moth_rest");
			}
		} else {
			if (entity instanceof SilkMothEntity) {
				((SilkMothEntity) entity).setAnimation("empty");
			}
		}
		if (world instanceof Level _lvl28 && _lvl28.isDay()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.08), (entity.getDeltaMovement().z())));
		}
	}
}

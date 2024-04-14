package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SilkMothOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("sleeping") == false) {
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
		}
		if (world instanceof Level _lvl13 && _lvl13.isDay() && entity.onGround()) {
			entity.getPersistentData().putBoolean("sleeping", true);
		} else {
			entity.getPersistentData().putBoolean("sleeping", false);
		}
		if (entity.getPersistentData().getBoolean("sleeping") == true) {
			if (entity instanceof SilkMothEntity) {
				((SilkMothEntity) entity).setAnimation("animation.silk_moth.rest");
			}
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
		} else {
			if (entity instanceof SilkMothEntity) {
				((SilkMothEntity) entity).setAnimation("empty");
			}
		}
		if (world instanceof Level _lvl32 && _lvl32.isDay()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.08), (entity.getDeltaMovement().z())));
		}
	}
}

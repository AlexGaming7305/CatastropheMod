package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.SilkMothEntity;

public class SilkMothOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double spawn = 0;
		spawn = Math.round(Math.random() * 5);
		if (spawn == 0) {
			if (entity instanceof SilkMothEntity animatable)
				animatable.setTexture("mulberry_silk_moth");
			entity.getPersistentData().putBoolean("mulberry_silk_moth", true);
		} else if (spawn == 1) {
			if (entity instanceof SilkMothEntity animatable)
				animatable.setTexture("luna_moth");
			entity.getPersistentData().putBoolean("luna_moth", true);
		} else if (spawn == 2) {
			if (entity instanceof SilkMothEntity animatable)
				animatable.setTexture("cecropia_moth");
			entity.getPersistentData().putBoolean("cecropia_moth", true);
		} else if (spawn == 3) {
			if (entity instanceof SilkMothEntity animatable)
				animatable.setTexture("polyphemus_moth");
			entity.getPersistentData().putBoolean("polyphemus_moth", true);
		} else if (spawn == 4) {
			if (entity instanceof SilkMothEntity animatable)
				animatable.setTexture("comet_moth");
			entity.getPersistentData().putBoolean("comet_moth", true);
		} else if (spawn == 5) {
			if (entity instanceof SilkMothEntity animatable)
				animatable.setTexture("rosy_maple_moth");
			entity.getPersistentData().putBoolean("rosy_maple_moth", true);
		}
	}
}

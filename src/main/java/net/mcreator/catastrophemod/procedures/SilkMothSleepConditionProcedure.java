package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

public class SilkMothSleepConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("sleeping") == false && !entity.onGround()) {
			return true;
		}
		return false;
	}
}

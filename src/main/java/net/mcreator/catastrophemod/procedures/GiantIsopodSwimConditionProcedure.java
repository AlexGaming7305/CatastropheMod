package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

public class GiantIsopodSwimConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("isopodpanicked") == false) {
			return true;
		}
		return false;
	}
}

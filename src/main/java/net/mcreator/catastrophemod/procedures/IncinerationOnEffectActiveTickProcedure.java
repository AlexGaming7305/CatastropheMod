package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

public class IncinerationOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isOnFire()) {
			entity.setSecondsOnFire(1);
		}
	}
}

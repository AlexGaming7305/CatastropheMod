package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

public class FierySlashProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(5);
	}
}

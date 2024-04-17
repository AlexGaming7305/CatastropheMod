package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

public class FallDamageImmunityOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = -1;
	}
}

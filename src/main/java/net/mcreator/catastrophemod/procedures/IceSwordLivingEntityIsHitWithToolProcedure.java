package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

public class IceSwordLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen(200);
	}
}

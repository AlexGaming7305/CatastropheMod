package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.NettleEntity;

public class NettleOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof NettleEntity) {
			((NettleEntity) entity).setAnimation("animation.nettle.spawn");
		}
	}
}

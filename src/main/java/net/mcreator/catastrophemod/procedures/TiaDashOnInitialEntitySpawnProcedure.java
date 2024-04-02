package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.CatastropheModMod;

public class TiaDashOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CatastropheModMod.queueServerWork(25, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}

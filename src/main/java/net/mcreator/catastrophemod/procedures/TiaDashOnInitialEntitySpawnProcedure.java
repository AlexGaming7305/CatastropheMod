package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

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

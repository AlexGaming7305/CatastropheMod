package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NettleOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof NettleEntity) {
			((NettleEntity) entity).setAnimation("animation.nettle.spawn");
		}
	}
}

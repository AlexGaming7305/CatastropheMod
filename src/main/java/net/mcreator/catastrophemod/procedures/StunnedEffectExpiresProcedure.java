package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StunnedEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (false) {
				CatastropheModMod.LOGGER.info(entity);
			}
			((Mob) entity).setNoAi(false);
		}
	}
}

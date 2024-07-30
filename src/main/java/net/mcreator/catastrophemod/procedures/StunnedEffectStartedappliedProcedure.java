package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.CatastropheModMod;

public class StunnedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (false) {
				CatastropheModMod.LOGGER.info(entity);
			}
			((Mob) entity).setNoAi(true);
		}
	}
}

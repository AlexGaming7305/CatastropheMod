package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

public class ManaBar46Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new CatastropheModModVariables.PlayerVariables())).Mana >= (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Maxmana * 0.8
				&& (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CatastropheModModVariables.PlayerVariables())).Mana < (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Maxmana * 0.81) {
			return true;
		}
		return false;
	}
}
package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ManaBar48Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new CatastropheModModVariables.PlayerVariables())).Mana >= (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Maxmana * 0.83
				&& (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CatastropheModModVariables.PlayerVariables())).Mana < (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Maxmana * 0.85) {
			return true;
		}
		return false;
	}
}

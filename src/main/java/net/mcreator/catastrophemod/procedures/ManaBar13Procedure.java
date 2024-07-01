package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

public class ManaBar13Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana >= ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAXMANA.get())
				.getBaseValue() * 0.21
				&& (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana < ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAXMANA.get())
						.getBaseValue() * 0.23) {
			return true;
		}
		return false;
	}
}

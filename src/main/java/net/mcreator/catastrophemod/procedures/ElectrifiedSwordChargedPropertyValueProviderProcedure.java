package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

public class ElectrifiedSwordChargedPropertyValueProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).electrified_sword_charges == 2) {
			return 2;
		}
		return 0;
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.CatastropheModMod;

public class HeatMeterPrintProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CatastropheModMod.LOGGER.info((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Heat_Meter_Fill);
	}
}

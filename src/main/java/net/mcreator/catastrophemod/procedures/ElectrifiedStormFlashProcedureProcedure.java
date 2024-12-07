package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ElectrifiedStormFlashProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CatastropheModMod.LOGGER.info((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).fade_variable);
	}
}

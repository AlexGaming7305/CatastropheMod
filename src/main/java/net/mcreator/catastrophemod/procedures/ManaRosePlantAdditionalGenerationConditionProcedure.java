package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ManaRosePlantAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (Math.random() < 0.05) {
			return true;
		}
		return false;
	}
}

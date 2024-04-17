package net.mcreator.catastrophemod.procedures;

public class ManaRosePlantAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (Math.random() < 0.05) {
			return true;
		}
		return false;
	}
}

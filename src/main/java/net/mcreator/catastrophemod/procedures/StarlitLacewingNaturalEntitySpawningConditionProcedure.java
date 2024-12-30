package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class StarlitLacewingNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) == world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) && !(world instanceof Level _lvl2 && _lvl2.isDay())) {
			return true;
		}
		return false;
	}
}

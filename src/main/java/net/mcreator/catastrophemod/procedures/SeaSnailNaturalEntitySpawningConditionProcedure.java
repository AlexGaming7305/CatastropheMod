package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SeaSnailNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SAND || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.STONE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER) {
			return true;
		}
		return false;
	}
}

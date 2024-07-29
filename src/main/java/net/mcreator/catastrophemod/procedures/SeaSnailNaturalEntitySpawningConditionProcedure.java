package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SeaSnailNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SAND || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.STONE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER) {
			return true;
		}
		return false;
	}
}

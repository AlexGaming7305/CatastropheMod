package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TidepoolsAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER
				&& (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == Blocks.WATER)) {
			return true;
		}
		return false;
	}
}

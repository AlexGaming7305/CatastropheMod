package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class TidepoolsAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER
				&& (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.WATER && (world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == Blocks.WATER)) {
			return true;
		}
		return false;
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.CatastropheModMod;

public class CrystalShardWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), x, y, z, 1, 0, 0, 0, 0.1);
		CatastropheModMod.queueServerWork(5, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
		immediatesourceentity.setNoGravity(true);
	}
}
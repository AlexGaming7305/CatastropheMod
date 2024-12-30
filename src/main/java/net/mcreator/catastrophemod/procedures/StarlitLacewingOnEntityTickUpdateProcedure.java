package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;

public class StarlitLacewingOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		double yort = 0;
		double xort = 0;
		double lifetime = 0;
		double sum = 0;
		double turn = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double speed = 0;
		double zort = 0;
		double zvel = 0;
		double yvel = 0;
		double radius = 0;
		double xvel = 0;
		Entity nightfallsdemiseowner = null;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.STARRY_SPARKLE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.05);
		if (entity.getY() >= world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) + 8) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 0.02), (entity.getDeltaMovement().z())));
		}
	}
}

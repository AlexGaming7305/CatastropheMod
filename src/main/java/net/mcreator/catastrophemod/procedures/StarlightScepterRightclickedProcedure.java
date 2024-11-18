package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.CatastropheModMod;

public class StarlightScepterRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double range = 0;
		CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals = true;
		CatastropheModModVariables.MapVariables.get(world).syncData(world);
		CatastropheModMod.queueServerWork(17, () -> {
			CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals = false;
			CatastropheModModVariables.MapVariables.get(world).syncData(world);
		});
		for (int index0 = 0; index0 < 100; index0++) {
			range = range + 0.1;
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.STARRY_SPARKLE.get()), (entity.getX() + (entity.getLookAngle().x * range) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * range) / 2),
						(entity.getZ() + (entity.getLookAngle().z * range) / 2), 1, 0, 0, 0, 0);
		}
	}
}

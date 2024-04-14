package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CrimsonRayRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		double increaser = 0;
		double range = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		double Scaling = 0;
		for (int index0 = 0; index0 < 200; index0++) {
			if (!world.getBlockState(new BlockPos(
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
					entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
					.canOcclude() || raytrace_distance < 200) {
				raytrace_distance = raytrace_distance + 0.3;
			} else {
				break;
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, (entity.getX() + (Math.sin(Math.toRadians(entity.getYRot() + 180)) * raytrace_distance) / 2), (entity.getY() + 1.3 + (Math.sin(Math.toRadians(0 - entity.getXRot())) * raytrace_distance) / 2),
						(entity.getZ() + (Math.cos(Math.toRadians(entity.getYRot())) * raytrace_distance) / 2), 1, 0, 0, 0, 0);
		}
	}
}

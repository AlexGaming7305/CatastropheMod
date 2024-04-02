package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class GhostPhantomWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
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
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.GLOW, x, y, z, 2, 0.2, 0.1, 0.2, 0);
		xvel = immediatesourceentity.getDeltaMovement().x();
		yvel = immediatesourceentity.getDeltaMovement().y();
		zvel = immediatesourceentity.getDeltaMovement().z();
		flag = true;
		turn = 0.4;
		speed = 1.5;
		radius = 100;
		lifetime = 100;
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") >= 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (flag && (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(
							new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							25, 25, 25), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
							.findFirst().orElse(null)) || entityiterator instanceof Monster == true)) {
						flag = false;
						xdir = entityiterator.getX() - immediatesourceentity.getX();
						ydir = (entityiterator.getY() + entityiterator.getBbHeight()) - immediatesourceentity.getY();
						zdir = entityiterator.getZ() - immediatesourceentity.getZ();
					}
				}
			}
			sum = Math.abs(xdir) + Math.abs(ydir) + Math.abs(zdir);
			if (!(sum == 0)) {
				xort = xdir / sum;
				yort = ydir / sum;
				zort = zdir / sum;
				xvel = xvel + xort * turn;
				yvel = yvel + yort * turn;
				zvel = zvel + zort * turn;
			}
			sum = Math.abs(xvel) + Math.abs(yvel) + Math.abs(zvel);
			xvel = (xvel / sum) * speed;
			yvel = (yvel / sum) * speed;
			zvel = (zvel / sum) * speed;
			immediatesourceentity.setDeltaMovement(new Vec3(xvel, yvel, zvel));
		}
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") > lifetime) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		} else {
			immediatesourceentity.getPersistentData().putDouble("lifetime", (immediatesourceentity.getPersistentData().getDouble("lifetime") + 1));
		}
	}
}
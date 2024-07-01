package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AccursedSoulWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
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
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.HAUNTED_GLIMMER.get()), x, y, z, 2, 0.1, 0.1, 0.1, 0);
		xvel = immediatesourceentity.getDeltaMovement().x();
		yvel = immediatesourceentity.getDeltaMovement().y();
		zvel = immediatesourceentity.getDeltaMovement().z();
		flag = true;
		turn = 0.6;
		speed = 1.5;
		radius = 30;
		lifetime = 100;
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") >= 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (flag && (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator instanceof Monster == true)) {
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

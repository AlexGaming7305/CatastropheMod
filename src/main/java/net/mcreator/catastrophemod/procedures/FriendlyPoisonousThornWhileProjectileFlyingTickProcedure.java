package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FriendlyPoisonousThornWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		CatastropheModMod.queueServerWork(20, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Monster) {
						if (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
							immediatesourceentity.setDeltaMovement(
									new Vec3(((entityiterator.getX() - immediatesourceentity.getX()) * 0.1), (((entityiterator.getY() + 1) - immediatesourceentity.getY()) * 0.1), ((entityiterator.getZ() - immediatesourceentity.getZ()) * 0.1)));
						}
					}
				}
			}
		});
		world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.POISON_TRAIL.get()), x, y, z, 0, 1, 0);
		CatastropheModMod.queueServerWork(60, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
		immediatesourceentity.setNoGravity(true);
	}
}

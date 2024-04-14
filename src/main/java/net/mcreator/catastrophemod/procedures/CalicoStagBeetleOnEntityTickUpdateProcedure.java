package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CalicoStagBeetleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		if (entity.getPersistentData().getDouble("calicobeetleai") == 130) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("calicobeetleai", 0);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()) {
				CatastropheModMod.queueServerWork(60, () -> {
					entity.setNoGravity(true);
					entity.setDeltaMovement(new Vec3(0, 0.15, 0));
				});
				CatastropheModMod.queueServerWork(80, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (entityiterator instanceof Player) {
									entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.15), (((entityiterator.getY() + 1) - entity.getY()) * 0.15), ((entityiterator.getZ() - entity.getZ()) * 0.15)));
									if (entity instanceof CalicoStagBeetleEntity) {
										((CalicoStagBeetleEntity) entity).setAnimation("animation.calico_stag_beetle.attack_flying");
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(100, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (entityiterator instanceof Player) {
									entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.15), (((entityiterator.getY() + 1) - entity.getY()) * 0.15), ((entityiterator.getZ() - entity.getZ()) * 0.15)));
									if (entity instanceof CalicoStagBeetleEntity) {
										((CalicoStagBeetleEntity) entity).setAnimation("animation.calico_stag_beetle.attack_flying");
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(130, () -> {
					entity.setNoGravity(false);
				});
			}
		} else {
			entity.getPersistentData().putDouble("calicobeetleai", (entity.getPersistentData().getDouble("calicobeetleai") + 1));
		}
	}
}

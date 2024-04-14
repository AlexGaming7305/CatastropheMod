package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SwordSpinDashOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof SwordspinEntity) {
					entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.3), (((entity.getY() + 1) - entityiterator.getY()) * 0.3), ((entity.getZ() - entityiterator.getZ()) * 0.3)));
				}
			}
		}
	}
}

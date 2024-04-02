package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.entity.NatureBlessedSpiritEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class HealingOrbWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof NatureBlessedSpiritEntity == true) {
					immediatesourceentity.setDeltaMovement(new Vec3((((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX() - immediatesourceentity.getX()) * 0.2),
							((((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY() + 1) - immediatesourceentity.getY()) * 0.2),
							(((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ() - immediatesourceentity.getZ()) * 0.2)));
				}
			}
		}
		world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.HEALING_SPARK.get()), x, y, z, 0, 1, 0);
		immediatesourceentity.setNoGravity(true);
		CatastropheModMod.queueServerWork(100, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}

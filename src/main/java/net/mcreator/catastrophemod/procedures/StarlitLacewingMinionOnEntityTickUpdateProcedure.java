package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class StarlitLacewingMinionOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		double yort = 0;
		double xort = 0;
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
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.STARRY_SPARKLE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.05);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("lacewingai", 15);
			entity.lookAt(EntityAnchorArgument.Anchor.EYES,
					new Vec3((entity.getX() + (entity.getDeltaMovement().x() * 5) / 2), (entity.getY() + 1.5 + (entity.getDeltaMovement().y() * 5) / 2), (entity.getZ() + (entity.getDeltaMovement().z() * 5) / 2)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
						if (!(entity.getPersistentData().getDouble("X") - entityiterator.getX() <= 3 && entity.getPersistentData().getDouble("Y") - entityiterator.getY() <= 3 && entity.getPersistentData().getDouble("Z") - entityiterator.getZ() <= 3
								&& entity.getPersistentData().getDouble("X") - entityiterator.getX() >= -3 && entity.getPersistentData().getDouble("Y") - entityiterator.getY() >= -3
								&& entity.getPersistentData().getDouble("Z") - entityiterator.getZ() >= -3)) {
							entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + (entityiterator.getX() - entity.getX()) * 0.1), (entity.getDeltaMovement().y() + ((entityiterator.getY() + 1) - entity.getY()) * 0.1),
									(entity.getDeltaMovement().z() + (entityiterator.getZ() - entity.getZ()) * 0.1)));
							entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (((entityiterator.getY() + 1) - entity.getY()) * 0.1), (entity.getDeltaMovement().z())));
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("lacewingai") == 0) {
			entity.getPersistentData().putDouble("lacewingai", 15);
		} else {
			entity.getPersistentData().putDouble("lacewingai", (entity.getPersistentData().getDouble("lacewingai") - 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			xvel = entity.getDeltaMovement().x();
			yvel = entity.getDeltaMovement().y();
			zvel = entity.getDeltaMovement().z();
			flag = true;
			turn = 0.8;
			speed = 1;
			radius = 20;
			if (entity.getPersistentData().getDouble("lacewingai") >= 10 && entity.getPersistentData().getDouble("lacewingai") <= 12) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 4);
								}
							}
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (flag && entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
							flag = false;
							xdir = entityiterator.getX() - entity.getX();
							ydir = (entityiterator.getY() + entityiterator.getBbHeight() / 2) - entity.getY();
							zdir = entityiterator.getZ() - entity.getZ();
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
				entity.setDeltaMovement(new Vec3(xvel, yvel, zvel));
			}
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class WhirlpoolEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		entity.setNoGravity(true);
		CatastropheModMod.queueServerWork(20, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		if (entity.getPersistentData().getDouble("pull") == 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator == entity) == false) {
						if (!(entityiterator instanceof Player)) {
							entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.3), (((entity.getY() + 1) - entityiterator.getY()) * 0.3), ((entity.getZ() - entityiterator.getZ()) * 0.3)));
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("pull") == 0) {
			entity.getPersistentData().putDouble("pull", 2);
		} else {
			entity.getPersistentData().putDouble("pull", (entity.getPersistentData().getDouble("pull") - 1));
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, x, (y + 1), z, 5, 0.5, 0.5, 0.5, 0);
	}
}

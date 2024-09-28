package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.entity.SeaCrystalRiptideProjectileEntity;

import java.util.List;
import java.util.Comparator;

public class SeaCrystalRiptideProjectileOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double lifetime = 0;
		Entity riptideowner = null;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 255, false, false));
		lifetime = 20;
		if (entity.getPersistentData().getDouble("lifetime") > lifetime) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("RiptideOwner"))) {
					riptideowner = entityiterator;
				}
			}
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity) {
					if (!(entityiterator instanceof SeaCrystalRiptideProjectileEntity)) {
						if (!(entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("RiptideOwner"))) {
							if (entityiterator.isAlive()) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), riptideowner), 7);
							}
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator == entity) == false) {
					if (entityiterator.isAlive()) {
						if (!(entityiterator instanceof SeaCrystalRiptideProjectileEntity)) {
							if (!(entityiterator instanceof Player)) {
								entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.05), (((entity.getY() + 0) - entityiterator.getY()) * 0.05), ((entity.getZ() - entityiterator.getZ()) * 0.05)));
							}
						}
					}
				}
			}
		}
	}
}

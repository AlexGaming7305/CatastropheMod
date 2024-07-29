package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.entity.DiamondDetonationBombEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class DiamondDetonationBombOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double lifetime = 0;
		Entity nightfallsdemiseowner = null;
		Entity DetonationOwner = null;
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
		lifetime = 100;
		if (entity.getPersistentData().getDouble("lifetime") > lifetime) {
			if (!entity.level().isClientSide())
				entity.discard();
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("DetonationOwner"))) {
						{
							boolean _setval = false;
							entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.diamond_detonation_used = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					{
						double _setval = 3;
						entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.intensity_timer = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						boolean _setval = true;
						entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.screenshake = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					CatastropheModMod.queueServerWork(15, () -> {
						{
							boolean _setval = false;
							entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.screenshake = _setval;
								capability.syncPlayerVariables(entityiterator);
							});
						}
					});
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity) {
						if (!(entityiterator instanceof DiamondDetonationBombEntity)) {
							if (!(entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("DetonationOwner"))) {
								if (entityiterator.isAlive()) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION), DetonationOwner), 10);
								}
							}
						}
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/photon fx photon:diamond_explosion block ~ ~ ~");
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 3, 0.5, 0.5, 0.5, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 20, 0.5, 0.5, 0.5, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 20, 0.5, 0.5, 0.5, 0.2);
		} else {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("DetonationOwner"))) {
					DetonationOwner = entityiterator;
				}
			}
		}
	}
}

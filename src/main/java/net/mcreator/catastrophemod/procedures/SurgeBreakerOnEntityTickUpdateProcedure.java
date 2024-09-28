package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.entity.VoltbladeEntity;
import net.mcreator.catastrophemod.entity.SurgeBreakerEntity;
import net.mcreator.catastrophemod.entity.ArcStrikerEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class SurgeBreakerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double attack = 0;
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("surgebreakerai", 60);
		}
		if (entity.getPersistentData().getDouble("surgebreakerai") == 0) {
			entity.getPersistentData().putDouble("surgebreakerai", 60);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() <= 10
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() <= 10
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() <= 10
						&& entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() >= -10
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= -10
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() >= -10) {
					if (entity instanceof SurgeBreakerEntity) {
						((SurgeBreakerEntity) entity).setAnimation("animation.surge_breaker.shockwave");
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_charging entity @s");
						}
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_charge")), SoundSource.HOSTILE, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_charge")), SoundSource.HOSTILE, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
							}
						}
					});
					CatastropheModMod.queueServerWork(27, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_shockwave")), SoundSource.HOSTILE,
											1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_shockwave")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_shockwave entity @s 0 0.2 0");
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
									CatastropheModMod.queueServerWork(40, () -> {
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
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (entityiterator.getY() == entity.getY()) {
												if (!(entityiterator instanceof ArcStrikerEntity || entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof VoltbladeEntity)) {
													entityiterator.hurt(new DamageSource(
															world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity),
															10);
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
												}
											}
										}
									}
								}
							}
						}
					});
				}
			}
		} else {
			entity.getPersistentData().putDouble("surgebreakerai", (entity.getPersistentData().getDouble("surgebreakerai") - 1));
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.VoltbladeEntity;
import net.mcreator.catastrophemod.entity.SurgeBreakerEntity;
import net.mcreator.catastrophemod.entity.MineralWraithEntity;
import net.mcreator.catastrophemod.entity.ArcStrikerEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class MineralWrathOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		double attack = 0;
		if (CatastropheModModVariables.MapVariables.get(world).electrified_storm == false) {
			if (entity.isAlive()) {
				CatastropheModModVariables.MapVariables.get(world).electrified_storm = true;
				CatastropheModModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("mineral_wraith_ai", 50);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
			entity.getPersistentData().putBoolean("Phase2", true);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("lightningcooldown") == false) {
			if (entity.isAlive()) {
				entity.getPersistentData().putDouble("mwx", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -1, 1)));
				entity.getPersistentData().putDouble("mwy", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
				entity.getPersistentData().putDouble("mwz", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -1, 1)));
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if (entity.getPersistentData().getDouble("mineral_wraith_ai") == 0) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					attack = Math.round(Math.random() * 3);
					if (attack == 0) {
						entity.getPersistentData().putDouble("mineral_wraith_ai", 50);
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.thunderclap");
						}
						entity.getPersistentData().putBoolean("thunderclap", true);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_teleport entity @s 0 1.5 0");
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -2, 2) + 0.5),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -2, 2) + 0.5));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -2, 2) + 0.5),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -2, 2) + 0.5), _ent.getYRot(), _ent.getXRot());
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_charging entity @s");
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_charges")), SoundSource.HOSTILE, 1,
										1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_charges")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:mineral_wraith_teleport block ~0.5 ~1.5 ~0.5");
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(35, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									entity.getPersistentData().putBoolean("thunderclap", false);
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:thunderclap entity @s 0 1.5 0");
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_claps")),
													SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY() + 1.5), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_claps")), SoundSource.HOSTILE, 1, 1,
													false);
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entityiterator instanceof LivingEntity) {
													entityiterator.hurt(new DamageSource(
															world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 7);
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
												}
											}
										}
									}
								}
							}
						});
					}
					if (attack == 1) {
						entity.getPersistentData().putDouble("mineral_wraith_ai", 50);
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.phasing_thunder");
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")),
										SoundSource.HOSTILE, 2, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY() + 1.5), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")), SoundSource.HOSTILE, 2, 1,
										false);
							}
						}
						entity.setDeltaMovement(new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getLookAngle().x * 1), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getLookAngle().y),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getLookAngle().z * 1)));
						CatastropheModMod.queueServerWork(18, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									entity.getPersistentData().putBoolean("dash", true);
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:mineral_wraith_dash_lightning entity @s 0 1.5 0");
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrical_surge")),
													SoundSource.HOSTILE, 2, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY() + 1.5), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrical_surge")), SoundSource.HOSTILE, 2, 1,
													false);
										}
									}
									entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.2),
											((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1) - entity.getY()) * 0.2),
											(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.2)));
								}
							}
						});
						CatastropheModMod.queueServerWork(35, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									entity.getPersistentData().putBoolean("dash", false);
									entity.setDeltaMovement(new Vec3(0, 0, 0));
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:mineral_wraith_teleport entity @s 0 1.5 0");
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1,
													1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									{
										Entity _ent = entity;
										_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -5, 5) + 0.5),
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + Mth.nextDouble(RandomSource.create(), 1, 3)),
												((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -5, 5) + 0.5));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -5, 5) + 0.5),
													((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + Mth.nextDouble(RandomSource.create(), 1, 3)),
													((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -5, 5) + 0.5), _ent.getYRot(), _ent.getXRot());
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(36, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:mineral_wraith_teleport block ~0.5 ~1.5 ~0.5");
										}
									}
								}
							}
						});
					}
					if (attack == 2) {
						entity.getPersistentData().putDouble("mineral_wraith_ai", 50);
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.lightning_slam");
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + 0.5), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 7),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + 0.5));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + 0.5), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 7),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + 0.5), _ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_teleport entity @s 0 1.5 0");
							}
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:mineral_wraith_teleport block ~0.5 ~1.5 ~0.5");
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(27, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_dash_lightning entity @s 0 1.5 0");
								}
							}
							entity.setDeltaMovement(new Vec3(0, (-2), 0));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")),
											SoundSource.HOSTILE, 2, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY() + 1.5), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")), SoundSource.HOSTILE, 2, 1,
											false);
								}
							}
						});
						CatastropheModMod.queueServerWork(35, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_cracks block ~ ~-1 ~");
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CatastropheModModEntities.ELECTRIFIED_LIGHTNING.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")),
											SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.HOSTILE, 1, 1,
											false);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										entityiterator.hurt(new DamageSource(
												world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 8);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
									}
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
						});
					}
					if (attack == 3) {
						entity.getPersistentData().putDouble("mineral_wraith_ai", 170);
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.blade_combo");
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -2, 2)));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextDouble(RandomSource.create(), -2, 2)),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextDouble(RandomSource.create(), -2, 2)),
										_ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_teleport entity @s 0 1.5 0");
							}
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity.isAlive()) {
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"/photon fx photon:mineral_wraith_teleport block ~0.5 ~1.5 ~0.5");
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(10, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_charges")), SoundSource.HOSTILE,
											1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_charges")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_summon_sword entity @s 0 4 0");
								}
							}
						});
						CatastropheModMod.queueServerWork(15, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:weak_metal_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 1.1, 1.3));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:weak_metal_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 1.1, 1.3), false);
								}
							}
						});
						CatastropheModMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:weak_metal_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 1.1, 1.3));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:weak_metal_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 1.1, 1.3), false);
								}
							}
						});
						CatastropheModMod.queueServerWork(25, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:weak_metal_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 1.1, 1.3));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:weak_metal_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 1.1, 1.3), false);
								}
							}
						});
						CatastropheModMod.queueServerWork(30, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
						});
						CatastropheModMod.queueServerWork(35, () -> {
							entity.getPersistentData().putBoolean("bladecombo", true);
						});
						CatastropheModMod.queueServerWork(63, () -> {
						});
						CatastropheModMod.queueServerWork(65, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 5);
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(70, () -> {
							if (entity instanceof MineralWraithEntity animatable)
								animatable.setTexture("mineral_wraith_texture_charge_1");
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_sword_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_sword_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
						});
						CatastropheModMod.queueServerWork(83, () -> {
						});
						CatastropheModMod.queueServerWork(85, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 5);
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(90, () -> {
							if (entity instanceof MineralWraithEntity animatable)
								animatable.setTexture("mineral_wraith_texture_charge_2");
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_sword_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_sword_hit")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
						});
						CatastropheModMod.queueServerWork(116, () -> {
						});
						CatastropheModMod.queueServerWork(118, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 5);
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(149, () -> {
						});
						CatastropheModMod.queueServerWork(151, () -> {
							if (entity.isAlive()) {
								entity.getPersistentData().putBoolean("bladecombo", false);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CatastropheModModEntities.ELECTRIFIED_SWORD_PROJECTILE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 2.5, entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
								if (entity instanceof MineralWraithEntity animatable)
									animatable.setTexture("mineral_wraith_texture");
							}
						});
					}
				}
			} else {
				entity.getPersistentData().putDouble("mineral_wraith_ai", (entity.getPersistentData().getDouble("mineral_wraith_ai") - 1));
			}
		} else if (entity.getPersistentData().getBoolean("Phase2") == true) {
			if (entity.getPersistentData().getDouble("mineral_wraith_ai") == 0) {
				entity.getPersistentData().putDouble("mineral_wraith_ai", 50);
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					attack = Math.round(Math.random() * 2);
					if (attack == 0) {
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.lightning_slam");
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 7),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 7),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), _ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						CatastropheModMod.queueServerWork(27, () -> {
							entity.setDeltaMovement(new Vec3(0, (-2), 0));
						});
						CatastropheModMod.queueServerWork(35, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_cracks block ~ ~-1 ~");
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CatastropheModModEntities.ELECTRIFIED_LIGHTNING.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")),
											SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.HOSTILE, 1, 1,
											false);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										entityiterator.hurt(new DamageSource(
												world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 8);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
									}
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
						});
					}
					if (attack == 1) {
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.raging_thunder");
						}
						CatastropheModMod.queueServerWork(10, () -> {
							entity.getPersistentData().putBoolean("ragingthunder", true);
						});
						CatastropheModMod.queueServerWork(70, () -> {
							entity.getPersistentData().putBoolean("ragingthunder", false);
						});
					}
					if (attack == 2) {
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("animation.mineral_wraith.tempest_strike");
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("mineral_wraith_ai", (entity.getPersistentData().getDouble("mineral_wraith_ai") - 1));
			}
		}
		if (entity.getPersistentData().getBoolean("thunderclap") == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.setDeltaMovement(new Vec3(0, 0, 0));
			}
		}
		if (entity.getPersistentData().getBoolean("bladecombo") == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.05),
						((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 0) - entity.getY()) * 0.05), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.05)));
			}
		}
		if (entity.getPersistentData().getBoolean("ragingthunder") == false) {
			entity.getPersistentData().putDouble("lightningstrikes", 19);
		}
		if (entity.getPersistentData().getDouble("lightningstrikes") == 0) {
			entity.getPersistentData().putDouble("lightningstrikes", 19);
			if (entity.getPersistentData().getBoolean("ragingthunder") == true) {
				if (entity.isAlive()) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("mwx")), (entity.getPersistentData().getDouble("mwy")), (entity.getPersistentData().getDouble("mwz"))),
										Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/photon fx photon:lightning_telegraph block ~ ~0.5 ~");
					CatastropheModMod.queueServerWork(19, () -> {
						{
							final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("mwx")), (entity.getPersistentData().getDouble("mwy")), (entity.getPersistentData().getDouble("mwz")));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
										entityiterator.hurt(new DamageSource(
												world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 8);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
									}
								}
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("mwx")), (entity.getPersistentData().getDouble("mwy")), (entity.getPersistentData().getDouble("mwz")));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CatastropheModModEntities.ELECTRIFIED_LIGHTNING.get().spawn(_level,
									BlockPos.containing(entity.getPersistentData().getDouble("mwx"), entity.getPersistentData().getDouble("mwy"), entity.getPersistentData().getDouble("mwz")), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("mwx"), entity.getPersistentData().getDouble("mwy"), entity.getPersistentData().getDouble("mwz")),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.HOSTILE, 3, 1);
							} else {
								_level.playLocalSound((entity.getPersistentData().getDouble("mwx")), (entity.getPersistentData().getDouble("mwy")), (entity.getPersistentData().getDouble("mwz")),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.HOSTILE, 3, 1, false);
							}
						}
					});
					entity.getPersistentData().putBoolean("lightningcooldown", true);
					CatastropheModMod.queueServerWork(20, () -> {
						entity.getPersistentData().putBoolean("lightningcooldown", false);
					});
				}
			}
		} else {
			entity.getPersistentData().putDouble("lightningstrikes", (entity.getPersistentData().getDouble("lightningstrikes") + -1));
		}
		if (entity.getPersistentData().getBoolean("dash") == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.isAlive()) {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity) {
									entityiterator.hurt(
											new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 8);
								}
							}
						}
					}
				}
			}
		}
	}
}

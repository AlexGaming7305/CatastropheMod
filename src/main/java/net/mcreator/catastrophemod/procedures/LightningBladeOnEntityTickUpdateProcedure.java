package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.TamableAnimal;
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
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.LightningBladeEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class LightningBladeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		double speech = 0;
		double attack = 0;
		double attack_far = 0;
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
		if (entity.getPersistentData().getBoolean("lightningbladeinground") == false) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
				entity.getPersistentData().putDouble("lightningbladeai", 10);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
							entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (((entityiterator.getY() + 0.5) - entity.getY()) * 0.1), (entity.getDeltaMovement().z())));
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
							if (!(entity.getPersistentData().getDouble("X") - entityiterator.getX() <= 3 && entity.getPersistentData().getDouble("Y") - entityiterator.getY() <= 3
									&& entity.getPersistentData().getDouble("Z") - entityiterator.getZ() <= 3 && entity.getPersistentData().getDouble("X") - entityiterator.getX() >= -3
									&& entity.getPersistentData().getDouble("Y") - entityiterator.getY() >= -3 && entity.getPersistentData().getDouble("Z") - entityiterator.getZ() >= -3)) {
								entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + (entityiterator.getX() - entity.getX()) * 0.1), (entity.getDeltaMovement().y() + ((entityiterator.getY() + 0.5) - entity.getY()) * 0.1),
										(entity.getDeltaMovement().z() + (entityiterator.getZ() - entity.getZ()) * 0.1)));
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("lightningbladeai") == 0) {
			entity.getPersistentData().putDouble("lightningbladeai", 35);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() <= 5
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() <= 5
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() <= 5
						&& entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() >= -5
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= -5
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() >= -5) {
					if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
						if (entity instanceof LightningBladeEntity) {
							((LightningBladeEntity) entity).setAnimation("animation.lightning_blade.swings");
						}
						CatastropheModMod.queueServerWork(12, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
										entity.setDeltaMovement(new Vec3(Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.1, 0.75), -0.75),
												Math.max(Math.min(
														(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getBbHeight()) - entity.getY()) * 0.1,
														0.75), -0.75),
												Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.1, 0.75), -0.75)));
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(13, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													if (entityiterator instanceof LivingEntity) {
														entityiterator.hurt(new DamageSource(
																world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
																(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 5);
													}
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(22, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
										entity.setDeltaMovement(new Vec3(Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.1, 0.75), -0.75),
												Math.max(Math.min(
														(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getBbHeight()) - entity.getY()) * 0.1,
														0.75), -0.75),
												Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.1, 0.75), -0.75)));
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(23, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													if (entityiterator instanceof LivingEntity) {
														entityiterator.hurt(new DamageSource(
																world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
																(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 5);
													}
												}
											}
										}
									}
								}
							}
						});
					}
				} else {
					if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
						if (entity instanceof LightningBladeEntity) {
							((LightningBladeEntity) entity).setAnimation("animation.lightning_blade.spin_slash");
						}
						CatastropheModMod.queueServerWork(5, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								entity.getPersistentData().putBoolean("spinslash", true);
							}
						});
						CatastropheModMod.queueServerWork(7, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													if (entityiterator instanceof LivingEntity) {
														entityiterator.hurt(new DamageSource(
																world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
																(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 5);
													}
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(12, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													if (entityiterator instanceof LivingEntity) {
														entityiterator.hurt(new DamageSource(
																world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
																(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 5);
													}
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(17, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													if (entityiterator instanceof LivingEntity) {
														entityiterator.hurt(new DamageSource(
																world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
																(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 5);
													}
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(22, () -> {
							if (entity.getPersistentData().getBoolean("lightningbladeslamming") == false) {
								if (entity.isAlive()) {
									entity.getPersistentData().putBoolean("spinslash", false);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.PLAYERS, 1,
													(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													if (entityiterator instanceof LivingEntity) {
														entityiterator.hurt(new DamageSource(
																world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))),
																(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)), 5);
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
			}
		} else {
			entity.getPersistentData().putDouble("lightningbladeai", (entity.getPersistentData().getDouble("lightningbladeai") - 1));
		}
		if (entity.getPersistentData().getBoolean("lightningbladeinground") == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putBoolean("spinslash", false);
				entity.setDeltaMovement(new Vec3(0, 0, 0));
			}
		}
		if (entity.getPersistentData().getBoolean("spinslash") == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.1),
						((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getBbHeight()) - entity.getY()) * 0.1),
						(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.1)));
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getDouble("lightningbladeai") == 0) {
				if (entity.getPersistentData().getBoolean("lightningbladeslam") == true) {
					entity.getPersistentData().putDouble("lightningbladeai", 35);
					entity.getPersistentData().putBoolean("lightningbladeslam", false);
					entity.getPersistentData().putBoolean("lightningbladeslamming", true);
					if (entity instanceof LightningBladeEntity) {
						((LightningBladeEntity) entity).setAnimation("empty");
					}
					if (entity instanceof LightningBladeEntity) {
						((LightningBladeEntity) entity).setAnimation("animation.lightning_blade.slam");
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_teleport entity @s 0 1 0");
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 7),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 7),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), _ent.getYRot(), _ent.getXRot());
					}
					CatastropheModMod.queueServerWork(5, () -> {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:mineral_wraith_dash_lightning entity @s 0 1 0");
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")), SoundSource.PLAYERS,
										1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
						entity.setDeltaMovement(new Vec3(0, (-1.8), 0));
					});
					CatastropheModMod.queueServerWork(15, () -> {
						entity.getPersistentData().putBoolean("lightningbladeinground", true);
						CatastropheModMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("lightningbladeinground", false);
							entity.getPersistentData().putBoolean("lightningbladeslamming", false);
						});
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_cracks block ~ ~ ~");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/photon fx photon:electrified_flow block ~ ~ ~");
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
										SoundSource.PLAYERS, 2, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.PLAYERS, 2, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
										if (entityiterator instanceof LivingEntity) {
											entityiterator.hurt(
													new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))),
															(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
													10);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 60, 0));
										}
									}
								}
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								{
									double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 2;
									entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.intensity_timer = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								{
									double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 40;
									entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.screenshake_time = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
							}
						}
					});
				}
			}
		}
	}
}

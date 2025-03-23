package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.entity.StormsmithEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class StormsmithOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
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
		double speech = 0;
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)
				&& (entity.getPersistentData().getBoolean("seismicslamcooldown") == true || entity.getPersistentData().getBoolean("strikerbash") == true || entity.getPersistentData().getBoolean("heavyhitter") == true)) {
			if (entity.isAlive()) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.5),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("weldingblowcooldown") == true) {
			if (entity.isAlive()) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES,
						new Vec3((entity.getPersistentData().getDouble("stormsmithweldx")), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.5), (entity.getPersistentData().getDouble("stormsmithweldz"))));
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("seismicslamcooldown") == false) {
			if (entity.isAlive()) {
				entity.getPersistentData().putDouble("stormsmithjumpx", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				entity.getPersistentData().putDouble("stormsmithjumpz", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("weldingblowcooldown") == false) {
			if (entity.isAlive()) {
				entity.getPersistentData().putDouble("stormsmithweldx",
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()));
				entity.getPersistentData().putDouble("stormsmithweldz",
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
			}
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("stormsmith_ai", 60);
			entity.getPersistentData().putDouble("stormsmithjumpx", 0);
			entity.getPersistentData().putDouble("stormsmithjumpz", 0);
		}
		if (entity.getPersistentData().getDouble("stormsmith_ai") == 0) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() <= 7
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() <= 7
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() <= 7
						&& entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() >= -7
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= -7
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() >= -7) {
					attack = Math.round(Math.random() * 1);
					if (attack == 0) {
						entity.getPersistentData().putDouble("stormsmith_ai", 90);
						entity.getPersistentData().putBoolean("heavyhitter", true);
						speech = Math.round(Math.random() * 2);
						if (speech == 0) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76Enough!")), false);
							}
						}
						if (speech == 1) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76Your soul shall work wonders\u2026")), false);
							}
						}
						if (speech == 2) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76No more tricks!")), false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 75, 255, false, false));
						if (entity instanceof StormsmithEntity) {
							((StormsmithEntity) entity).setAnimation("animation.stormsmith.heavy_hitter");
						}
						CatastropheModMod.queueServerWork(35, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_swings")),
												SoundSource.HOSTILE, 2, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_swings")), SoundSource.HOSTILE, 2, 1, false);
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(36, () -> {
							if (entity.isAlive()) {
								entity.setDeltaMovement(new Vec3(Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.25, 1.5), -1.5), 0.1,
										Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.25, 1.5), -1.5)));
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 12);
												entityiterator.setDeltaMovement(new Vec3((2 * entity.getLookAngle().x), 0.3, (2 * entity.getLookAngle().z)));
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:heavy_hitter")),
																SoundSource.HOSTILE, 2, 1);
													} else {
														_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:heavy_hitter")), SoundSource.HOSTILE, 2,
																1, false);
													}
												}
												{
													double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 0.25;
													entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.intensity_timer = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
												}
												{
													double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 0.25;
													entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.screenshake_time = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(63, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_swings")),
												SoundSource.HOSTILE, 2, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_swings")), SoundSource.HOSTILE, 2, 1, false);
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(64, () -> {
							if (entity.isAlive()) {
								entity.setDeltaMovement(new Vec3(Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.25, 1.5), -1.5), 0.1,
										Math.max(Math.min(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.25, 1.5), -1.5)));
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 12);
												entityiterator.setDeltaMovement(new Vec3((2 * entity.getLookAngle().x), 0.3, (2 * entity.getLookAngle().z)));
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:heavy_hitter")),
																SoundSource.HOSTILE, 2, 1);
													} else {
														_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:heavy_hitter")), SoundSource.HOSTILE, 2,
																1, false);
													}
												}
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
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(80, () -> {
							if (entity.isAlive()) {
								entity.getPersistentData().putBoolean("heavyhitter", false);
							}
						});
					}
					if (attack == 1) {
						entity.getPersistentData().putDouble("stormsmith_ai", 90);
						entity.getPersistentData().putBoolean("weldingblowcooldown", true);
						speech = Math.round(Math.random() * 2);
						if (speech == 0) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76Ashes to ashes!")), false);
							}
						}
						if (speech == 1) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76You will be reduced to nothing!")), false);
							}
						}
						if (speech == 2) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76You're just another rat waiting to be crushed...")), false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 255, false, false));
						if (entity instanceof StormsmithEntity) {
							((StormsmithEntity) entity).setAnimation("animation.stormsmith.welding_blow");
						}
						CatastropheModMod.queueServerWork(33, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_swings")),
												SoundSource.HOSTILE, 2, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_swings")), SoundSource.HOSTILE, 2, 1, false);
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(38, () -> {
							if (entity.isAlive()) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("stormsmithweldx")), (entity.getY()), (entity.getPersistentData().getDouble("stormsmithweldz"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/photon fx photon:electrified_shockwave block ~0.5 ~ ~0.5");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("stormsmithweldx")), (entity.getY()), (entity.getPersistentData().getDouble("stormsmithweldz"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/photon fx photon:electrified_impact block ~0.5 ~ ~0.5");
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_shockwave")),
												SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_shockwave")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
								{
									final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										{
											double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 3;
											entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.intensity_timer = _setval;
												capability.syncPlayerVariables(entityiterator);
											});
										}
										{
											double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 60;
											entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.screenshake_time = _setval;
												capability.syncPlayerVariables(entityiterator);
											});
										}
									}
								}
								{
									final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("stormsmithweldx")), (entity.getY()), (entity.getPersistentData().getDouble("stormsmithweldz")));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												if (entityiterator.getY() == entity.getY()) {
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
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:welding_blow")), SoundSource.HOSTILE, 2,
												1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:welding_blow")), SoundSource.HOSTILE, 2, 1, false);
									}
								}
								{
									final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("stormsmithweldx")), (entity.getY()), (entity.getPersistentData().getDouble("stormsmithweldz")));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 15);
												entityiterator.setDeltaMovement(new Vec3((2 * entity.getLookAngle().x), 0.3, (2 * entity.getLookAngle().z)));
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:heavy_hitter")),
																SoundSource.HOSTILE, 2, 1);
													} else {
														_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:heavy_hitter")), SoundSource.HOSTILE, 2,
																1, false);
													}
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(80, () -> {
							if (entity.isAlive()) {
								entity.getPersistentData().putBoolean("weldingblowcooldown", false);
							}
						});
					}
				} else {
					attack_far = Math.round(Math.random() * 1);
					if (attack_far == 0) {
						entity.getPersistentData().putDouble("stormsmith_ai", 60);
						entity.getPersistentData().putBoolean("strikerbash", true);
						speech = Math.round(Math.random() * 2);
						if (speech == 0) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76Get back over here!")), false);
							}
						}
						if (speech == 1) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76There is no escape\u2026")), false);
							}
						}
						if (speech == 2) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76This will hurt...")), false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
						if (entity instanceof StormsmithEntity) {
							((StormsmithEntity) entity).setAnimation("animation.stormsmith.striker_bash");
						}
						CatastropheModMod.queueServerWork(24, () -> {
							if (entity.isAlive()) {
							}
						});
						CatastropheModMod.queueServerWork(25, () -> {
							if (entity.isAlive()) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 14, false, false));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_lunges")),
												SoundSource.NEUTRAL, 2, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_lunges")), SoundSource.NEUTRAL, 2, 1, false);
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(40, () -> {
							if (entity.isAlive()) {
								{
									final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 9);
												entityiterator.setDeltaMovement(new Vec3((2.5 * entity.getLookAngle().x), 0.3, (2.5 * entity.getLookAngle().z)));
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:striker_bash")),
																SoundSource.HOSTILE, 2, 1);
													} else {
														_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:striker_bash")), SoundSource.HOSTILE, 2,
																1, false);
													}
												}
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
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(50, () -> {
							if (entity.isAlive()) {
								{
									final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 9);
												entityiterator.setDeltaMovement(new Vec3((2.5 * entity.getLookAngle().x), 0.3, (2.5 * entity.getLookAngle().z)));
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:striker_bash")),
																SoundSource.HOSTILE, 2, 1);
													} else {
														_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:striker_bash")), SoundSource.HOSTILE, 2,
																1, false);
													}
												}
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
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(50, () -> {
							if (entity.isAlive()) {
								entity.getPersistentData().putBoolean("strikerbash", false);
							}
						});
					}
					if (attack_far == 1) {
						entity.getPersistentData().putDouble("stormsmith_ai", 70);
						entity.getPersistentData().putBoolean("seismicslamcooldown", true);
						speech = Math.round(Math.random() * 2);
						if (speech == 0) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76I\u2019m going to crush you like the rat you are!")), false);
							}
						}
						if (speech == 1) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76You shall be the one we incarnate\u2026")), false);
							}
						}
						if (speech == 2) {
							if (Math.random() < 0.3) {
								if (!world.isClientSide() && world.getServer() != null)
									world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A76<" + entity.getDisplayName().getString() + "\u00A76> " + "\u00A76There is no point in trying to run...")), false);
							}
						}
						if (entity instanceof StormsmithEntity) {
							((StormsmithEntity) entity).setAnimation("animation.stormsmith.seismic_slam");
						}
						CatastropheModMod.queueServerWork(23, () -> {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_jumps")), SoundSource.HOSTILE,
												2, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:stormsmith_jumps")), SoundSource.HOSTILE, 2, 1, false);
									}
								}
								entity.setDeltaMovement(new Vec3(((entity.getPersistentData().getDouble("stormsmithjumpx") - entity.getX()) * 0.15), 0.9, ((entity.getPersistentData().getDouble("stormsmithjumpz") - entity.getZ()) * 0.15)));
							}
						});
						CatastropheModMod.queueServerWork(27, () -> {
							if (entity.isAlive()) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 0, false, false));
							}
						});
						CatastropheModMod.queueServerWork(48, () -> {
							if (entity.isAlive()) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12, 255, false, false));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:seismic_slam")), SoundSource.HOSTILE, 2,
												1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY() + 2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:seismic_slam")), SoundSource.HOSTILE, 2, 1, false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_shockwave")),
												SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:surge_breaker_shockwave")), SoundSource.HOSTILE, 1,
												(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/photon fx photon:electrified_shockwave block ~0.5 ~ ~0.5");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/photon fx photon:electrified_impact block ~0.5 ~ ~0.5");
								{
									final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										{
											double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 3;
											entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.intensity_timer = _setval;
												capability.syncPlayerVariables(entityiterator);
											});
										}
										{
											double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 60;
											entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.screenshake_time = _setval;
												capability.syncPlayerVariables(entityiterator);
											});
										}
									}
								}
								{
									final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												if (entityiterator.getY() == entity.getY()) {
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
								{
									final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity), 15);
												entityiterator.setDeltaMovement(new Vec3((1.5 * entity.getLookAngle().x), 0.3, (1.5 * entity.getLookAngle().z)));
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(60, () -> {
							if (entity.isAlive()) {
								entity.getPersistentData().putBoolean("seismicslamcooldown", false);
							}
						});
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("stormsmith_ai", (entity.getPersistentData().getDouble("stormsmith_ai") - 1));
		}
	}
}

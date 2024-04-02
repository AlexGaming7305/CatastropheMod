package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.WraithSparksProjectileEntity;
import net.mcreator.catastrophemod.entity.SwordspinEntity;
import net.mcreator.catastrophemod.entity.MineralWraithEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class MineralWrathOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.DASH_COOLDOWN.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.DASH_COOLDOWN.get(), 1000000, 0, false, false));
			entity.getPersistentData().putDouble("phase1", 105);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(CatastropheModModMobEffects.ELECTRIFIED.get());
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 100) {
				entity.getPersistentData().putBoolean("Phase2", true);
				entity.getPersistentData().putDouble("timer", 180);
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if (entity.getPersistentData().getDouble("phase1") == 130) {
				entity.getPersistentData().putDouble("phase1", 0);
				if (entity.isAlive()) {
					if (entity.getPersistentData().getBoolean("Phase2") == false) {
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("empty");
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity instanceof MineralWraithEntity) {
								((MineralWraithEntity) entity).setAnimation("cast_electric_sparks");
							}
							CatastropheModMod.queueServerWork(15, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_claps")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_claps")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 5, 0);
									_entityToSpawn.setPos(x, (y + 2), z);
									_entityToSpawn.shoot(0, 4, 0, 1, 10);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 5, 0);
									_entityToSpawn.setPos(x, (y + 2), z);
									_entityToSpawn.shoot(0, 4, 0, 1, 10);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 5, 0);
									_entityToSpawn.setPos(x, (y + 2), z);
									_entityToSpawn.shoot(0, 4, 0, 1, 10);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							});
						});
					}
				}
				CatastropheModMod.queueServerWork(35, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (entity instanceof MineralWraithEntity) {
								((MineralWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								CatastropheModMod.queueServerWork(10, () -> {
									if (entity instanceof MineralWraithEntity) {
										((MineralWraithEntity) entity).setAnimation("punch");
									}
								});
								CatastropheModMod.queueServerWork(20, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrical_surge")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrical_surge")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 10, 0, false, false));
								});
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon catastrophe_mod:wraith_dash");
									}
								}
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"particle catastrophe_mod:dash_indicator ~ ~1 ~");
									}
								}
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(75, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (entity instanceof MineralWraithEntity) {
								((MineralWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (!world.getEntitiesOfClass(SwordspinEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
									if (entity instanceof MineralWraithEntity) {
										((MineralWraithEntity) entity).setAnimation("throw_sword_orbit");
									}
									CatastropheModMod.queueServerWork(30, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									});
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = CatastropheModModEntities.SWORD_DASH.get().spawn(_level,
												new BlockPos(
														entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX(),
														world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z),
														entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									{
										Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null));
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"particle catastrophe_mod:dash_indicator ~ ~1 ~");
										}
									}
								}
								if (!world.getEntitiesOfClass(SwordspinEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty() == false) {
									if (entity instanceof MineralWraithEntity) {
										((MineralWraithEntity) entity).setAnimation("throw_sword_orbit");
									}
									CatastropheModMod.queueServerWork(30, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
														AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														entityToSpawn.setKnockback(knockback);
														entityToSpawn.setSilent(true);
														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 0);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 10);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
														AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														entityToSpawn.setKnockback(knockback);
														entityToSpawn.setSilent(true);
														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 0);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 10);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
														AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														entityToSpawn.setKnockback(knockback);
														entityToSpawn.setSilent(true);
														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 0);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 10);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									});
								}
							});
						}
					}
				});
			} else {
				entity.getPersistentData().putDouble("phase1", (entity.getPersistentData().getDouble("phase1") + 1));
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == true) {
			if (entity.getPersistentData().getDouble("timer") == 180) {
				entity.getPersistentData().putDouble("timer", 0);
				if (entity.isAlive()) {
					if (entity.getPersistentData().getBoolean("Phase2") == true) {
						if (entity instanceof MineralWraithEntity) {
							((MineralWraithEntity) entity).setAnimation("empty");
						}
						CatastropheModMod.queueServerWork(1, () -> {
							CatastropheModMod.queueServerWork(10, () -> {
								if (entity instanceof MineralWraithEntity) {
									((MineralWraithEntity) entity).setAnimation("punch");
								}
							});
							CatastropheModMod.queueServerWork(20, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrical_surge")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrical_surge")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 10, 0, false, false));
							});
							{
								Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null));
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon catastrophe_mod:wraith_dash");
								}
							}
							{
								Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null));
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle catastrophe_mod:dash_indicator ~ ~1 ~");
								}
							}
						});
					}
				}
				CatastropheModMod.queueServerWork(50, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (entity instanceof MineralWraithEntity) {
								((MineralWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof MineralWraithEntity) {
									((MineralWraithEntity) entity).setAnimation("cast_electric_sparks");
								}
								CatastropheModMod.queueServerWork(15, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_claps")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_claps")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 5, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 2), (entity.getZ()));
										_entityToSpawn.shoot(0, 4, 0, 1, 10);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 5, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 2), (entity.getZ()));
										_entityToSpawn.shoot(0, 4, 0, 1, 10);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new WraithSparksProjectileEntity(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 5, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 2), (entity.getZ()));
										_entityToSpawn.shoot(0, 4, 0, 1, 10);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								});
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(80, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (entity instanceof MineralWraithEntity) {
								((MineralWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FLASH, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 2, 2, 2, 0);
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof Player) {
											{
												Entity _ent = entity;
												_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 6), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 6), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
										}
										CatastropheModMod.queueServerWork(20, () -> {
											if (entity instanceof MineralWraithEntity) {
												((MineralWraithEntity) entity).setAnimation("lightning_slam");
											}
											entity.setDeltaMovement(new Vec3(0, (-0.7), 0));
											CatastropheModMod.queueServerWork(10, () -> {
												if (world instanceof ServerLevel _level) {
													LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
													entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), entity.getZ())));;
													_level.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
													entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), entity.getZ())));;
													_level.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
													entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), entity.getZ())));;
													_level.addFreshEntity(entityToSpawn);
												}
											});
										});
									}
								}
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(120, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (entity instanceof MineralWraithEntity) {
								((MineralWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof MineralWraithEntity) {
									((MineralWraithEntity) entity).setAnimation("cast_lightning_sphere");
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_whispers")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mineral_wraith_whispers")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								CatastropheModMod.queueServerWork(20, () -> {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX() + 6), (entity.getY()), (entity.getZ()), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX() + -6), (entity.getY()), (entity.getZ()), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX()), (entity.getY()), (entity.getZ() + 6), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX()), (entity.getY()), (entity.getZ() + -6), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX() + 4), (entity.getY()), (entity.getZ() + 4), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX() + -4), (entity.getY()), (entity.getZ() + -4), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX() + 4), (entity.getY()), (entity.getZ() + -4), 1, 0, 0, 0, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DASH_INDICATOR.get()), (entity.getX() + -4), (entity.getY()), (entity.getZ() + 4), 1, 0, 0, 0, 0);
								});
								CatastropheModMod.queueServerWork(50, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + 6, entity.getY(), entity.getZ())));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + -6, entity.getY(), entity.getZ())));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 6)));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + -6)));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + 4, entity.getY(), entity.getZ() + 4)));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + -4, entity.getY(), entity.getZ() + -4)));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + 4, entity.getY(), entity.getZ() + -4)));;
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX() + -4, entity.getY(), entity.getZ() + 4)));;
										_level.addFreshEntity(entityToSpawn);
									}
								});
							});
						}
					}
				});
			} else {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
		}
		entity.getPersistentData().putBoolean("activate", true);
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NettleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("nettleai") == 210) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("nettleai", 0);
			if (entity.isAlive()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
				if (entity instanceof NettleEntity) {
					((NettleEntity) entity).setAnimation("empty");
				}
				CatastropheModMod.queueServerWork(1, () -> {
					if (entity instanceof NettleEntity) {
						((NettleEntity) entity).setAnimation("animation.nettle.cast_thorn_spear");
					}
					CatastropheModMod.queueServerWork(10, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 12, 0);
							_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
							_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 12, 0);
							_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
							_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 15 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 15)) * 1.5), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 12, 0);
							_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
							_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 15 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 15)) * 1.5), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					});
				});
			}
			CatastropheModMod.queueServerWork(50, () -> {
				if (entity.isAlive()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
					if (entity instanceof NettleEntity) {
						((NettleEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof NettleEntity) {
							((NettleEntity) entity).setAnimation("animation.nettle.cast_thorn_rain");
						}
						CatastropheModMod.queueServerWork(10, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot())) * 1.5), 1, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot())) * 1.5), (float) 0.8, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot())) * 1.5), (float) 0.5, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 2 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() + 2)) * 1.5), 1, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 2 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() - 2)) * 1.5), (float) 0.8, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 2 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() - 2)) * 1.5), (float) 0.5, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 4 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() + 4)) * 1.5), 1, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 4 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() - 4)) * 1.5), (float) 0.8, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 4 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() - 4)) * 1.5), (float) 0.5, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 6 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() + 6)) * 1.5), 1, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 6 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() - 6)) * 1.5), (float) 0.8, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TinyThornProjectileEntity(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 8, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 6 + 180)) * 1.5), 4, (Math.cos(Math.toRadians(entity.getYRot() - 6)) * 1.5), (float) 0.5, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						});
					});
				}
			});
			CatastropheModMod.queueServerWork(90, () -> {
				if (entity.isAlive()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
					if (entity instanceof NettleEntity) {
						((NettleEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof NettleEntity) {
							((NettleEntity) entity).setAnimation("animation.nettle.cast_thorn_spear");
						}
						CatastropheModMod.queueServerWork(10, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(5, 0, 0, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((-5), 0, 0, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(0, 0, 5, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(0, 0, (-5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						});
					});
				}
			});
			CatastropheModMod.queueServerWork(130, () -> {
				if (entity.isAlive()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
					if (entity instanceof NettleEntity) {
						((NettleEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof NettleEntity) {
							((NettleEntity) entity).setAnimation("animation.nettle.cast_thorn_spear");
						}
						CatastropheModMod.queueServerWork(10, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(5, 0, 5, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((-5), 0, (-5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((-5), 0, 5, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(5, 0, (-5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						});
					});
				}
			});
			CatastropheModMod.queueServerWork(170, () -> {
				if (entity.isAlive()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
					if (entity instanceof NettleEntity) {
						((NettleEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof NettleEntity) {
							((NettleEntity) entity).setAnimation("animation.nettle.cast_thorn_spear");
						}
						CatastropheModMod.queueServerWork(10, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(5, 0, 0, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((-5), 0, 0, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(0, 0, 5, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(0, 0, (-5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(5, 0, 5, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((-5), 0, (-5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((-5), 0, 5, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new ThornSpearProjectileProjectileEntity(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 14, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot(5, 0, (-5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						});
					});
				}
			});
		} else {
			entity.getPersistentData().putDouble("nettleai", (entity.getPersistentData().getDouble("nettleai") + 1));
		}
	}
}

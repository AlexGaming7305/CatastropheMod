package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NettleMinionOnEntityTickUpdateProcedure {
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
		if (entity.getPersistentData().getDouble("nettleai") == 60) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("nettleai", 0);
			if (entity.isAlive()) {
				if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).isEmpty()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
					if (entity instanceof NettleMinionEntity) {
						((NettleMinionEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof NettleMinionEntity) {
							((NettleMinionEntity) entity).setAnimation("animation.nettle.cast_thorn_spear");
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
										AbstractArrow entityToSpawn = new FriendlyPoisonousThornProjectileEntity(CatastropheModModEntities.FRIENDLY_POISONOUS_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 7, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 5 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 5)) * 1.5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new FriendlyPoisonousThornProjectileEntity(CatastropheModModEntities.FRIENDLY_POISONOUS_THORN_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 7, 0);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 5 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 5)) * 1.5), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						});
					});
				}
			}
			CatastropheModMod.queueServerWork(30, () -> {
				if (entity.isAlive()) {
					if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 25, 25, 25), e -> true).isEmpty()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
						if (entity instanceof NettleMinionEntity) {
							((NettleMinionEntity) entity).setAnimation("empty");
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity instanceof NettleMinionEntity) {
								((NettleMinionEntity) entity).setAnimation("animation.nettle.cast_thorn_spear");
							}
							CatastropheModMod.queueServerWork(10, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
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
										}.getArrow(projectileLevel, entity, 8, 0, (byte) 1);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							});
						});
					}
				}
			});
		} else {
			entity.getPersistentData().putDouble("nettleai", (entity.getPersistentData().getDouble("nettleai") + 1));
		}
	}
}

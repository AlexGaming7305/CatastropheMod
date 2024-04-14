package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class BlazingPhoenixOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("timer") == 65) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("timer", 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
						if ((entityiterator == entity) == false) {
							if (entityiterator instanceof Player) {
								entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
							}
						}
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.flap")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.flap")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			CatastropheModMod.queueServerWork(20, () -> {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
					if (entity instanceof BlazingPhoenixEntity) {
						((BlazingPhoenixEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof BlazingPhoenixEntity) {
							((BlazingPhoenixEntity) entity).setAnimation("animation.blazing_phoenix.idle");
						}
						CatastropheModMod.queueServerWork(20, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new BlazingFeatherProjectileEntity(CatastropheModModEntities.BLAZING_FEATHER_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 10, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5), (float) 1.5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new BlazingFeatherProjectileEntity(CatastropheModModEntities.BLAZING_FEATHER_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 10, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 5 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 5)) * 1.5), (float) 1.5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new BlazingFeatherProjectileEntity(CatastropheModModEntities.BLAZING_FEATHER_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 10, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 10 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 10)) * 1.5), (float) 1.5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new BlazingFeatherProjectileEntity(CatastropheModModEntities.BLAZING_FEATHER_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 10, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 5 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 5)) * 1.5), (float) 1.5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new BlazingFeatherProjectileEntity(CatastropheModModEntities.BLAZING_FEATHER_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 10, 0, (byte) 1);
								_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 10 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 10)) * 1.5), (float) 1.5, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						});
						CatastropheModMod.queueServerWork(40, () -> {
							if (entity instanceof BlazingPhoenixEntity) {
								((BlazingPhoenixEntity) entity).setAnimation("empty");
							}
						});
					});
				}
			});
		} else {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		}
	}
}

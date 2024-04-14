package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class EarthShattererProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new EarthboundRockShardProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_SHARD_PROJECTILE.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, sourceentity, 4, 0);
			_entityToSpawn.setPos((entity.getX()), y, (entity.getZ()));
			_entityToSpawn.shoot((Math.sin(Math.toRadians(sourceentity.getYRot() + 8 + 180)) * 1.5), (sourceentity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(sourceentity.getYRot() + 8)) * 1.5), 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new EarthboundRockShardProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_SHARD_PROJECTILE.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, sourceentity, 4, 0);
			_entityToSpawn.setPos((entity.getX()), y, (entity.getZ()));
			_entityToSpawn.shoot((Math.sin(Math.toRadians(sourceentity.getYRot() - 8 + 180)) * 1.5), (sourceentity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(sourceentity.getYRot() - 8)) * 1.5), 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.HOSTILE, 1, 1, false);
			}
		}
	}
}

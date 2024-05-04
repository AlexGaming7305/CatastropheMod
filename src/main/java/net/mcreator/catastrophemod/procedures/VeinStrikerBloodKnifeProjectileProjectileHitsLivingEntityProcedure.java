package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.BloodKnifeProjectileEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

public class VeinStrikerBloodKnifeProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.HOSTILE, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
					AbstractArrow entityToSpawn = new BloodKnifeProjectileEntity(CatastropheModModEntities.BLOOD_KNIFE_PROJECTILE.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					entityToSpawn.setPierceLevel(piercing);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, sourceentity, 3, 0, (byte) 2);
			_entityToSpawn.setPos((entity.getX() + 4), y, (entity.getZ() + 4));
			_entityToSpawn.shoot((-4), 0, (-4), 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
					AbstractArrow entityToSpawn = new BloodKnifeProjectileEntity(CatastropheModModEntities.BLOOD_KNIFE_PROJECTILE.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					entityToSpawn.setPierceLevel(piercing);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, sourceentity, 3, 0, (byte) 2);
			_entityToSpawn.setPos((entity.getX() + -4), y, (entity.getZ() + -4));
			_entityToSpawn.shoot(4, 0, 4, 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
					AbstractArrow entityToSpawn = new BloodKnifeProjectileEntity(CatastropheModModEntities.BLOOD_KNIFE_PROJECTILE.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					entityToSpawn.setPierceLevel(piercing);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, sourceentity, 3, 0, (byte) 2);
			_entityToSpawn.setPos((entity.getX() + -4), y, (entity.getZ() + 4));
			_entityToSpawn.shoot(4, 0, (-4), 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
					AbstractArrow entityToSpawn = new BloodKnifeProjectileEntity(CatastropheModModEntities.BLOOD_KNIFE_PROJECTILE.get(), level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					entityToSpawn.setPierceLevel(piercing);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, sourceentity, 3, 0, (byte) 2);
			_entityToSpawn.setPos((entity.getX() + 4), y, (entity.getZ() + -4));
			_entityToSpawn.shoot((-4), 0, 4, 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).veinstriker == false) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
			{
				boolean _setval = true;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.veinstriker = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			CatastropheModMod.queueServerWork(30, () -> {
				{
					boolean _setval = false;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.veinstriker = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}

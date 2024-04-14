package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AccursedTomeRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double choice = 0;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana > 5) {
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana - 6;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new AccursedDaggerEntity(CatastropheModModEntities.ACCURSED_DAGGER.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						entityToSpawn.setPierceLevel(piercing);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 2, 0, (byte) 1);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.2), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + Mth.nextInt(RandomSource.create(), 20, 40) + 180)) * 1.5), (entity.getXRot() * (-0.025)),
						(Math.cos(Math.toRadians(entity.getYRot() + Mth.nextInt(RandomSource.create(), 20, 40))) * 1.5), (float) 0.3, 5);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new AccursedDaggerEntity(CatastropheModModEntities.ACCURSED_DAGGER.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						entityToSpawn.setPierceLevel(piercing);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 2, 0, (byte) 1);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.2), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - Mth.nextInt(RandomSource.create(), 20, 40) + 180)) * 1.5), (entity.getXRot() * (-0.025)),
						(Math.cos(Math.toRadians(entity.getYRot() - Mth.nextInt(RandomSource.create(), 20, 40))) * 1.5), (float) 0.3, 5);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}

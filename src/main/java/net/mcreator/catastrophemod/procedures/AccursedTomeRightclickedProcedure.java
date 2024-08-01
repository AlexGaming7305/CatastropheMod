package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;
import net.mcreator.catastrophemod.entity.AccursedDaggerEntity;

public class AccursedTomeRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new CatastropheModModVariables.PlayerVariables())).Mana > (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).mana_cost_accursed_tome - 1) {
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana
						- (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).mana_cost_accursed_tome;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (15 - (15 * ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).getBaseValue()) / 100));
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

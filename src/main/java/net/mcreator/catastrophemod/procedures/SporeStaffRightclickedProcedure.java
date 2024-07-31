package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;
import net.mcreator.catastrophemod.entity.SporeProjectileEntity;

public class SporeStaffRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana > 9) {
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana - 10;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.shroomlight.place")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.shroomlight.place")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new SporeProjectileEntity(CatastropheModModEntities.SPORE_PROJECTILE.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 4, 0);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5), (float) 1.5, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new SporeProjectileEntity(CatastropheModModEntities.SPORE_PROJECTILE.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 4, 0);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 4 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 4)) * 1.5), (float) 1.45, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new SporeProjectileEntity(CatastropheModModEntities.SPORE_PROJECTILE.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 4, 0);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 8)) * 1.5), (float) 1.3, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new SporeProjectileEntity(CatastropheModModEntities.SPORE_PROJECTILE.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 4, 0);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 4 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 4)) * 1.5), (float) 1.45, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new SporeProjectileEntity(CatastropheModModEntities.SPORE_PROJECTILE.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity, 4, 0);
				_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
				_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 8)) * 1.5), (float) 1.3, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (20 - (20 * ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).getBaseValue()) / 100));
		}
	}
}

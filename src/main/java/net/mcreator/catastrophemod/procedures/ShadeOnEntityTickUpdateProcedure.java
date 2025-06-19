package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.ShadowFireballProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadeEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

public class ShadeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
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
		double range = 0;
		double blood_drop_range = 0;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("shadeai", 40);
		}
		if (entity.getPersistentData().getDouble("shadeai") == 0) {
			entity.getPersistentData().putDouble("shadeai", 100);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.isAlive()) {
					if (entity instanceof ShadeEntity) {
						((ShadeEntity) entity).setAnimation("animation.shade.cast");
					}
					CatastropheModMod.queueServerWork(8, () -> {
						if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
							if (entity.isAlive()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new ShadowFireballProjectileEntity(CatastropheModModEntities.SHADOW_FIREBALL_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 6, 0);
									_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
									_entityToSpawn.shoot(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()),
											(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1) - entity.getY()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()), 1, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					});
				}
			}
		} else {
			entity.getPersistentData().putDouble("shadeai", (entity.getPersistentData().getDouble("shadeai") - 1));
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 5, 0.2, 0.4, 0.2, 0);
	}
}

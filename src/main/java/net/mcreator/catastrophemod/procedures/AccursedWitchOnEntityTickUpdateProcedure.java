package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.AccursedWitchEntity;
import net.mcreator.catastrophemod.entity.AccursedSoulEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

public class AccursedWitchOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("witchai", 50);
		}
		if (entity.getPersistentData().getDouble("witchai") == 0) {
			entity.getPersistentData().putDouble("witchai", 50);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof AccursedWitchEntity) {
					((AccursedWitchEntity) entity).setAnimation("animation.accursed_witch.cast");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 255, false, false));
				CatastropheModMod.queueServerWork(30, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:haunted_mirror_shoot")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:haunted_mirror_shoot")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					for (int index0 = 0; index0 < 2; index0++) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new AccursedSoulEntity(CatastropheModModEntities.ACCURSED_SOUL.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 4, 0);
							_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.3), (entity.getZ()));
							_entityToSpawn.shoot(0, 4, 0, 1, 15);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				});
			}
		} else {
			entity.getPersistentData().putDouble("witchai", (entity.getPersistentData().getDouble("witchai") - 1));
		}
	}
}

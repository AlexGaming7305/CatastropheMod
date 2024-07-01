package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.ShadowFireSoulFriendlyProjectileEntity;
import net.mcreator.catastrophemod.entity.LifedrainArrowProjectileEntity;
import net.mcreator.catastrophemod.entity.IceShardProjectileEntity;
import net.mcreator.catastrophemod.entity.CrystalShardProjectileEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class BowDamageProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double damage = 0;
		Entity projectile = null;
		projectile = immediatesourceentity;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.STORM_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.STORM_BOW.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 1;
				event2.setAmount((float) damage);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 40, 0));
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.THORN_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.THORN_BOW.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 2;
				event2.setAmount((float) damage);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0));
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.NATURITE_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.NATURITE_BOW.get()) {
			if (projectile instanceof Projectile) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.NATURES_STRIKE.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.NATURES_STRIKE.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 2;
				event2.setAmount((float) damage);
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1));
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.SHADOWFLAME_WHISPER.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.SHADOWFLAME_WHISPER.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 2;
				event2.setAmount((float) damage);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
				if (Math.random() < 0.25) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.stray.death")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.stray.death")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new ShadowFireSoulFriendlyProjectileEntity(CatastropheModModEntities.SHADOW_FIRE_SOUL_FRIENDLY_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, 4, 0);
						_entityToSpawn.setPos(x, (y + 1), z);
						_entityToSpawn.shoot(2, 4, 0, (float) 0.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new ShadowFireSoulFriendlyProjectileEntity(CatastropheModModEntities.SHADOW_FIRE_SOUL_FRIENDLY_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, 4, 0);
						_entityToSpawn.setPos(x, (y + 1), z);
						_entityToSpawn.shoot((-2), 4, 0, (float) 0.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new ShadowFireSoulFriendlyProjectileEntity(CatastropheModModEntities.SHADOW_FIRE_SOUL_FRIENDLY_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, 4, 0);
						_entityToSpawn.setPos(x, (y + 1), z);
						_entityToSpawn.shoot(0, 4, 2, (float) 0.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new ShadowFireSoulFriendlyProjectileEntity(CatastropheModModEntities.SHADOW_FIRE_SOUL_FRIENDLY_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, 4, 0);
						_entityToSpawn.setPos(x, (y + 1), z);
						_entityToSpawn.shoot(0, 4, (-2), (float) 0.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.ICE_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.ICE_BOW.get()) {
			if (projectile instanceof Projectile) {
				if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).ice_bow_ready == true) {
					{
						boolean _setval = false;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ice_bow_load = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						boolean _setval = false;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ice_bow_ready = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						double _setval = 0;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ice_bow_charge = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:frost_blast")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:frost_blast")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					entity.setTicksFrozen(150);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SNOWFLAKE, x, (y + 15), z, 100, 1, 0.1, 1, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.BLIZZARD_WIND.get()), x, (y + 15), z, 75, 1, 0.1, 1, 0);
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new IceShardProjectileEntity(CatastropheModModEntities.ICE_SHARD_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, 1, 0);
						_entityToSpawn.setPos(x, (y + 15), z);
						_entityToSpawn.shoot((Mth.nextInt(RandomSource.create(), -3, 4)), (-5), (Mth.nextInt(RandomSource.create(), -3, 4)), 1, 5);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					CatastropheModMod.queueServerWork(5, () -> {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new IceShardProjectileEntity(CatastropheModModEntities.ICE_SHARD_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 1, 0);
							_entityToSpawn.setPos(x, (y + 15), z);
							_entityToSpawn.shoot((Mth.nextInt(RandomSource.create(), -3, 4)), (-5), (Mth.nextInt(RandomSource.create(), -3, 4)), 1, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					});
					CatastropheModMod.queueServerWork(10, () -> {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new IceShardProjectileEntity(CatastropheModModEntities.ICE_SHARD_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 1, 0);
							_entityToSpawn.setPos(x, (y + 15), z);
							_entityToSpawn.shoot((Mth.nextInt(RandomSource.create(), -3, 4)), (-5), (Mth.nextInt(RandomSource.create(), -3, 4)), 1, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					});
				}
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.SHROOM_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.SHROOM_BOW.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 2;
				event2.setAmount((float) damage);
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.AMATOXIN_GAS.get()), x, (y + 1), z, 100, 0, 0, 0, 0.2);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:amatoxin_gas")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:amatoxin_gas")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity && !(entityiterator instanceof ItemEntity) && !(entityiterator instanceof ExperienceOrb)) {
								if (!(entityiterator == sourceentity)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.AMATOXIN.get(), 100, 0));
								}
							}
						}
					}
				}
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.CRYSTAL_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.CRYSTAL_BOW.get()) {
			if (projectile instanceof Projectile) {
				if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).crystal_bow_ready == true) {
					{
						boolean _setval = false;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crystal_bow_load = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						boolean _setval = false;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crystal_bow_ready = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						double _setval = 0;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crystal_bow_charge = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:crystal_shatter")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:crystal_shatter")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), x, (y + 1.2), z, 40, 0.2, 0.2, 0.2, 2);
					CatastropheModMod.queueServerWork(10, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), x, (y + 1.2), z, 40, 0.2, 0.2, 0.2, 2);
					});
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_BLAST.get()), x, (y + 1.2), z, 1, 0, 0, 0, 0);
					for (int index0 = 0; index0 < 4; index0++) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new CrystalShardProjectileEntity(CatastropheModModEntities.CRYSTAL_SHARD_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 1, 0);
							_entityToSpawn.setPos((entity.getX()), (y + 1.2), (entity.getZ()));
							_entityToSpawn.shoot((sourceentity.getLookAngle().x * 1.5), (sourceentity.getLookAngle().y), (sourceentity.getLookAngle().z * 1.5), 3, 10);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.LIFEPIERCER.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.LIFEPIERCER.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 3;
				event2.setAmount((float) damage);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 100, 0));
				if (Math.random() < 0.25) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.BLOOD_DROP.get()), x, (y + 1), z, 100, 0, 0, 0, 0.4);
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new LifedrainArrowProjectileEntity(CatastropheModModEntities.LIFEDRAIN_ARROW_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, 7, 0);
						_entityToSpawn.setPos(x, (y + 1), z);
						_entityToSpawn.shoot(0, 4, 0, 1, 20);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.WOODEN_BOW.get()
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.WOODEN_BOW.get()) {
			if (projectile instanceof Projectile) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount - 1;
				event2.setAmount((float) damage);
			}
		}
	}
}

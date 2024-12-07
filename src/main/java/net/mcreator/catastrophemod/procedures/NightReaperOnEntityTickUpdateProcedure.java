package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NightReaperOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack axe = ItemStack.EMPTY;
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("nightreaperai", 55);
		}
		if (entity.getPersistentData().getDouble("nightreaperai") == 0) {
			entity.getPersistentData().putDouble("nightreaperai", 55);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() <= 4
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() <= 4
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() <= 4
						&& entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() >= -4
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= -4
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() >= -4) {
					if (entity instanceof NightReaperEntity) {
						((NightReaperEntity) entity).setAnimation("animation.night_reaper.double_slash");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 255, false, false));
					CatastropheModMod.queueServerWork(12, () -> {
					});
					CatastropheModMod.queueServerWork(14, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							entity.setDeltaMovement(new Vec3((0.5 * entity.getLookAngle().x), (0.1 * entity.getLookAngle().y), (0.5 * entity.getLookAngle().z)));
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											entityiterator.hurt(
													new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity),
													7);
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(32, () -> {
					});
					CatastropheModMod.queueServerWork(34, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							entity.setDeltaMovement(new Vec3((0.2 * entity.getLookAngle().x), (0.1 * entity.getLookAngle().y), (0.2 * entity.getLookAngle().z)));
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											entityiterator.hurt(
													new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity),
													7);
										}
									}
								}
							}
						}
					});
				} else {
					if (entity instanceof NightReaperEntity) {
						((NightReaperEntity) entity).setAnimation("animation.night_reaper.axe_throw");
					}
					CatastropheModMod.queueServerWork(11, () -> {
					});
					CatastropheModMod.queueServerWork(12, () -> {
						if (entity.isAlive()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 255, false, false));
							if (entity instanceof NightReaperEntity animatable)
								animatable.setTexture("night_reaper_axe_thrown");
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_throw")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_throw")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CatastropheModModEntities.NIGHTFALLS_DEMISE_PROJECTILE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(42, () -> {
						if (entity instanceof NightReaperEntity animatable)
							animatable.setTexture("night_reaper");
					});
				}
			}
		} else {
			entity.getPersistentData().putDouble("nightreaperai", (entity.getPersistentData().getDouble("nightreaperai") - 1));
		}
	}
}

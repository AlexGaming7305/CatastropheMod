package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FirebrandLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		entity.setSecondsOnFire(5);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = CatastropheModModEntities.FIREBRAND_SLASH.get().spawn(_level, BlockPos.containing(sourceentity.getX(), sourceentity.getY() + 1, sourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand == 0) {
			degree = Math.toRadians(sourceentity.getYRot());
			xRadius = 2;
			zRadius = 2;
			for (int index0 = 0; index0 < 36; index0++) {
				x_pos = sourceentity.getX() + Math.cos(degree) * xRadius;
				y_pos = sourceentity.getY() + 1;
				z_pos = sourceentity.getZ() + Math.sin(degree) * zRadius;
				{
					final Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(sourceentity == entityiterator)) {
							if (!(entityiterator instanceof ItemEntity && entityiterator instanceof ExperienceOrb)) {
								{
									DamageSource _damageSource = ((new Object() {
										public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
											return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
												@Override
												public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
													Component _attackerName = null;
													Component _entityName = _livingEntity.getDisplayName();
													Component _itemName = null;
													Entity _attacker = this.getEntity();
													ItemStack _itemStack = ItemStack.EMPTY;
													if (_attacker != null) {
														_attackerName = _attacker.getDisplayName();
													}
													if (_attacker instanceof LivingEntity _livingAttacker) {
														_itemStack = _livingAttacker.getMainHandItem();
													}
													if (!_itemStack.isEmpty() && _itemStack.hasCustomHoverName()) {
														_itemName = _itemStack.getDisplayName();
													}
													if (_attacker != null && _itemName != null) {
														return Component.translatable("death.attack." + _msgID + ".player.item", _entityName, _attackerName, _itemName);
													} else if (_attacker != null) {
														return Component.translatable("death.attack." + _msgID + ".player", _entityName, _attackerName);
													} else {
														return Component.translatable("death.attack." + _msgID, _entityName);
													}
												}

												@Override
												public String getMsgId() {
													return _msgID;
												}
											};
										}
									}).get(world, "sliced", sourceentity));
									if (_damageSource != null) {
										entityiterator.hurt(((new Object() {
											public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
												return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
													@Override
													public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
														Component _attackerName = null;
														Component _entityName = _livingEntity.getDisplayName();
														Component _itemName = null;
														Entity _attacker = this.getEntity();
														ItemStack _itemStack = ItemStack.EMPTY;
														if (_attacker != null) {
															_attackerName = _attacker.getDisplayName();
														}
														if (_attacker instanceof LivingEntity _livingAttacker) {
															_itemStack = _livingAttacker.getMainHandItem();
														}
														if (!_itemStack.isEmpty() && _itemStack.hasCustomHoverName()) {
															_itemName = _itemStack.getDisplayName();
														}
														if (_attacker != null && _itemName != null) {
															return Component.translatable("death.attack." + _msgID + ".player.item", _entityName, _attackerName, _itemName);
														} else if (_attacker != null) {
															return Component.translatable("death.attack." + _msgID + ".player", _entityName, _attackerName);
														} else {
															return Component.translatable("death.attack." + _msgID, _entityName);
														}
													}

													@Override
													public String getMsgId() {
														return _msgID;
													}
												};
											}
										}).get(world, "sliced", sourceentity)), 5);
									}
								}
								entityiterator.setSecondsOnFire(5);
							}
						}
					}
				}
				degree = degree + Math.toRadians(5);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			CatastropheModMod.queueServerWork(1, () -> {
				{
					double _setval = (sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand + 1;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firebrand = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			});
		}
		if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand == 1) {
			degree = Math.toRadians(sourceentity.getYRot());
			xRadius = 2;
			zRadius = 2;
			for (int index1 = 0; index1 < 36; index1++) {
				x_pos = sourceentity.getX() + Math.cos(degree) * xRadius;
				y_pos = sourceentity.getY() + 1;
				z_pos = sourceentity.getZ() + Math.sin(degree) * zRadius;
				{
					final Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(sourceentity == entityiterator)) {
							if (!(entityiterator instanceof ItemEntity && entityiterator instanceof ExperienceOrb)) {
								{
									DamageSource _damageSource = ((new Object() {
										public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
											return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
												@Override
												public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
													Component _attackerName = null;
													Component _entityName = _livingEntity.getDisplayName();
													Component _itemName = null;
													Entity _attacker = this.getEntity();
													ItemStack _itemStack = ItemStack.EMPTY;
													if (_attacker != null) {
														_attackerName = _attacker.getDisplayName();
													}
													if (_attacker instanceof LivingEntity _livingAttacker) {
														_itemStack = _livingAttacker.getMainHandItem();
													}
													if (!_itemStack.isEmpty() && _itemStack.hasCustomHoverName()) {
														_itemName = _itemStack.getDisplayName();
													}
													if (_attacker != null && _itemName != null) {
														return Component.translatable("death.attack." + _msgID + ".player.item", _entityName, _attackerName, _itemName);
													} else if (_attacker != null) {
														return Component.translatable("death.attack." + _msgID + ".player", _entityName, _attackerName);
													} else {
														return Component.translatable("death.attack." + _msgID, _entityName);
													}
												}

												@Override
												public String getMsgId() {
													return _msgID;
												}
											};
										}
									}).get(world, "sliced", sourceentity));
									if (_damageSource != null) {
										entityiterator.hurt(((new Object() {
											public DamageSource get(LevelAccessor _world, final String _msgID, Entity _directSource) {
												return new DamageSource(((Level) _world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS), _directSource) {
													@Override
													public Component getLocalizedDeathMessage(LivingEntity _livingEntity) {
														Component _attackerName = null;
														Component _entityName = _livingEntity.getDisplayName();
														Component _itemName = null;
														Entity _attacker = this.getEntity();
														ItemStack _itemStack = ItemStack.EMPTY;
														if (_attacker != null) {
															_attackerName = _attacker.getDisplayName();
														}
														if (_attacker instanceof LivingEntity _livingAttacker) {
															_itemStack = _livingAttacker.getMainHandItem();
														}
														if (!_itemStack.isEmpty() && _itemStack.hasCustomHoverName()) {
															_itemName = _itemStack.getDisplayName();
														}
														if (_attacker != null && _itemName != null) {
															return Component.translatable("death.attack." + _msgID + ".player.item", _entityName, _attackerName, _itemName);
														} else if (_attacker != null) {
															return Component.translatable("death.attack." + _msgID + ".player", _entityName, _attackerName);
														} else {
															return Component.translatable("death.attack." + _msgID, _entityName);
														}
													}

													@Override
													public String getMsgId() {
														return _msgID;
													}
												};
											}
										}).get(world, "sliced", sourceentity)), 5);
									}
								}
								entityiterator.setSecondsOnFire(5);
							}
						}
					}
				}
				degree = degree + Math.toRadians(5);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			CatastropheModMod.queueServerWork(1, () -> {
				{
					double _setval = (sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand + 1;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firebrand = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			});
		}
		if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand == 2) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.PLAYERS, 1, (float) 0.7);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.PLAYERS, 1, (float) 0.7, false);
				}
			}
			CatastropheModMod.queueServerWork(1, () -> {
				{
					double _setval = 0;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firebrand = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			});
		}
	}
}

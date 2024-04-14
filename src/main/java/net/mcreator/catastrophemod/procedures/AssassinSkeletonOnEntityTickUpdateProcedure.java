package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AssassinSkeletonOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack axe = ItemStack.EMPTY;
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("assassinai", 35);
		}
		if (entity.getPersistentData().getDouble("assassinai") == 0) {
			entity.getPersistentData().putDouble("assassinai", 35);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() <= 3
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() <= 3
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() <= 3
						&& entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() >= -3
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= -3
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() >= -3) {
					if (entity instanceof AssassinSkeletonEntity) {
						((AssassinSkeletonEntity) entity).setAnimation("animation.assassin_skeleton.attack");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 255, false, false));
					CatastropheModMod.queueServerWork(9, () -> {
					});
					CatastropheModMod.queueServerWork(10, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
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
											}).get(world, "sliced", entity));
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
												}).get(world, "sliced", entity)), 8);
											}
										}
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 60, 0));
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(19, () -> {
					});
					CatastropheModMod.queueServerWork(20, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_slash")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
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
											}).get(world, "sliced", entity));
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
												}).get(world, "sliced", entity)), 8);
											}
										}
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 60, 0));
									}
								}
							}
						}
					});
				}
			}
		} else {
			entity.getPersistentData().putDouble("assassinai", (entity.getPersistentData().getDouble("assassinai") - 1));
		}
	}
}

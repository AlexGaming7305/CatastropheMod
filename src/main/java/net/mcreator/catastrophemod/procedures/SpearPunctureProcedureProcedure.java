package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpearPunctureProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		Entity entity = event.getEntity();
		if (event != null && entity != null) {
			execute(event, entity.level(), entity.getX(), entity.getY(), entity.getZ(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double pin_point_distance = 0;
		double damage = 0;
		if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).spear_pin_point_strike_cooldown == false) {
			{
				boolean _setval = true;
				sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.spear_pin_point_strike_cooldown = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			CatastropheModMod.queueServerWork(15, () -> {
				{
					boolean _setval = false;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spear_pin_point_strike_cooldown = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			});
			if (sourceentity.isSprinting() && sourceentity.onGround()) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:spears")))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:spear_pin_point")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:spear_pin_point")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					for (int index0 = 0; index0 < 5; index0++) {
						pin_point_distance = pin_point_distance + 1;
						{
							final Vec3 _center = new Vec3(
									(sourceentity.level()
											.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(pin_point_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
													sourceentity))
											.getBlockPos().getX()),
									(sourceentity.level()
											.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(pin_point_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
													sourceentity))
											.getBlockPos().getY()),
									(sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(pin_point_distance)), ClipContext.Block.OUTLINE,
											ClipContext.Fluid.NONE, sourceentity)).getBlockPos().getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity) {
									if (!(sourceentity == entityiterator)) {
										LivingHurtEvent event2 = (LivingHurtEvent) event;
										damage = amount;
										event2.setAmount((float) damage);
										if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.IMPALEMENT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
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
												}).get(world, "impaled", sourceentity));
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
													}).get(world, "impaled", sourceentity)), (float) (amount
															+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.IMPALEMENT.get()) / 2 + 0.5));
												}
											}
										} else {
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
												}).get(world, "impaled", sourceentity));
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
													}).get(world, "impaled", sourceentity)), (float) amount);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

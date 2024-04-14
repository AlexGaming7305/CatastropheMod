package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ThornInfestedArmorOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity projectile = null;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.DASH_COOLDOWN.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.DASH_COOLDOWN.get(), 1000000, 0, false, false));
			entity.getPersistentData().putDouble("phase1", 60);
		}
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 200) {
				entity.getPersistentData().putBoolean("Phase2", true);
				entity.getPersistentData().putDouble("timer", 140);
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if (entity.getPersistentData().getDouble("phase1") == 90) {
				entity.getPersistentData().putDouble("phase1", 0);
				if (entity.isAlive()) {
					if (entity.getPersistentData().getBoolean("Phase2") == false) {
						if (entity instanceof ThornInfestedArmorEntity) {
							((ThornInfestedArmorEntity) entity).setAnimation("empty");
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.axe_swing");
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
							CatastropheModMod.queueServerWork(13, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.HOSTILE, 1, 1, false);
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
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												if (entityiterator instanceof LivingEntity _entity)
													_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
														@Override
														public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
															String _translatekey = "death.attack." + "sliced";
															if (this.getEntity() == null && this.getDirectEntity() == null) {
																return _msgEntity.getKillCredit() != null
																		? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
																		: Component.translatable(_translatekey, _msgEntity.getDisplayName());
															} else {
																Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
																ItemStack _itemstack = ItemStack.EMPTY;
																if (this.getEntity() instanceof LivingEntity _livingentity)
																	_itemstack = _livingentity.getMainHandItem();
																return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
																		? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
																		: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
															}
														}
													}, 15);
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 200, 0));
											}
										}
									}
								}
							});
						});
					}
				}
				CatastropheModMod.queueServerWork(30, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof ThornInfestedArmorEntity) {
									((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.dash");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
								CatastropheModMod.queueServerWork(10, () -> {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 10, 0, true, false));
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")),
													SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")), SoundSource.HOSTILE, 1,
													1, false);
										}
									}
								});
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon catastrophe_mod:tia_dash");
									}
								}
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"particle catastrophe_mod:dash_indicator ~ ~1 ~");
									}
								}
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(60, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof ThornInfestedArmorEntity) {
									((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.vine_attack");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
								CatastropheModMod.queueServerWork(15, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entityiterator instanceof LivingEntity) {
													if (entityiterator instanceof LivingEntity _entity)
														_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
															@Override
															public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
																String _translatekey = "death.attack." + "impaled";
																if (this.getEntity() == null && this.getDirectEntity() == null) {
																	return _msgEntity.getKillCredit() != null
																			? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
																			: Component.translatable(_translatekey, _msgEntity.getDisplayName());
																} else {
																	Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
																	ItemStack _itemstack = ItemStack.EMPTY;
																	if (this.getEntity() instanceof LivingEntity _livingentity)
																		_itemstack = _livingentity.getMainHandItem();
																	return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
																			? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
																			: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
																}
															}
														}, 13);
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
												}
											}
										}
									}
									if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty() == false) {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
											_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 8)) * 1.5), (float) 0.7, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
											_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 8)) * 1.5), (float) 0.7, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								});
							});
						}
					}
				});
			} else {
				entity.getPersistentData().putDouble("phase1", (entity.getPersistentData().getDouble("phase1") + 1));
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == true) {
			if (entity.getPersistentData().getDouble("timer") == 140) {
				entity.getPersistentData().putDouble("timer", 0);
				if (entity.isAlive()) {
					if (entity.getPersistentData().getBoolean("Phase2") == true) {
						if (entity instanceof ThornInfestedArmorEntity) {
							((ThornInfestedArmorEntity) entity).setAnimation("empty");
						}
						CatastropheModMod.queueServerWork(1, () -> {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.vine_swing");
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
							CatastropheModMod.queueServerWork(13, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.HOSTILE, 1, 1, false);
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
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												if (entityiterator instanceof LivingEntity _entity)
													_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
														@Override
														public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
															String _translatekey = "death.attack." + "sliced";
															if (this.getEntity() == null && this.getDirectEntity() == null) {
																return _msgEntity.getKillCredit() != null
																		? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
																		: Component.translatable(_translatekey, _msgEntity.getDisplayName());
															} else {
																Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
																ItemStack _itemstack = ItemStack.EMPTY;
																if (this.getEntity() instanceof LivingEntity _livingentity)
																	_itemstack = _livingentity.getMainHandItem();
																return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
																		? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
																		: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
															}
														}
													}, 15);
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 200, 0));
											}
										}
									}
								}
							});
							CatastropheModMod.queueServerWork(15, () -> {
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity) {
												if (entityiterator instanceof LivingEntity _entity)
													_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
														@Override
														public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
															String _translatekey = "death.attack." + "impaled";
															if (this.getEntity() == null && this.getDirectEntity() == null) {
																return _msgEntity.getKillCredit() != null
																		? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
																		: Component.translatable(_translatekey, _msgEntity.getDisplayName());
															} else {
																Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
																ItemStack _itemstack = ItemStack.EMPTY;
																if (this.getEntity() instanceof LivingEntity _livingentity)
																	_itemstack = _livingentity.getMainHandItem();
																return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
																		? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
																		: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
															}
														}
													}, 13);
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
											}
										}
									}
								}
								if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty() == false) {
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 15, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
										_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 8)) * 1.5), (float) 0.7, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 15, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
										_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 8)) * 1.5), (float) 0.7, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							});
						});
					}
				}
				CatastropheModMod.queueServerWork(30, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof ThornInfestedArmorEntity) {
									((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.vine_attack");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
								CatastropheModMod.queueServerWork(15, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									{
										final Vec3 _center = new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entityiterator instanceof LivingEntity) {
													if (entityiterator instanceof LivingEntity _entity)
														_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
															@Override
															public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
																String _translatekey = "death.attack." + "impaled";
																if (this.getEntity() == null && this.getDirectEntity() == null) {
																	return _msgEntity.getKillCredit() != null
																			? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
																			: Component.translatable(_translatekey, _msgEntity.getDisplayName());
																} else {
																	Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
																	ItemStack _itemstack = ItemStack.EMPTY;
																	if (this.getEntity() instanceof LivingEntity _livingentity)
																		_itemstack = _livingentity.getMainHandItem();
																	return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
																			? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
																			: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
																}
															}
														}, 13);
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
												}
											}
										}
									}
									if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty() == false) {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
											_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() + 8)) * 1.5), (float) 0.7, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
													AbstractArrow entityToSpawn = new PoisonousThornProjectileEntity(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
											_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() - 8 + 180)) * 1.5), (entity.getXRot() * (-0.025)), (Math.cos(Math.toRadians(entity.getYRot() - 8)) * 1.5), (float) 0.7, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
								});
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(60, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof ThornInfestedArmorEntity) {
									((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.dash");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, false, false));
								CatastropheModMod.queueServerWork(10, () -> {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 10, 0, true, false));
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")),
													SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorn_infested_armor_dashes")), SoundSource.HOSTILE, 1,
													1, false);
										}
									}
								});
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon catastrophe_mod:tia_dash");
									}
								}
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"particle catastrophe_mod:dash_indicator ~ ~1 ~");
									}
								}
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(90, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (entity instanceof ThornInfestedArmorEntity) {
								((ThornInfestedArmorEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof ThornInfestedArmorEntity) {
									((ThornInfestedArmorEntity) entity).setAnimation("animation.thorn_infested_armor.thorn_tentacles");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 255, false, false));
								CatastropheModMod.queueServerWork(10, () -> {
									{
										final Vec3 _center = new Vec3(x, y, z);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												{
													Entity _ent = entityiterator;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																"summon catastrophe_mod:thorn_tentacle");
													}
												}
												CatastropheModMod.queueServerWork(5, () -> {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")),
																	SoundSource.HOSTILE, 1, 1);
														} else {
															_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1,
																	1, false);
														}
													}
												});
											}
										}
									}
								});
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof Player) {
											{
												Entity _ent = entityiterator;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															"particle catastrophe_mod:dash_indicator ~ ~1 ~");
												}
											}
										}
									}
								}
							});
						}
					}
					CatastropheModMod.queueServerWork(20, () -> {
						if (entity.isAlive()) {
							if (entity.getPersistentData().getBoolean("Phase2") == true) {
								CatastropheModMod.queueServerWork(10, () -> {
									{
										final Vec3 _center = new Vec3(x, y, z);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												{
													Entity _ent = entityiterator;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																"summon catastrophe_mod:thorn_tentacle");
													}
												}
												CatastropheModMod.queueServerWork(5, () -> {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")),
																	SoundSource.HOSTILE, 1, 1);
														} else {
															_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.HOSTILE, 1,
																	1, false);
														}
													}
												});
											}
										}
									}
								});
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof Player) {
											{
												Entity _ent = entityiterator;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															"particle catastrophe_mod:dash_indicator ~ ~1 ~");
												}
											}
										}
									}
								}
							}
						}
					});
				});
			} else {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
		}
		entity.getPersistentData().putBoolean("activate", true);
	}
}

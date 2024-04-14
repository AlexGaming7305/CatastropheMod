package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class EarthboundWraithOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.DASH_COOLDOWN.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.DASH_COOLDOWN.get(), 1000000, 0, false, false));
			entity.getPersistentData().putDouble("phase1", 110);
		}
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 150) {
				entity.getPersistentData().putBoolean("Phase2", true);
				CatastropheModMod.queueServerWork(10, () -> {
					entity.getPersistentData().putDouble("timer", 270);
				});
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == false) {
			if (entity.getPersistentData().getDouble("phase1") == 120) {
				entity.getPersistentData().putDouble("phase1", 0);
				if (entity.isAlive()) {
					if (entity.getPersistentData().getBoolean("Phase2") == false) {
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
							if (entity instanceof EarthboundWraithEntity) {
								((EarthboundWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_upwards");
								}
								CatastropheModMod.queueServerWork(10, () -> {
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
														}, 10);
												}
											}
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
													entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.2), 1.3, (Math.cos(Math.toRadians(entity.getYRot())) * 0.2)));
												}
											}
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.08), 0.3, ((entityiterator.getZ() - entity.getZ()) * 0.08)));
											}
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
								});
							});
						}
					}
				}
				CatastropheModMod.queueServerWork(25, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_downwards");
									}
									CatastropheModMod.queueServerWork(10, () -> {
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
															}, 10);
														entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), (-1.5), (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_slams")), SoundSource.HOSTILE, 1,
																		(float) 0.5);
															} else {
																_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_slams")), SoundSource.HOSTILE, 1, (float) 0.5, false);
															}
														}
													}
												}
											}
										}
										{
											final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if (entityiterator instanceof Player) {
													entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.08), (-0.9), ((entityiterator.getZ() - entity.getZ()) * 0.08)));
												}
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
											}
										}
									});
									CatastropheModMod.queueServerWork(18, () -> {
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
															}, 10);
													}
												}
											}
										}
									});
								});
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(50, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.double_punch");
									}
									CatastropheModMod.queueServerWork(10, () -> {
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
															}, 12);
														entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.2), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 1.2)));
													}
												}
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
											}
										}
									});
								});
								CatastropheModMod.queueServerWork(20, () -> {
									CatastropheModMod.queueServerWork(5, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
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
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
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
															}, 12);
													}
												}
											}
										}
									});
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
											}
										}
									}
									CatastropheModMod.queueServerWork(10, () -> {
										{
											final Vec3 _center = new Vec3(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
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
															}, 12);
													}
												}
											}
										}
									});
								});
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(90, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == false) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_barrage");
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 20, 0, false, false));
								});
							}
						}
					}
				});
			} else {
				entity.getPersistentData().putDouble("phase1", (entity.getPersistentData().getDouble("phase1") + 1));
			}
		}
		if (entity.getPersistentData().getBoolean("Phase2") == true) {
			if (entity.getPersistentData().getDouble("timer") == 270) {
				entity.getPersistentData().putDouble("timer", 0);
				if (entity.isAlive()) {
					if (entity.getPersistentData().getBoolean("Phase2") == true) {
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
							if (entity instanceof EarthboundWraithEntity) {
								((EarthboundWraithEntity) entity).setAnimation("empty");
							}
							CatastropheModMod.queueServerWork(1, () -> {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_barrage");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 20, 0, false, false));
							});
						}
					}
				}
				CatastropheModMod.queueServerWork(30, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.double_punch");
									}
									CatastropheModMod.queueServerWork(10, () -> {
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
															}, 12);
														entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.2), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 1.2)));
													}
												}
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
											}
										}
									});
								});
								CatastropheModMod.queueServerWork(20, () -> {
									CatastropheModMod.queueServerWork(5, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
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
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
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
															}, 12);
													}
												}
											}
										}
									});
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
											}
										}
									}
									CatastropheModMod.queueServerWork(10, () -> {
										{
											final Vec3 _center = new Vec3(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
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
															}, 12);
													}
												}
											}
										}
									});
								});
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(70, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_upwards");
									}
									CatastropheModMod.queueServerWork(10, () -> {
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
															}, 10);
													}
												}
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
														entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.2), 1.3, (Math.cos(Math.toRadians(entity.getYRot())) * 0.2)));
													}
												}
											}
										}
										{
											final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if (entityiterator instanceof Player) {
													entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.08), 0.3, ((entityiterator.getZ() - entity.getZ()) * 0.08)));
												}
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
											}
										}
									});
								});
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(95, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_downwards");
									}
									CatastropheModMod.queueServerWork(10, () -> {
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
															}, 10);
														entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), (-1.5), (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_slams")), SoundSource.HOSTILE, 1,
																		(float) 0.5);
															} else {
																_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_slams")), SoundSource.HOSTILE, 1, (float) 0.5, false);
															}
														}
													}
												}
											}
										}
										{
											final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if (entityiterator instanceof Player) {
													entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.08), (-0.9), ((entityiterator.getZ() - entity.getZ()) * 0.08)));
												}
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_punches")), SoundSource.HOSTILE, 1, 1, false);
											}
										}
									});
									CatastropheModMod.queueServerWork(18, () -> {
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
															}, 10);
													}
												}
											}
										}
									});
								});
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(120, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									if (entity instanceof EarthboundWraithEntity) {
										((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.punch_barrage");
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BOSS_DASH.get(), 20, 0, false, false));
								});
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(150, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.15), (((entityiterator.getY() + 6) - entity.getY()) * 0.15), ((entityiterator.getZ() - entity.getZ()) * 0.15)));
											}
										}
									}
								});
								CatastropheModMod.queueServerWork(10, () -> {
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(0, (-0.7), 0));
											}
										}
									}
								});
								CatastropheModMod.queueServerWork(25, () -> {
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(5, 3, 0, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot((-5), 3, 0, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(0, 3, 5, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(0, 3, (-5), (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_groundpounds")),
													SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_groundpounds")), SoundSource.HOSTILE,
													1, 1, false);
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity && !(entityiterator instanceof EarthShockwaveEntity)) {
												entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 15);
												entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entityiterator.getYRot() + 180)) * (-1)), 0.5, (Math.cos(Math.toRadians(entityiterator.getYRot())) * (-1))));
											}
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											{
												double _setval = 3;
												entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.intensity_timer = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
											}
											{
												boolean _setval = true;
												entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.screenshake = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
											}
											CatastropheModMod.queueServerWork(5, () -> {
												{
													boolean _setval = false;
													entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.screenshake = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
												}
											});
										}
									}
								});
								CatastropheModMod.queueServerWork(25, () -> {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"summon catastrophe_mod:earth_shockwave ~ ~0.5 ~");
										}
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon catastrophe_mod:earth_shockwave ~ ~0.5 ~");
								});
							}
							CatastropheModMod.queueServerWork(10, () -> {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.ground_pound");
								}
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(190, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.15), (((entityiterator.getY() + 6) - entity.getY()) * 0.15), ((entityiterator.getZ() - entity.getZ()) * 0.15)));
											}
										}
									}
								});
								CatastropheModMod.queueServerWork(10, () -> {
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(0, (-0.7), 0));
											}
										}
									}
								});
								CatastropheModMod.queueServerWork(25, () -> {
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(5, 3, 0, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot((-5), 3, 0, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(0, 3, 5, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(0, 3, (-5), (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_groundpounds")),
													SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_groundpounds")), SoundSource.HOSTILE,
													1, 1, false);
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity && !(entityiterator instanceof EarthShockwaveEntity)) {
												entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 15);
												entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
											}
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											{
												double _setval = 3;
												entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.intensity_timer = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
											}
											{
												boolean _setval = true;
												entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.screenshake = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
											}
											CatastropheModMod.queueServerWork(5, () -> {
												{
													boolean _setval = false;
													entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.screenshake = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
												}
											});
										}
									}
								});
								CatastropheModMod.queueServerWork(25, () -> {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"summon catastrophe_mod:earth_shockwave ~ ~0.5 ~");
										}
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon catastrophe_mod:earth_shockwave ~ ~0.5 ~");
								});
							}
							CatastropheModMod.queueServerWork(10, () -> {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.ground_pound");
								}
							});
						}
					}
				});
				CatastropheModMod.queueServerWork(230, () -> {
					if (entity.isAlive()) {
						if (entity.getPersistentData().getBoolean("Phase2") == true) {
							if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("empty");
								}
								CatastropheModMod.queueServerWork(1, () -> {
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.15), (((entityiterator.getY() + 6) - entity.getY()) * 0.15), ((entityiterator.getZ() - entity.getZ()) * 0.15)));
											}
										}
									}
								});
								CatastropheModMod.queueServerWork(10, () -> {
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Player) {
												entity.setDeltaMovement(new Vec3(0, (-0.7), 0));
											}
										}
									}
								});
								CatastropheModMod.queueServerWork(25, () -> {
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(5, 3, 0, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot((-5), 3, 0, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(0, 3, 5, (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof ServerLevel projectileLevel) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
												AbstractArrow entityToSpawn = new EarthboundRockProjectileEntity(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 0);
										_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
										_entityToSpawn.shoot(0, 3, (-5), (float) 0.5, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_groundpounds")),
													SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:earthbound_wraith_groundpounds")), SoundSource.HOSTILE,
													1, 1, false);
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity && !(entityiterator instanceof EarthShockwaveEntity)) {
												entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 15);
												entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
											}
										}
									}
									{
										final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											{
												double _setval = 3;
												entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.intensity_timer = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
											}
											{
												boolean _setval = true;
												entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.screenshake = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
											}
											CatastropheModMod.queueServerWork(5, () -> {
												{
													boolean _setval = false;
													entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.screenshake = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
												}
											});
										}
									}
								});
								CatastropheModMod.queueServerWork(25, () -> {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"summon catastrophe_mod:earth_shockwave ~ ~0.5 ~");
										}
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon catastrophe_mod:earth_shockwave ~ ~0.5 ~");
								});
							}
							CatastropheModMod.queueServerWork(10, () -> {
								if (entity instanceof EarthboundWraithEntity) {
									((EarthboundWraithEntity) entity).setAnimation("animation.earthbound_wraith.ground_pound");
								}
							});
						}
					}
				});
			} else {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
		}
		entity.getPersistentData().putBoolean("activate", true);
	}
}

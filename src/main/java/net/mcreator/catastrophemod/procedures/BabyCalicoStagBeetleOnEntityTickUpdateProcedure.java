package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class BabyCalicoStagBeetleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		if (entity.getPersistentData().getDouble("calicobeetleai") == 120) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("calicobeetleai", 0);
			if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
				CatastropheModMod.queueServerWork(60, () -> {
					entity.setNoGravity(true);
					entity.setDeltaMovement(new Vec3(0, 0.15, 0));
				});
				CatastropheModMod.queueServerWork(80, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
										if (entity instanceof CalicoStagBeetleEntity) {
											((CalicoStagBeetleEntity) entity).setAnimation("animation.baby_calico_stag_beetle.attack_flying");
										}
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(85, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
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
											}, 6);
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(90, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
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
											}, 6);
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(95, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
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
											}, 6);
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(100, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
										if (entity instanceof CalicoStagBeetleEntity) {
											((CalicoStagBeetleEntity) entity).setAnimation("animation.baby_calico_stag_beetle.attack_flying");
										}
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(105, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
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
											}, 6);
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(110, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false) {
								if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
										&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))))) {
									if (entityiterator instanceof Monster) {
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
											}, 6);
										entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
									}
								}
							}
						}
					}
				});
				CatastropheModMod.queueServerWork(110, () -> {
					entity.setNoGravity(false);
				});
			}
		} else {
			entity.getPersistentData().putDouble("calicobeetleai", (entity.getPersistentData().getDouble("calicobeetleai") + 1));
		}
	}
}

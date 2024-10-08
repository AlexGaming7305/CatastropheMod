package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.entity.LightningBladeEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class LightningBladeOnEntityTickUpdateProcedure {
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
		if (entity.getPersistentData().getDouble("timer") == 50) {
			entity.getPersistentData().putBoolean("activate", true);
			if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
				if (entity instanceof LightningBladeEntity) {
					((LightningBladeEntity) entity).setAnimation("empty");
				}
				CatastropheModMod.queueServerWork(1, () -> {
					if (entity instanceof LightningBladeEntity) {
						((LightningBladeEntity) entity).setAnimation("animation.lightning_blade.slash_combo");
					}
					CatastropheModMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
									if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
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
											}, 3);
									}
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Monster == true) {
									if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))) == false
											&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons"))) == false) {
										if (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
											if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(8, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
									if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
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
											}, 3);
									}
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Monster == true) {
									if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))) == false
											&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons"))) == false) {
										if (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
											if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(12, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
									if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
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
											}, 3);
									}
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Monster == true) {
									if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))) == false
											&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons"))) == false) {
										if (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
											if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(16, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
									if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
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
											}, 3);
									}
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Monster == true) {
									if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))) == false
											&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons"))) == false) {
										if (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
											if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
												entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
											}
										}
									}
								}
							}
						}
					});
				});
			}
			CatastropheModMod.queueServerWork(28, () -> {
				if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
					if (entity instanceof LightningBladeEntity) {
						((LightningBladeEntity) entity).setAnimation("empty");
					}
					CatastropheModMod.queueServerWork(1, () -> {
						if (entity instanceof LightningBladeEntity) {
							((LightningBladeEntity) entity).setAnimation("animation.lightning_blade.dash");
						}
						CatastropheModMod.queueServerWork(3, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Monster == true) {
										if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons"))) == false
												&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons"))) == false) {
											if (entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
												if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
													entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.17), (((entityiterator.getY() + 1) - entity.getY()) * 0.17), ((entityiterator.getZ() - entity.getZ()) * 0.17)));
												}
											}
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(5, () -> {
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
										if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
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
												}, 3);
										}
									}
								}
							}
						});
						CatastropheModMod.queueServerWork(9, () -> {
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
										if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
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
												}, 3);
										}
									}
								}
							}
						});
					});
				}
			});
			entity.getPersistentData().putDouble("timer", 0);
		} else {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		}
	}
}

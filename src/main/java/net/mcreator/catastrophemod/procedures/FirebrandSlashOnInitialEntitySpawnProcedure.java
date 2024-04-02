package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.entity.FirebrandSlashEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class FirebrandSlashOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 255, false, false));
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
			if (entity instanceof TamableAnimal _toTame && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Player _owner)
				_toTame.tame(_owner);
		}
		entity.setNoGravity(true);
		{
			Entity _ent = entity;
			_ent.setYRot((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getYRot());
			_ent.setXRot((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getXRot());
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		if (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand == 0) {
			if (entity instanceof FirebrandSlashEntity) {
				((FirebrandSlashEntity) entity).setAnimation("animation.firebrand_slash.left");
			}
			CatastropheModMod.queueServerWork(1, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_0");
			});
			CatastropheModMod.queueServerWork(2, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_1");
			});
			CatastropheModMod.queueServerWork(3, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_2");
			});
			CatastropheModMod.queueServerWork(4, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_3");
			});
			CatastropheModMod.queueServerWork(5, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_4");
			});
			CatastropheModMod.queueServerWork(6, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_5");
			});
			CatastropheModMod.queueServerWork(7, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_6");
			});
			CatastropheModMod.queueServerWork(8, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_7");
			});
			CatastropheModMod.queueServerWork(9, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_8");
			});
			CatastropheModMod.queueServerWork(10, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_9");
			});
			CatastropheModMod.queueServerWork(11, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
		if (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand == 1) {
			if (entity instanceof FirebrandSlashEntity) {
				((FirebrandSlashEntity) entity).setAnimation("animation.firebrand_slash.right");
			}
			if (entity instanceof FirebrandSlashEntity animatable)
				animatable.setTexture("firebrand_slash_texture_right_0");
			CatastropheModMod.queueServerWork(1, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_0");
			});
			CatastropheModMod.queueServerWork(2, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_1");
			});
			CatastropheModMod.queueServerWork(3, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_2");
			});
			CatastropheModMod.queueServerWork(4, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_3");
			});
			CatastropheModMod.queueServerWork(5, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_4");
			});
			CatastropheModMod.queueServerWork(6, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_5");
			});
			CatastropheModMod.queueServerWork(7, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_6");
			});
			CatastropheModMod.queueServerWork(8, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_7");
			});
			CatastropheModMod.queueServerWork(9, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_8");
			});
			CatastropheModMod.queueServerWork(10, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_right_9");
			});
			CatastropheModMod.queueServerWork(11, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
		if (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).firebrand == 2) {
			CatastropheModMod.queueServerWork(10, () -> {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entityiterator)) {
							if (!(entity == entityiterator)) {
								if (!(entityiterator instanceof ItemEntity || entityiterator instanceof ExperienceOrb)) {
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
										}).get(world, "sliced", (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)));
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
											}).get(world, "sliced", (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))), 5);
										}
									}
									entityiterator.setSecondsOnFire(5);
								}
							}
						}
					}
				}
			});
			CatastropheModMod.queueServerWork(15, () -> {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entityiterator)) {
							if (!(entity == entityiterator)) {
								if (!(entityiterator instanceof ItemEntity || entityiterator instanceof ExperienceOrb)) {
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
										}).get(world, "sliced", (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)));
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
											}).get(world, "sliced", (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))), 5);
										}
									}
									entityiterator.setSecondsOnFire(5);
								}
							}
						}
					}
				}
			});
			if (entity instanceof FirebrandSlashEntity) {
				((FirebrandSlashEntity) entity).setAnimation("animation.firebrand_slash.spin");
			}
			CatastropheModMod.queueServerWork(2, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_0");
			});
			CatastropheModMod.queueServerWork(4, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_1");
			});
			CatastropheModMod.queueServerWork(6, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_2");
			});
			CatastropheModMod.queueServerWork(8, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_3");
			});
			CatastropheModMod.queueServerWork(10, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_4");
			});
			CatastropheModMod.queueServerWork(12, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_5");
			});
			CatastropheModMod.queueServerWork(14, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_6");
			});
			CatastropheModMod.queueServerWork(16, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_7");
			});
			CatastropheModMod.queueServerWork(18, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_8");
			});
			CatastropheModMod.queueServerWork(20, () -> {
				if (entity instanceof FirebrandSlashEntity animatable)
					animatable.setTexture("firebrand_slash_texture_9");
			});
			CatastropheModMod.queueServerWork(21, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}

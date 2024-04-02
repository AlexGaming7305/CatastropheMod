package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
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

import net.mcreator.catastrophemod.entity.NightfallsDemiseProjectileEntity;

import java.util.List;
import java.util.Comparator;

public class NightfallsDemiseProjectileOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		double yort = 0;
		double xort = 0;
		double lifetime = 0;
		double sum = 0;
		double turn = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double speed = 0;
		double zort = 0;
		double zvel = 0;
		double yvel = 0;
		double radius = 0;
		double xvel = 0;
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
		lifetime = 30;
		if (entity.getPersistentData().getDouble("lifetime") >= 15) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
						entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.2), (((entityiterator.getY() + 1) - entity.getY()) * 0.2), ((entityiterator.getZ() - entity.getZ()) * 0.2)));
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("lifetime") > lifetime) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity) {
					if (!(entityiterator == entity)) {
						if (!(entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
							if (!(entityiterator instanceof NightfallsDemiseProjectileEntity)) {
								if (entityiterator.isAlive()) {
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
											}).get(world, "sliced", (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))), 6);
										}
									}
									entity.setDeltaMovement(new Vec3((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX() - entity.getX()) * 0.1), 0.6,
											(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ() - entity.getZ()) * 0.1)));
									entity.setNoGravity(false);
								}
							}
						}
					}
				}
			}
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEnchantments;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class SpearPinPointStrikeProcedure {
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

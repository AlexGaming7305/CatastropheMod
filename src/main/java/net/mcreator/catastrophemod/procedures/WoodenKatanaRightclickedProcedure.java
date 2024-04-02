package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class WoodenKatanaRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
		entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.7), (entity.getDeltaMovement().y() + 0.3), (entity.getLookAngle().z * 0.7)));
		CatastropheModMod.queueServerWork(8, () -> {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.WOODEN_KATANA.get()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.WOODEN_KATANA.get()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, 1, (float) 1.2);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY() + 1), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, 1, (float) 1.2, false);
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity) {
						if (!(entityiterator == entity)) {
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
									}).get(world, "sliced", entity)), 3);
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 1, 0, 0, 0, 0);
						}
					}
				}
			}
		});
	}
}

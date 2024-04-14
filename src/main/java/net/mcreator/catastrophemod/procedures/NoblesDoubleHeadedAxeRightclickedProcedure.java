package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NoblesDoubleHeadedAxeRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		if (world.isClientSide()) {
			if (entity instanceof AbstractClientPlayer player) {
				var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("catastrophe_mod", "player_animation"));
				if (animation != null) {
					animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("catastrophe_mod", "reinforced_axe_swing"))));
				}
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 30);
		CatastropheModMod.queueServerWork(12, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:axe_swings")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator instanceof LivingEntity) {
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
									}).get(world, "sliced", entity)), 9);
								}
							}
						}
					}
				}
			}
		});
	}
}

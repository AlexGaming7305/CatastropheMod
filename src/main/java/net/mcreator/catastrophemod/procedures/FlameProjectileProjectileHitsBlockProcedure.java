package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FlameProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.setSecondsOnFire(10);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				{
					DamageSource _damageSource = (new DamageSource(((Level) world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE), sourceentity) {
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
								return Component.translatable("death.attack." + "onFire.player", _entityName, _attackerName, _itemName);
							} else if (_attacker != null) {
								return Component.translatable("death.attack." + "onFire.player", _entityName, _attackerName);
							} else {
								return Component.translatable("death.attack." + "onFire", _entityName);
							}
						}
					});
					if (_damageSource != null) {
						entityiterator.hurt((new DamageSource(((Level) world).registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE), sourceentity) {
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
									return Component.translatable("death.attack." + "onFire.player", _entityName, _attackerName, _itemName);
								} else if (_attacker != null) {
									return Component.translatable("death.attack." + "onFire.player", _entityName, _attackerName);
								} else {
									return Component.translatable("death.attack." + "onFire", _entityName);
								}
							}
						}), 8);
					}
				}
				entityiterator.setSecondsOnFire(10);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, 75, 0, 0, 0, 0.15);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 50, 0, 0, 0, 0.15);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, x, y, z, 35, 0.2, 0.2, 0.2, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.FLAME_EXPLOSION.get()), x, y, z, 1, 0, 0, 0, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0, 0, 0, 0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fire_magic_explodes")), SoundSource.HOSTILE, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fire_magic_explodes")), SoundSource.HOSTILE, 2, 1, false);
			}
		}
	}
}

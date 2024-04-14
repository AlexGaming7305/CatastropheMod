package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShadowflameSpearsOnInitialEntitySpawnProcedure {
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
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 255, false, false));
		if (entity instanceof ShadowflameSpearsEntity) {
			((ShadowflameSpearsEntity) entity).setAnimation("animation.shadowflame_spears.impale");
		}
		CatastropheModMod.queueServerWork(7, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof SepulcherEntity == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.VULNERABILITY.get(), 100, 0));
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
								}, 15);
						}
					}
				}
			}
		});
		CatastropheModMod.queueServerWork(20, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}

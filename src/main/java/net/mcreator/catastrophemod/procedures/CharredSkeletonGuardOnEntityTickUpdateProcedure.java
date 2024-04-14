package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CharredSkeletonGuardOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("charredskeletonai") == 115) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("charredskeletonai", 0);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
				if (entity instanceof CharredSkeletonGuardEntity) {
					((CharredSkeletonGuardEntity) entity).setAnimation("animation.charred_skeleton_guard.attack");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 255, false, false));
				CatastropheModMod.queueServerWork(15, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fiery_swing")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator == entity) == false && entityiterator instanceof LivingEntity) {
								if (!(entityiterator instanceof CharredSkeletonGuardEntity)) {
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
										}, 15);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.INCINERATION.get(), 100, 0));
								}
							}
						}
					}
				});
			}
			CatastropheModMod.queueServerWork(40, () -> {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
					if (entity instanceof CharredSkeletonGuardEntity) {
						((CharredSkeletonGuardEntity) entity).setAnimation("animation.charred_skeleton_guard.block");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 255, false, false));
					CatastropheModMod.queueServerWork(5, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 65, 3, false, false));
					});
				}
			});
		} else {
			entity.getPersistentData().putDouble("charredskeletonai", (entity.getPersistentData().getDouble("charredskeletonai") + 1));
		}
	}
}

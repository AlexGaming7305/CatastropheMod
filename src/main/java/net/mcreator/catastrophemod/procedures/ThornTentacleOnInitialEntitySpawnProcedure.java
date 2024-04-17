package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.entity.ThornTentacleEntity;
import net.mcreator.catastrophemod.entity.ThornInfestedArmorEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class ThornTentacleOnInitialEntitySpawnProcedure {
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
		if (entity instanceof ThornTentacleEntity) {
			((ThornTentacleEntity) entity).setAnimation("animation.thorn_tenticle.impale");
		}
		CatastropheModMod.queueServerWork(5, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:thorns_snap")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(!world.getEntitiesOfClass(ThornInfestedArmorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty())) {
						if (!(entityiterator == entity)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0));
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
								}, 5);
						}
					}
					if (!world.getEntitiesOfClass(ThornInfestedArmorEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
						if (!(entityiterator == entity)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
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
								}, 12);
						}
					}
				}
			}
		});
		CatastropheModMod.queueServerWork(10, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}

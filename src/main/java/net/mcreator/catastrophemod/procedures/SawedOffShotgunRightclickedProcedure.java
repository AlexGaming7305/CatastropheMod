package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.item.SawedOffShotgunItem;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class SawedOffShotgunRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (itemstack.getOrCreateTag().getDouble("ammo") == 0) {
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.out_of_ammo_timer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CatastropheModMod.queueServerWork(10, () -> {
					{
						boolean _setval = false;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.out_of_ammo_timer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:gun_clicks")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:gun_clicks")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cOut of Ammo!"), true);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("ammo") > 0) {
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 2.5;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.intensity_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 50;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.screenshake_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (itemstack.getItem() instanceof SawedOffShotgunItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.sawed_off_shotgun.fire");
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 16);
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("ammo") - 1));
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:sawed_off_shotgun_shoots")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:sawed_off_shotgun_shoots")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			entity.setDeltaMovement(new Vec3(((-1.5) * entity.getLookAngle().x), ((-0.75) * entity.getLookAngle().y), ((-1.5) * entity.getLookAngle().z)));
			for (int index0 = 0; index0 < 20; index0++) {
				world.addParticle(ParticleTypes.SMOKE, x, (y + 1.1), z,
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getX()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getY()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getZ()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)));
				world.addParticle(ParticleTypes.FLAME, x, (y + 1.1), z,
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getX()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getY()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getZ()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)));
				world.addParticle(ParticleTypes.SMALL_FLAME, x, (y + 1.1), z,
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getX()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getY()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
								+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getZ()) * Mth.nextDouble(RandomSource.create(), 0.01, 0.05)));
			}
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:impaled"))), entity),
									12);
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(4)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:impaled"))), entity),
									12);
						}
					}
				}
			}
		}
	}
}

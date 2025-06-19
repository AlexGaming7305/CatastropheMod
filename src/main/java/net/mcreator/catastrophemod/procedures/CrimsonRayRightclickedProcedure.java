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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

import java.util.List;
import java.util.Comparator;

public class CrimsonRayRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double range = 0;
		double blood_drop_range = 0;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana > 14) {
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana - 15;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (15 - (15 * ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).getBaseValue()) / 100));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:crimson_ray_casts")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:crimson_ray_casts")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			for (int index0 = 0; index0 < 250; index0++) {
				range = range + 0.2;
				if (!world.getBlockState(BlockPos.containing(entity.getX() + (entity.getLookAngle().x * range) / 2, entity.getY() + 1.2 + (entity.getLookAngle().y * range) / 2, entity.getZ() + (entity.getLookAngle().z * range) / 2)).canOcclude()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRIMSON_SPARKLE.get()), (entity.getX() + (entity.getLookAngle().x * range) / 2), (entity.getY() + 1.2 + (entity.getLookAngle().y * range) / 2),
								(entity.getZ() + (entity.getLookAngle().z * range) / 2), 1, 0, 0, 0, 0);
					{
						final Vec3 _center = new Vec3((entity.getX() + (entity.getLookAngle().x * range) / 2), (entity.getY() + 1.2 + (entity.getLookAngle().y * range) / 2), (entity.getZ() + (entity.getLookAngle().z * range) / 2));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity) {
								if (!(entityiterator == entity)) {
									entityiterator.hurt(
											new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:bleed"))), entity), 6);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 100, 0));
								}
							}
						}
					}
				} else {
					break;
				}
			}
			for (int index1 = 0; index1 < 50; index1++) {
				blood_drop_range = blood_drop_range + 1;
				if (!world.getBlockState(
						BlockPos.containing(entity.getX() + (entity.getLookAngle().x * blood_drop_range) / 2, entity.getY() + 1.2 + (entity.getLookAngle().y * blood_drop_range) / 2, entity.getZ() + (entity.getLookAngle().z * blood_drop_range) / 2))
						.canOcclude()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.BLOOD_DROP.get()), (entity.getX() + (entity.getLookAngle().x * blood_drop_range) / 2),
								(entity.getY() + 1.2 + (entity.getLookAngle().y * blood_drop_range) / 2), (entity.getZ() + (entity.getLookAngle().z * blood_drop_range) / 2), 1, 0, 0, 0, 0.1);
				} else {
					break;
				}
			}
			for (int index2 = 0; index2 < 20; index2++) {
				world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.BLOOD_DROP.get()), x, (y + 1.1), z,
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
								+ Mth.nextInt(RandomSource.create(), -4, 4)) - entity.getX()) * Mth.nextDouble(RandomSource.create(), 0.05, 0.1)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
								+ Mth.nextInt(RandomSource.create(), 1, 5)) - entity.getY()) * Mth.nextDouble(RandomSource.create(), 0.05, 0.1)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
								+ Mth.nextInt(RandomSource.create(), -4, 4)) - entity.getZ()) * Mth.nextDouble(RandomSource.create(), 0.05, 0.1)));
			}
		}
	}
}

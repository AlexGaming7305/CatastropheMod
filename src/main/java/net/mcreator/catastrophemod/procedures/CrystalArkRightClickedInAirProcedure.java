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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class CrystalArkRightClickedInAirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		double distance = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ice_magic")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ice_magic")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 50);
		for (int index0 = 0; index0 < 200; index0++) {
			distance = distance + 0.2;
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), (entity.getX() + (entity.getLookAngle().x * distance) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * distance) / 2),
						(entity.getZ() + (entity.getLookAngle().z * distance) / 2), 2, 0.01, 0.01, 0.01, 0);
			{
				final Vec3 _center = new Vec3((entity.getX() + (entity.getLookAngle().x * distance) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * distance) / 2), (entity.getZ() + (entity.getLookAngle().z * distance) / 2));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity) {
							if (entityiterator.getPersistentData().getDouble("crystal_ark_charge") >= 4) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), x, (y + 1), z, 50, 0.2, 0.2, 0.2, 0.5);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:crystal_shatter")), SoundSource.PLAYERS, 1, (float) 1.2);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:crystal_shatter")), SoundSource.PLAYERS, 1, (float) 1.2, false);
									}
								}
								{
									double _setval = 2;
									entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.intensity_timer = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = true;
									entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.screenshake = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								CatastropheModMod.queueServerWork(5, () -> {
									{
										boolean _setval = false;
										entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.screenshake = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								});
							}
							entityiterator.getPersistentData().putDouble("crystal_ark_charge", 0);
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:impaled"))), entity),
									4);
						}
					}
				}
			}
		}
	}
}

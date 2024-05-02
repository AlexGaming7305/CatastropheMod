package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.entity.AtlanticSeaNettleEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class AtlanticSeaNettleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		double yort = 0;
		double xort = 0;
		double lifetime = 0;
		double sum = 0;
		double turn = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double speed = 0;
		double zort = 0;
		double zvel = 0;
		double yvel = 0;
		double radius = 0;
		double xvel = 0;
		if (entity.isInWater()) {
			if (entity.getPersistentData().getDouble("bobbing") == 40) {
				entity.getPersistentData().putBoolean("activate", true);
				entity.getPersistentData().putDouble("bobbing", 0);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + Mth.nextDouble(RandomSource.create(), 0.2, 0.5)), (entity.getDeltaMovement().z())));
			} else {
				entity.getPersistentData().putDouble("bobbing", (entity.getPersistentData().getDouble("bobbing") + 1));
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 0.006), (entity.getDeltaMovement().z())));
		}
		if (entity.getPersistentData().getDouble("timer") == 20) {
			entity.getPersistentData().putBoolean("activate", true);
			entity.getPersistentData().putDouble("timer", 0);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electric_shock")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electric_shock")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							entityiterator
									.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 12);
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 60, 0));
							entityiterator.setDeltaMovement(
									new Vec3(((entity.getX() - entityiterator.getX()) * (-0.4)), ((entity.getY() - (entityiterator.getY() + entity.getBbHeight() - 0.4)) * (-0.4)), ((entity.getZ() - entityiterator.getZ()) * (-0.4))));
						}
					}
				}
				if (entity instanceof AtlanticSeaNettleEntity animatable)
					animatable.setTexture("atlantic_sea_nettle_texture_0");
				CatastropheModMod.queueServerWork(2, () -> {
					if (entity instanceof AtlanticSeaNettleEntity animatable)
						animatable.setTexture("atlantic_sea_nettle_texture_1");
				});
				CatastropheModMod.queueServerWork(4, () -> {
					if (entity instanceof AtlanticSeaNettleEntity animatable)
						animatable.setTexture("atlantic_sea_nettle_texture_2");
				});
				CatastropheModMod.queueServerWork(6, () -> {
					if (entity instanceof AtlanticSeaNettleEntity animatable)
						animatable.setTexture("atlantic_sea_nettle_texture_3");
				});
				CatastropheModMod.queueServerWork(8, () -> {
					if (entity instanceof AtlanticSeaNettleEntity animatable)
						animatable.setTexture("atlantic_sea_nettle_texture_4");
				});
				CatastropheModMod.queueServerWork(10, () -> {
					if (entity instanceof AtlanticSeaNettleEntity animatable)
						animatable.setTexture("atlantic_sea_nettle_texture");
				});
			}
		} else {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		}
	}
}

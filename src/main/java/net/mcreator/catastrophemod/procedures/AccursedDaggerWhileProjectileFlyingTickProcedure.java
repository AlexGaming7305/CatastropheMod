package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;

public class AccursedDaggerWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		boolean flag = false;
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
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.ACCURSED_SHIMMER.get()), x, y, z, 3, 0.05, 0.05, 0.05, 0);
		immediatesourceentity.setNoGravity(true);
		xvel = immediatesourceentity.getDeltaMovement().x();
		yvel = immediatesourceentity.getDeltaMovement().y();
		zvel = immediatesourceentity.getDeltaMovement().z();
		flag = true;
		turn = 0.8;
		speed = 1.6;
		radius = 100;
		lifetime = 15;
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") >= 4 && immediatesourceentity.getPersistentData().getDouble("lifetime") < 5) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:knife_flying")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:knife_flying")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") >= 3 && immediatesourceentity.getPersistentData().getDouble("lifetime") <= 9) {
			if (flag) {
				flag = false;
				xdir = (entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), 8, 9)))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
						.getBlockPos().getX() + 0.5) - immediatesourceentity.getX();
				ydir = (entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), 8, 9)))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
						.getBlockPos().getY() + 0.5) - immediatesourceentity.getY();
				zdir = (entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), 8, 9)))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
						.getBlockPos().getZ() + 0.5) - immediatesourceentity.getZ();
			}
			sum = Math.abs(xdir) + Math.abs(ydir) + Math.abs(zdir);
			if (!(sum == 0)) {
				xort = xdir / sum;
				yort = ydir / sum;
				zort = zdir / sum;
				xvel = xvel + xort * turn;
				yvel = yvel + yort * turn;
				zvel = zvel + zort * turn;
			}
			sum = Math.abs(xvel) + Math.abs(yvel) + Math.abs(zvel);
			xvel = (xvel / sum) * speed;
			yvel = (yvel / sum) * speed;
			zvel = (zvel / sum) * speed;
			immediatesourceentity.setDeltaMovement(new Vec3(xvel, yvel, zvel));
		}
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") >= 10 && immediatesourceentity.getPersistentData().getDouble("lifetime") <= 15) {
			if (flag) {
				flag = false;
				xdir = (entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), 20, 21)))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
						.getBlockPos().getX() + 0.5) - immediatesourceentity.getX();
				ydir = (entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), 20, 21)))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
						.getBlockPos().getY() + 0.5) - immediatesourceentity.getY();
				zdir = (entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), 20, 21)))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
						.getBlockPos().getZ() + 0.5) - immediatesourceentity.getZ();
			}
			sum = Math.abs(xdir) + Math.abs(ydir) + Math.abs(zdir);
			if (!(sum == 0)) {
				xort = xdir / sum;
				yort = ydir / sum;
				zort = zdir / sum;
				xvel = xvel + xort * turn;
				yvel = yvel + yort * turn;
				zvel = zvel + zort * turn;
			}
			sum = Math.abs(xvel) + Math.abs(yvel) + Math.abs(zvel);
			xvel = (xvel / sum) * speed;
			yvel = (yvel / sum) * speed;
			zvel = (zvel / sum) * speed;
			immediatesourceentity.setDeltaMovement(new Vec3(xvel, yvel, zvel));
		}
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") > lifetime) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.PURPLE_CURSED_SPARK.get()), x, y, z, 10, 0.2, 0.2, 0.2, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vex.hurt")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vex.hurt")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		} else {
			immediatesourceentity.getPersistentData().putDouble("lifetime", (immediatesourceentity.getPersistentData().getDouble("lifetime") + 1));
		}
	}
}

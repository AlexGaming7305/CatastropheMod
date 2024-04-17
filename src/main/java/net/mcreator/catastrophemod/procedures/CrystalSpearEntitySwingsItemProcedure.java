package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;

public class CrystalSpearEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = CatastropheModModEntities.CRYSTAL_SPEAR_STAB.get().spawn(_level, BlockPos.containing(entity.getX() + entity.getLookAngle().x, entity.getY() + 1.5 + entity.getLookAngle().y, entity.getZ() + entity.getLookAngle().z),
					MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(entity.getYRot());
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				entityToSpawn.setXRot(entity.getXRot());
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, (float) 0.8);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, (float) 0.8, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), (entity.getX() + (entity.getLookAngle().x * 1) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * 1) / 2),
					(entity.getZ() + (entity.getLookAngle().z * 1) / 2), 15, 0.2, 0.2, 0.2, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), (entity.getX() + (entity.getLookAngle().x * 3) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * 3) / 2),
					(entity.getZ() + (entity.getLookAngle().z * 3) / 2), 15, 0.2, 0.2, 0.2, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), (entity.getX() + (entity.getLookAngle().x * 5) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * 5) / 2),
					(entity.getZ() + (entity.getLookAngle().z * 5) / 2), 15, 0.2, 0.2, 0.2, 0.1);
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;

public class CrystalArkLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		if (entity.getPersistentData().getDouble("crystal_ark_charge") < 4) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.chime")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.chime")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putDouble("crystal_ark_charge", (entity.getPersistentData().getDouble("crystal_ark_charge") + 1));
		}
		if (entity.getPersistentData().getDouble("crystal_ark_charge") >= 4) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.break")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.break")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.CRYSTAL_SPARK.get()), x, (y + 1), z, 30, 0.2, 0.2, 0.2, 0.3);
		}
	}
}

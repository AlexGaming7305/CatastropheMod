package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class OilUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isClientSide() == false) {
			if (Math.random() < 0.1) {
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.FIRE
						|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.FIRE
						|| (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.FIRE
						|| (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.FIRE) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FIRE.defaultBlockState(), 3);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:oil_ignites")), SoundSource.BLOCKS, 1,
									Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:oil_ignites")), SoundSource.BLOCKS, 1, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1), false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 10, 0.4, 0.4, 0.4, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 10, 0.4, 0.4, 0.4, 0);
				}
			}
		}
	}
}

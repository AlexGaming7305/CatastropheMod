package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;

public class BleedingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (entity.getPersistentData().getDouble("Delay") == 0) {
				entity.getPersistentData().putDouble("Delay", (40 - amplifier * 5));
			} else {
				entity.getPersistentData().putDouble("Delay", (entity.getPersistentData().getDouble("Delay") - 1));
			}
			if (entity.getPersistentData().getDouble("Delay") == 0) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:bleed")))), 1);
			}
		}
		if (entity.isAlive()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.BLOOD_DROP.get()), x, (y + entity.getBbHeight() - 0.4), z, 1, 0.2, 0.1, 0.2, 0.1);
		}
	}
}

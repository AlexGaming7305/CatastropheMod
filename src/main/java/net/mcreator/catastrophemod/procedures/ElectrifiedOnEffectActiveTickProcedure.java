package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;

public class ElectrifiedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.ELECTRIFIED_SPARK.get()), x, y, z, 1, 0.25, (entity.getBbHeight() / 2), 0.25, 0);
		if ((entity.getPersistentData().getDouble("X") != entity.getX() || entity.getPersistentData().getDouble("Y") != entity.getY() || entity.getPersistentData().getDouble("Z") != entity.getZ())
				&& entity.getPersistentData().getBoolean("electrifiedDamage") == true) {
			if (!((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.IMPEDANCE.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.IMPEDANCE.get()).getAmplifier() : 0) >= 3)) {
				if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(CatastropheModModMobEffects.IMPEDANCE.get()))) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electrocuted")))),
							(float) (1 * (amplifier + 1)));
				} else {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electrocuted")))),
							(float) (1 * (amplifier + 1)
									* (1 - ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.IMPEDANCE.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.IMPEDANCE.get()).getAmplifier() : 0) + 1) * 0.25)));
				}
			}
		}
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		entity.getPersistentData().putBoolean("electrifiedDamage", true);
	}
}

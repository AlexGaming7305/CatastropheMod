
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.catastrophemod.client.particle.StarrySparkleParticle;
import net.mcreator.catastrophemod.client.particle.SparkParticle;
import net.mcreator.catastrophemod.client.particle.SnowflakeParticle;
import net.mcreator.catastrophemod.client.particle.PoisonTrailParticle;
import net.mcreator.catastrophemod.client.particle.HealingSparkParticle;
import net.mcreator.catastrophemod.client.particle.HauntedGlimmerParticle;
import net.mcreator.catastrophemod.client.particle.FieryExplosionParticle;
import net.mcreator.catastrophemod.client.particle.ElectrifiedSparkParticle;
import net.mcreator.catastrophemod.client.particle.DashIndicatorParticle;
import net.mcreator.catastrophemod.client.particle.CrystalSparkParticle;
import net.mcreator.catastrophemod.client.particle.CrystalBlastParticle;
import net.mcreator.catastrophemod.client.particle.BloodDropParticle;
import net.mcreator.catastrophemod.client.particle.BlizzardWindParticle;
import net.mcreator.catastrophemod.client.particle.AmatoxinGasParticle;
import net.mcreator.catastrophemod.client.particle.AccursedShimmerParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CatastropheModModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(CatastropheModModParticleTypes.POISON_TRAIL.get(), PoisonTrailParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.DASH_INDICATOR.get(), DashIndicatorParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.ELECTRIFIED_SPARK.get(), ElectrifiedSparkParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.HEALING_SPARK.get(), HealingSparkParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.AMATOXIN_GAS.get(), AmatoxinGasParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.BLOOD_DROP.get(), BloodDropParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.CRYSTAL_SPARK.get(), CrystalSparkParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.SNOWFLAKE.get(), SnowflakeParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.BLIZZARD_WIND.get(), BlizzardWindParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.SPARK.get(), SparkParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.CRYSTAL_BLAST.get(), CrystalBlastParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.FIERY_EXPLOSION.get(), FieryExplosionParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.ACCURSED_SHIMMER.get(), AccursedShimmerParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.HAUNTED_GLIMMER.get(), HauntedGlimmerParticle::provider);
		event.registerSpriteSet(CatastropheModModParticleTypes.STARRY_SPARKLE.get(), StarrySparkleParticle::provider);
	}
}

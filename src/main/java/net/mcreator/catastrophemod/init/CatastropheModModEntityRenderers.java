
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CatastropheModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CatastropheModModEntities.TIA_DASH.get(), TiaDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.THORN_INFESTED_ARMOR.get(), ThornInfestedArmorRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.MINERAL_WRAITH.get(), MineralWraithRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FURIOUS_WIND.get(), FuriousWindRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.PILE_OF_MOSS.get(), PileOfMossRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORDSPIN.get(), SwordspinRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORD_ORBIT.get(), SwordOrbitRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ASSASSIN_SKELETON.get(), AssassinSkeletonRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.WRAITH_DASH.get(), WraithDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORD_SPIN_DASH.get(), SwordSpinDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORD_DASH.get(), SwordDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FREEZING_CORE.get(), FreezingCoreRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ACID_TARANTULA_MINION.get(), AcidTarantulaMinionRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.WHIRLPOOL_ENTITY.get(), WhirlpoolEntityRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HERMIT_CRAB.get(), HermitCrabRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.LIGHTNING_BLADE.get(), LightningBladeRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SPORE_ZOMBIE.get(), SporeZombieRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.THORN_TENTACLE.get(), ThornTentacleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CALICO_STAG_BEETLE.get(), CalicoStagBeetleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.BABY_CALICO_STAG_BEETLE.get(), BabyCalicoStagBeetleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADE.get(), ShadeRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HERMIT_CRAB_MINION.get(), HermitCrabMinionRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NATURE_BLESSED_SPIRIT.get(), NatureBlessedSpiritRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SEPULCHER.get(), SepulcherRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOWFLAME_SPEARS.get(), ShadowflameSpearsRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.DESCENDING_MISERY.get(), DescendingMiseryRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CHARRED_SKELETON_GUARD.get(), CharredSkeletonGuardRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NETTLE.get(), NettleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NETTLE_MINION.get(), NettleMinionRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.BLAZING_PHOENIX.get(), BlazingPhoenixRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.EARTHBOUND_FIST.get(), EarthboundFistRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.EARTHBOUND_WRAITH.get(), EarthboundWraithRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.EARTH_SHOCKWAVE.get(), EarthShockwaveRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CHARRED_MANTIS.get(), CharredMantisRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NIGHTFALLS_DEMISE_PROJECTILE.get(), NightfallsDemiseProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CRYSTAL_SPEAR_STAB.get(), CrystalSpearStabRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.OCEANIC_SPLASH.get(), OceanicSplashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.RIPSAW_SAWBLADE.get(), RipsawSawbladeRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FIREBRAND_SLASH.get(), FirebrandSlashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SILK_MOTH.get(), SilkMothRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ATLANTIC_SEA_NETTLE.get(), AtlanticSeaNettleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FROST_BOLT_PROJECTILE.get(), FrostBoltProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FLAME_PROJECTILE_PROJECTILE.get(), FlameProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.LIGHTNING_BOOK_SPARK_PROJECTILE.get(), LightningBookSparkProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.STORM_ARROW_PROJECTILE.get(), StormArrowProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), PoisonousThornProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.WRAITH_SPARKS_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FREEZING_SPIKE_PROJECTILE.get(), FreezingSpikeProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.GHOST_PHANTOM_PROJECTILE.get(), GhostPhantomProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), ThornSpearProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), TinyThornProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHELL_PROJECTILE.get(), ShellProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.KNIFE_OF_PROFICIENCY_PROJECTILE_PROJECTILE.get(), KnifeOfProficiencyProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.IRON_ROUND_PROJECTILE_PROJECTILE.get(), IronRoundProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOW_FIREBALL_PROJECTILE.get(), ShadowFireballProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CRYSTAL_ROUND_PROJECTILE_PROJECTILE.get(), CrystalRoundProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.VENOMOUS_BULLET_PROJECTILE_PROJECTILE.get(), VenomousBulletProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ELECTRIFIED_ROUND_PROJECTILE_PROJECTILE.get(), ElectrifiedRoundProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HEALING_ORB_PROJECTILE.get(), HealingOrbProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NATURE_BLAST_PROJECTILE.get(), NatureBlastProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOWFIRE_SOUL_PROJECTILE.get(), ShadowfireSoulProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOW_FIRE_SOUL_FRIENDLY_PROJECTILE.get(), ShadowFireSoulFriendlyProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOWFIRE_SKULL_PROJECTILE.get(), ShadowfireSkullProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SPORE_PROJECTILE.get(), SporeProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.VULNERABILITY_SKULL_PROJECTILE.get(), VulnerabilitySkullProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOWFIRE_SOUL_NO_GRAVITY_PROJECTILE.get(), ShadowfireSoulNoGravityProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NOHOMING_HEALING_ORB_PROJECTILE.get(), NohomingHealingOrbProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ICE_SHARD_PROJECTILE.get(), IceShardProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FRIENDLY_POISONOUS_THORN_PROJECTILE.get(), FriendlyPoisonousThornProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FIERY_SLASH_PROJECTILE.get(), FierySlashProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CRYSTAL_SHARD_PROJECTILE.get(), CrystalShardProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.BLAZING_FEATHER_PROJECTILE.get(), BlazingFeatherProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HEALING_BLOSSOM_PROJECTILE.get(), HealingBlossomProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.EARTHBOUND_ROCK_PROJECTILE.get(), EarthboundRockProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.EARTH_SHATTERER_PROJECTILE_PROJECTILE.get(), EarthShattererProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.EARTHBOUND_ROCK_SHARD_PROJECTILE.get(), EarthboundRockShardProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.LIFEDRAIN_ARROW_PROJECTILE.get(), LifedrainArrowProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.VEIN_STRIKER_PROJECTILE_PROJECTILE.get(), VeinStrikerProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.VEIN_STRIKER_BLOOD_KNIFE_PROJECTILE_PROJECTILE.get(), VeinStrikerBloodKnifeProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.BLOOD_KNIFE_PROJECTILE.get(), BloodKnifeProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FIERY_ROUND_PROJECTILE.get(), FieryRoundProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FROZEN_SHIELD_ICE_SPIKE_PROJECTILE.get(), FrozenShieldIceSpikeProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.BLIZZARD_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ANGLERFISH.get(), AnglerfishRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ACCURSED_DAGGER.get(), AccursedDaggerRenderer::new);
	}
}

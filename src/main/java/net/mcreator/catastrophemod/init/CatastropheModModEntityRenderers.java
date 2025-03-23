
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.catastrophemod.client.renderer.WraithDashRenderer;
import net.mcreator.catastrophemod.client.renderer.VulnerabilitySkullProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.VoltbladeRenderer;
import net.mcreator.catastrophemod.client.renderer.VenomousBulletProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.VeinStrikerProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.VeinStrikerBloodKnifeProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.TinyThornProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.TideSlashProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.TiaDashRenderer;
import net.mcreator.catastrophemod.client.renderer.ThornTentacleRenderer;
import net.mcreator.catastrophemod.client.renderer.ThornSpearProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ThornInfestedArmorRenderer;
import net.mcreator.catastrophemod.client.renderer.SwordspinRenderer;
import net.mcreator.catastrophemod.client.renderer.SwordSpinDashRenderer;
import net.mcreator.catastrophemod.client.renderer.SwordDashRenderer;
import net.mcreator.catastrophemod.client.renderer.SurgeBreakerRenderer;
import net.mcreator.catastrophemod.client.renderer.StormsmithRenderer;
import net.mcreator.catastrophemod.client.renderer.StormArrowProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.StarlitLacewingRenderer;
import net.mcreator.catastrophemod.client.renderer.StarlitLacewingMinionRenderer;
import net.mcreator.catastrophemod.client.renderer.SporeZombieRenderer;
import net.mcreator.catastrophemod.client.renderer.SporeProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.SilkMothRenderer;
import net.mcreator.catastrophemod.client.renderer.ShellProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadowflameSpearsRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadowfireSoulProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadowfireSoulNoGravityProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadowfireSkullProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadowFireballProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadowFireSoulFriendlyProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ShadeRenderer;
import net.mcreator.catastrophemod.client.renderer.SepulcherRenderer;
import net.mcreator.catastrophemod.client.renderer.SeaCrystalShardProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.SeaCrystalRiptideProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ScrapRoundProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.RustyScrapProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.RipsawSawbladeRenderer;
import net.mcreator.catastrophemod.client.renderer.PoisonousThornProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.OceanicSplashRenderer;
import net.mcreator.catastrophemod.client.renderer.NohomingHealingOrbProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.NightfallsDemiseProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.NightReaperRenderer;
import net.mcreator.catastrophemod.client.renderer.NettleRenderer;
import net.mcreator.catastrophemod.client.renderer.NatureBlastProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.NailgunNailRenderer;
import net.mcreator.catastrophemod.client.renderer.MineralWraithRenderer;
import net.mcreator.catastrophemod.client.renderer.LightningBladeRenderer;
import net.mcreator.catastrophemod.client.renderer.LifedrainArrowProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.KnifeOfProficiencyProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.IceShardProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.HuntsmanKnifeProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.HermitCrabRenderer;
import net.mcreator.catastrophemod.client.renderer.HealingOrbProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.HealingBlossomProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.HauntedMirrorEntityRenderer;
import net.mcreator.catastrophemod.client.renderer.GiantIsopodRenderer;
import net.mcreator.catastrophemod.client.renderer.GhostPhantomProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.FrozenShieldIceSpikeProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.FrostBoltProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.FriendlySwordOrbitRenderer;
import net.mcreator.catastrophemod.client.renderer.FriendlyPoisonousThornProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.FlameProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.FirebrandSlashRenderer;
import net.mcreator.catastrophemod.client.renderer.FierySlashProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.FieryRoundProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ElectrifiedSwordProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ElectrifiedRoundProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.ElectrifiedLightningRenderer;
import net.mcreator.catastrophemod.client.renderer.EarthboundWraithRenderer;
import net.mcreator.catastrophemod.client.renderer.EarthboundRockShardProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.EarthboundRockProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.EarthShockwaveRenderer;
import net.mcreator.catastrophemod.client.renderer.EarthShattererProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.DiamondDetonationBombRenderer;
import net.mcreator.catastrophemod.client.renderer.CrystalSpearStabRenderer;
import net.mcreator.catastrophemod.client.renderer.CrystalShardProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.CrystalRoundProjectileProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.CopperRoundProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.CharredSkeletonGuardRenderer;
import net.mcreator.catastrophemod.client.renderer.CharredMantisRenderer;
import net.mcreator.catastrophemod.client.renderer.CalicoStagBeetleRenderer;
import net.mcreator.catastrophemod.client.renderer.CactusNeedleRenderer;
import net.mcreator.catastrophemod.client.renderer.BloodKnifeProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.BlazingPhoenixRenderer;
import net.mcreator.catastrophemod.client.renderer.BlazingFeatherProjectileRenderer;
import net.mcreator.catastrophemod.client.renderer.AtlanticSeaNettleRenderer;
import net.mcreator.catastrophemod.client.renderer.ArcStrikerRenderer;
import net.mcreator.catastrophemod.client.renderer.AnglerfishRenderer;
import net.mcreator.catastrophemod.client.renderer.AccursedWitchRenderer;
import net.mcreator.catastrophemod.client.renderer.AccursedSoulRenderer;
import net.mcreator.catastrophemod.client.renderer.AccursedDaggerRenderer;
import net.mcreator.catastrophemod.client.renderer.AccursedArrowProjectileRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CatastropheModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CatastropheModModEntities.TIA_DASH.get(), TiaDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.THORN_INFESTED_ARMOR.get(), ThornInfestedArmorRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.MINERAL_WRAITH.get(), MineralWraithRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORDSPIN.get(), SwordspinRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.WRAITH_DASH.get(), WraithDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORD_SPIN_DASH.get(), SwordSpinDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SWORD_DASH.get(), SwordDashRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HERMIT_CRAB.get(), HermitCrabRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.LIGHTNING_BLADE.get(), LightningBladeRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SPORE_ZOMBIE.get(), SporeZombieRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.THORN_TENTACLE.get(), ThornTentacleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CALICO_STAG_BEETLE.get(), CalicoStagBeetleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADE.get(), ShadeRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SEPULCHER.get(), SepulcherRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHADOWFLAME_SPEARS.get(), ShadowflameSpearsRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CHARRED_SKELETON_GUARD.get(), CharredSkeletonGuardRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NETTLE.get(), NettleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.BLAZING_PHOENIX.get(), BlazingPhoenixRenderer::new);
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
		event.registerEntityRenderer(CatastropheModModEntities.STORM_ARROW_PROJECTILE.get(), StormArrowProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.POISONOUS_THORN_PROJECTILE.get(), PoisonousThornProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.GHOST_PHANTOM_PROJECTILE.get(), GhostPhantomProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.THORN_SPEAR_PROJECTILE_PROJECTILE.get(), ThornSpearProjectileProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.TINY_THORN_PROJECTILE.get(), TinyThornProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SHELL_PROJECTILE.get(), ShellProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.KNIFE_OF_PROFICIENCY_PROJECTILE_PROJECTILE.get(), KnifeOfProficiencyProjectileProjectileRenderer::new);
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
		event.registerEntityRenderer(CatastropheModModEntities.ELECTRIC_SPARK_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HUNTSMAN_KNIFE_PROJECTILE.get(), HuntsmanKnifeProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.CACTUS_NEEDLE.get(), CactusNeedleRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.HAUNTED_MIRROR_ENTITY.get(), HauntedMirrorEntityRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ACCURSED_SOUL.get(), AccursedSoulRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.STARLIT_LACEWING.get(), StarlitLacewingRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.DIAMOND_DETONATION_BOMB.get(), DiamondDetonationBombRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.GIANT_ISOPOD.get(), GiantIsopodRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ELECTRIFIED_SWORD_PROJECTILE.get(), ElectrifiedSwordProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FORCE_MISSILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SEA_CRYSTAL_SHARD_PROJECTILE.get(), SeaCrystalShardProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SEA_CRYSTAL_RIPTIDE_PROJECTILE.get(), SeaCrystalRiptideProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.VOLTBLADE.get(), VoltbladeRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FRIENDLY_SWORD_ORBIT.get(), FriendlySwordOrbitRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ELECTRIFIED_LIGHTNING.get(), ElectrifiedLightningRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ARC_STRIKER.get(), ArcStrikerRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SURGE_BREAKER.get(), SurgeBreakerRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ACCURSED_WITCH.get(), AccursedWitchRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.RUSTY_SCRAP_PROJECTILE.get(), RustyScrapProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.ACCURSED_ARROW_PROJECTILE.get(), AccursedArrowProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NAILGUN_NAIL.get(), NailgunNailRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.SCRAP_ROUND_PROJECTILE.get(), ScrapRoundProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.COPPER_ROUND_PROJECTILE.get(), CopperRoundProjectileRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.FIERY_BOLT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.NIGHT_REAPER.get(), NightReaperRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.STARLIT_LACEWING_MINION.get(), StarlitLacewingMinionRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.STORMSMITH.get(), StormsmithRenderer::new);
		event.registerEntityRenderer(CatastropheModModEntities.TIDE_SLASH_PROJECTILE.get(), TideSlashProjectileRenderer::new);
	}
}

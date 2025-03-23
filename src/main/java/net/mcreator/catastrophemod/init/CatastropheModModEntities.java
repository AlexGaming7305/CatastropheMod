
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.WraithDashEntity;
import net.mcreator.catastrophemod.entity.VulnerabilitySkullProjectileEntity;
import net.mcreator.catastrophemod.entity.VoltbladeEntity;
import net.mcreator.catastrophemod.entity.VenomousBulletProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.VeinStrikerProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.VeinStrikerBloodKnifeProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.TinyThornProjectileEntity;
import net.mcreator.catastrophemod.entity.TideSlashProjectileEntity;
import net.mcreator.catastrophemod.entity.TiaDashEntity;
import net.mcreator.catastrophemod.entity.ThornTentacleEntity;
import net.mcreator.catastrophemod.entity.ThornSpearProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.ThornInfestedArmorEntity;
import net.mcreator.catastrophemod.entity.SwordspinEntity;
import net.mcreator.catastrophemod.entity.SwordSpinDashEntity;
import net.mcreator.catastrophemod.entity.SwordDashEntity;
import net.mcreator.catastrophemod.entity.SurgeBreakerEntity;
import net.mcreator.catastrophemod.entity.StormsmithEntity;
import net.mcreator.catastrophemod.entity.StormArrowProjectileEntity;
import net.mcreator.catastrophemod.entity.StarlitLacewingMinionEntity;
import net.mcreator.catastrophemod.entity.StarlitLacewingEntity;
import net.mcreator.catastrophemod.entity.SporeZombieEntity;
import net.mcreator.catastrophemod.entity.SporeProjectileEntity;
import net.mcreator.catastrophemod.entity.SilkMothEntity;
import net.mcreator.catastrophemod.entity.ShellProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadowflameSpearsEntity;
import net.mcreator.catastrophemod.entity.ShadowfireSoulProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadowfireSoulNoGravityProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadowfireSkullProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadowFireballProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadowFireSoulFriendlyProjectileEntity;
import net.mcreator.catastrophemod.entity.ShadeEntity;
import net.mcreator.catastrophemod.entity.SepulcherEntity;
import net.mcreator.catastrophemod.entity.SeaCrystalShardProjectileEntity;
import net.mcreator.catastrophemod.entity.SeaCrystalRiptideProjectileEntity;
import net.mcreator.catastrophemod.entity.ScrapRoundProjectileEntity;
import net.mcreator.catastrophemod.entity.RustyScrapProjectileEntity;
import net.mcreator.catastrophemod.entity.RipsawSawbladeEntity;
import net.mcreator.catastrophemod.entity.PoisonousThornProjectileEntity;
import net.mcreator.catastrophemod.entity.OceanicSplashEntity;
import net.mcreator.catastrophemod.entity.NohomingHealingOrbProjectileEntity;
import net.mcreator.catastrophemod.entity.NightfallsDemiseProjectileEntity;
import net.mcreator.catastrophemod.entity.NightReaperEntity;
import net.mcreator.catastrophemod.entity.NettleEntity;
import net.mcreator.catastrophemod.entity.NatureBlastProjectileEntity;
import net.mcreator.catastrophemod.entity.NailgunNailEntity;
import net.mcreator.catastrophemod.entity.MineralWraithEntity;
import net.mcreator.catastrophemod.entity.LightningBladeEntity;
import net.mcreator.catastrophemod.entity.LifedrainArrowProjectileEntity;
import net.mcreator.catastrophemod.entity.KnifeOfProficiencyProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.IceShardProjectileEntity;
import net.mcreator.catastrophemod.entity.HuntsmanKnifeProjectileEntity;
import net.mcreator.catastrophemod.entity.HermitCrabEntity;
import net.mcreator.catastrophemod.entity.HealingOrbProjectileEntity;
import net.mcreator.catastrophemod.entity.HealingBlossomProjectileEntity;
import net.mcreator.catastrophemod.entity.HauntedMirrorEntityEntity;
import net.mcreator.catastrophemod.entity.GiantIsopodEntity;
import net.mcreator.catastrophemod.entity.GhostPhantomProjectileEntity;
import net.mcreator.catastrophemod.entity.FrozenShieldIceSpikeProjectileEntity;
import net.mcreator.catastrophemod.entity.FrostBoltProjectileEntity;
import net.mcreator.catastrophemod.entity.FriendlySwordOrbitEntity;
import net.mcreator.catastrophemod.entity.FriendlyPoisonousThornProjectileEntity;
import net.mcreator.catastrophemod.entity.ForceMissileEntity;
import net.mcreator.catastrophemod.entity.FlameProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.FirebrandSlashEntity;
import net.mcreator.catastrophemod.entity.FierySlashProjectileEntity;
import net.mcreator.catastrophemod.entity.FieryRoundProjectileEntity;
import net.mcreator.catastrophemod.entity.FieryBoltEntity;
import net.mcreator.catastrophemod.entity.ElectrifiedSwordProjectileEntity;
import net.mcreator.catastrophemod.entity.ElectrifiedRoundProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.ElectrifiedLightningEntity;
import net.mcreator.catastrophemod.entity.ElectricSparkProjectileEntity;
import net.mcreator.catastrophemod.entity.EarthboundWraithEntity;
import net.mcreator.catastrophemod.entity.EarthboundRockShardProjectileEntity;
import net.mcreator.catastrophemod.entity.EarthboundRockProjectileEntity;
import net.mcreator.catastrophemod.entity.EarthShockwaveEntity;
import net.mcreator.catastrophemod.entity.EarthShattererProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.DiamondDetonationBombEntity;
import net.mcreator.catastrophemod.entity.CrystalSpearStabEntity;
import net.mcreator.catastrophemod.entity.CrystalShardProjectileEntity;
import net.mcreator.catastrophemod.entity.CrystalRoundProjectileProjectileEntity;
import net.mcreator.catastrophemod.entity.CopperRoundProjectileEntity;
import net.mcreator.catastrophemod.entity.CharredSkeletonGuardEntity;
import net.mcreator.catastrophemod.entity.CharredMantisEntity;
import net.mcreator.catastrophemod.entity.CalicoStagBeetleEntity;
import net.mcreator.catastrophemod.entity.CactusNeedleEntity;
import net.mcreator.catastrophemod.entity.BloodKnifeProjectileEntity;
import net.mcreator.catastrophemod.entity.BlizzardProjectileEntity;
import net.mcreator.catastrophemod.entity.BlazingPhoenixEntity;
import net.mcreator.catastrophemod.entity.BlazingFeatherProjectileEntity;
import net.mcreator.catastrophemod.entity.AtlanticSeaNettleEntity;
import net.mcreator.catastrophemod.entity.ArcStrikerEntity;
import net.mcreator.catastrophemod.entity.AnglerfishEntity;
import net.mcreator.catastrophemod.entity.AccursedWitchEntity;
import net.mcreator.catastrophemod.entity.AccursedSoulEntity;
import net.mcreator.catastrophemod.entity.AccursedDaggerEntity;
import net.mcreator.catastrophemod.entity.AccursedArrowProjectileEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CatastropheModMod.MODID);
	public static final RegistryObject<EntityType<TiaDashEntity>> TIA_DASH = register("tia_dash",
			EntityType.Builder.<TiaDashEntity>of(TiaDashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TiaDashEntity::new).fireImmune().sized(0f, 0.1f));
	public static final RegistryObject<EntityType<ThornInfestedArmorEntity>> THORN_INFESTED_ARMOR = register("thorn_infested_armor",
			EntityType.Builder.<ThornInfestedArmorEntity>of(ThornInfestedArmorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ThornInfestedArmorEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MineralWraithEntity>> MINERAL_WRAITH = register("mineral_wraith", EntityType.Builder.<MineralWraithEntity>of(MineralWraithEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MineralWraithEntity::new).fireImmune().sized(1.5f, 3f));
	public static final RegistryObject<EntityType<SwordspinEntity>> SWORDSPIN = register("swordspin",
			EntityType.Builder.<SwordspinEntity>of(SwordspinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SwordspinEntity::new).fireImmune().sized(3f, 0.1f));
	public static final RegistryObject<EntityType<WraithDashEntity>> WRAITH_DASH = register("wraith_dash", EntityType.Builder.<WraithDashEntity>of(WraithDashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(WraithDashEntity::new).fireImmune().sized(0f, 0.1f));
	public static final RegistryObject<EntityType<SwordSpinDashEntity>> SWORD_SPIN_DASH = register("sword_spin_dash", EntityType.Builder.<SwordSpinDashEntity>of(SwordSpinDashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SwordSpinDashEntity::new).fireImmune().sized(0f, 0.1f));
	public static final RegistryObject<EntityType<SwordDashEntity>> SWORD_DASH = register("sword_dash",
			EntityType.Builder.<SwordDashEntity>of(SwordDashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SwordDashEntity::new).fireImmune().sized(0f, 0.1f));
	public static final RegistryObject<EntityType<HermitCrabEntity>> HERMIT_CRAB = register("hermit_crab",
			EntityType.Builder.<HermitCrabEntity>of(HermitCrabEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HermitCrabEntity::new)

					.sized(0.7f, 0.5f));
	public static final RegistryObject<EntityType<LightningBladeEntity>> LIGHTNING_BLADE = register("lightning_blade", EntityType.Builder.<LightningBladeEntity>of(LightningBladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LightningBladeEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<SporeZombieEntity>> SPORE_ZOMBIE = register("spore_zombie",
			EntityType.Builder.<SporeZombieEntity>of(SporeZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SporeZombieEntity::new)

					.sized(0.6f, 1.9f));
	public static final RegistryObject<EntityType<ThornTentacleEntity>> THORN_TENTACLE = register("thorn_tentacle", EntityType.Builder.<ThornTentacleEntity>of(ThornTentacleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ThornTentacleEntity::new).fireImmune().sized(0.2f, 1.6f));
	public static final RegistryObject<EntityType<CalicoStagBeetleEntity>> CALICO_STAG_BEETLE = register("calico_stag_beetle",
			EntityType.Builder.<CalicoStagBeetleEntity>of(CalicoStagBeetleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CalicoStagBeetleEntity::new)

					.sized(1.2f, 0.7f));
	public static final RegistryObject<EntityType<ShadeEntity>> SHADE = register("shade",
			EntityType.Builder.<ShadeEntity>of(ShadeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SepulcherEntity>> SEPULCHER = register("sepulcher", EntityType.Builder.<SepulcherEntity>of(SepulcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(SepulcherEntity::new).fireImmune().sized(0.6f, 2.2f));
	public static final RegistryObject<EntityType<ShadowflameSpearsEntity>> SHADOWFLAME_SPEARS = register("shadowflame_spears", EntityType.Builder.<ShadowflameSpearsEntity>of(ShadowflameSpearsEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowflameSpearsEntity::new).fireImmune().sized(1.2f, 1.7f));
	public static final RegistryObject<EntityType<CharredSkeletonGuardEntity>> CHARRED_SKELETON_GUARD = register("charred_skeleton_guard", EntityType.Builder.<CharredSkeletonGuardEntity>of(CharredSkeletonGuardEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CharredSkeletonGuardEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NettleEntity>> NETTLE = register("nettle",
			EntityType.Builder.<NettleEntity>of(NettleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NettleEntity::new)

					.sized(0.6f, 1.2f));
	public static final RegistryObject<EntityType<BlazingPhoenixEntity>> BLAZING_PHOENIX = register("blazing_phoenix", EntityType.Builder.<BlazingPhoenixEntity>of(BlazingPhoenixEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlazingPhoenixEntity::new).fireImmune().sized(2f, 2f));
	public static final RegistryObject<EntityType<EarthboundWraithEntity>> EARTHBOUND_WRAITH = register("earthbound_wraith",
			EntityType.Builder.<EarthboundWraithEntity>of(EarthboundWraithEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EarthboundWraithEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EarthShockwaveEntity>> EARTH_SHOCKWAVE = register("earth_shockwave", EntityType.Builder.<EarthShockwaveEntity>of(EarthShockwaveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EarthShockwaveEntity::new).fireImmune().sized(2f, 0.1f));
	public static final RegistryObject<EntityType<CharredMantisEntity>> CHARRED_MANTIS = register("charred_mantis", EntityType.Builder.<CharredMantisEntity>of(CharredMantisEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CharredMantisEntity::new).fireImmune().sized(1.8f, 3.5f));
	public static final RegistryObject<EntityType<NightfallsDemiseProjectileEntity>> NIGHTFALLS_DEMISE_PROJECTILE = register("nightfalls_demise_projectile",
			EntityType.Builder.<NightfallsDemiseProjectileEntity>of(NightfallsDemiseProjectileEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(NightfallsDemiseProjectileEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<CrystalSpearStabEntity>> CRYSTAL_SPEAR_STAB = register("crystal_spear_stab", EntityType.Builder.<CrystalSpearStabEntity>of(CrystalSpearStabEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrystalSpearStabEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<OceanicSplashEntity>> OCEANIC_SPLASH = register("oceanic_splash", EntityType.Builder.<OceanicSplashEntity>of(OceanicSplashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OceanicSplashEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RipsawSawbladeEntity>> RIPSAW_SAWBLADE = register("ripsaw_sawblade", EntityType.Builder.<RipsawSawbladeEntity>of(RipsawSawbladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RipsawSawbladeEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<FirebrandSlashEntity>> FIREBRAND_SLASH = register("firebrand_slash", EntityType.Builder.<FirebrandSlashEntity>of(FirebrandSlashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FirebrandSlashEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<SilkMothEntity>> SILK_MOTH = register("silk_moth",
			EntityType.Builder.<SilkMothEntity>of(SilkMothEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SilkMothEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AtlanticSeaNettleEntity>> ATLANTIC_SEA_NETTLE = register("atlantic_sea_nettle",
			EntityType.Builder.<AtlanticSeaNettleEntity>of(AtlanticSeaNettleEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AtlanticSeaNettleEntity::new)

					.sized(1f, 0.8f));
	public static final RegistryObject<EntityType<FrostBoltProjectileEntity>> FROST_BOLT_PROJECTILE = register("projectile_frost_bolt_projectile", EntityType.Builder.<FrostBoltProjectileEntity>of(FrostBoltProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FrostBoltProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlameProjectileProjectileEntity>> FLAME_PROJECTILE_PROJECTILE = register("projectile_flame_projectile_projectile",
			EntityType.Builder.<FlameProjectileProjectileEntity>of(FlameProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FlameProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StormArrowProjectileEntity>> STORM_ARROW_PROJECTILE = register("projectile_storm_arrow_projectile", EntityType.Builder.<StormArrowProjectileEntity>of(StormArrowProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(StormArrowProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoisonousThornProjectileEntity>> POISONOUS_THORN_PROJECTILE = register("projectile_poisonous_thorn_projectile",
			EntityType.Builder.<PoisonousThornProjectileEntity>of(PoisonousThornProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(PoisonousThornProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GhostPhantomProjectileEntity>> GHOST_PHANTOM_PROJECTILE = register("projectile_ghost_phantom_projectile",
			EntityType.Builder.<GhostPhantomProjectileEntity>of(GhostPhantomProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(GhostPhantomProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ThornSpearProjectileProjectileEntity>> THORN_SPEAR_PROJECTILE_PROJECTILE = register("projectile_thorn_spear_projectile_projectile",
			EntityType.Builder.<ThornSpearProjectileProjectileEntity>of(ThornSpearProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ThornSpearProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TinyThornProjectileEntity>> TINY_THORN_PROJECTILE = register("projectile_tiny_thorn_projectile", EntityType.Builder.<TinyThornProjectileEntity>of(TinyThornProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TinyThornProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShellProjectileEntity>> SHELL_PROJECTILE = register("projectile_shell_projectile", EntityType.Builder.<ShellProjectileEntity>of(ShellProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ShellProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KnifeOfProficiencyProjectileProjectileEntity>> KNIFE_OF_PROFICIENCY_PROJECTILE_PROJECTILE = register("projectile_knife_of_proficiency_projectile_projectile",
			EntityType.Builder.<KnifeOfProficiencyProjectileProjectileEntity>of(KnifeOfProficiencyProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(KnifeOfProficiencyProjectileProjectileEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowFireballProjectileEntity>> SHADOW_FIREBALL_PROJECTILE = register("projectile_shadow_fireball_projectile",
			EntityType.Builder.<ShadowFireballProjectileEntity>of(ShadowFireballProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowFireballProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CrystalRoundProjectileProjectileEntity>> CRYSTAL_ROUND_PROJECTILE_PROJECTILE = register("projectile_crystal_round_projectile_projectile",
			EntityType.Builder.<CrystalRoundProjectileProjectileEntity>of(CrystalRoundProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CrystalRoundProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VenomousBulletProjectileProjectileEntity>> VENOMOUS_BULLET_PROJECTILE_PROJECTILE = register("projectile_venomous_bullet_projectile_projectile",
			EntityType.Builder.<VenomousBulletProjectileProjectileEntity>of(VenomousBulletProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(VenomousBulletProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ElectrifiedRoundProjectileProjectileEntity>> ELECTRIFIED_ROUND_PROJECTILE_PROJECTILE = register("projectile_electrified_round_projectile_projectile",
			EntityType.Builder.<ElectrifiedRoundProjectileProjectileEntity>of(ElectrifiedRoundProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ElectrifiedRoundProjectileProjectileEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HealingOrbProjectileEntity>> HEALING_ORB_PROJECTILE = register("projectile_healing_orb_projectile", EntityType.Builder.<HealingOrbProjectileEntity>of(HealingOrbProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(HealingOrbProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NatureBlastProjectileEntity>> NATURE_BLAST_PROJECTILE = register("projectile_nature_blast_projectile",
			EntityType.Builder.<NatureBlastProjectileEntity>of(NatureBlastProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(NatureBlastProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowfireSoulProjectileEntity>> SHADOWFIRE_SOUL_PROJECTILE = register("projectile_shadowfire_soul_projectile",
			EntityType.Builder.<ShadowfireSoulProjectileEntity>of(ShadowfireSoulProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowfireSoulProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowFireSoulFriendlyProjectileEntity>> SHADOW_FIRE_SOUL_FRIENDLY_PROJECTILE = register("projectile_shadow_fire_soul_friendly_projectile",
			EntityType.Builder.<ShadowFireSoulFriendlyProjectileEntity>of(ShadowFireSoulFriendlyProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowFireSoulFriendlyProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowfireSkullProjectileEntity>> SHADOWFIRE_SKULL_PROJECTILE = register("projectile_shadowfire_skull_projectile",
			EntityType.Builder.<ShadowfireSkullProjectileEntity>of(ShadowfireSkullProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowfireSkullProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SporeProjectileEntity>> SPORE_PROJECTILE = register("projectile_spore_projectile", EntityType.Builder.<SporeProjectileEntity>of(SporeProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SporeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VulnerabilitySkullProjectileEntity>> VULNERABILITY_SKULL_PROJECTILE = register("projectile_vulnerability_skull_projectile",
			EntityType.Builder.<VulnerabilitySkullProjectileEntity>of(VulnerabilitySkullProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(VulnerabilitySkullProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowfireSoulNoGravityProjectileEntity>> SHADOWFIRE_SOUL_NO_GRAVITY_PROJECTILE = register("projectile_shadowfire_soul_no_gravity_projectile",
			EntityType.Builder.<ShadowfireSoulNoGravityProjectileEntity>of(ShadowfireSoulNoGravityProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ShadowfireSoulNoGravityProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NohomingHealingOrbProjectileEntity>> NOHOMING_HEALING_ORB_PROJECTILE = register("projectile_nohoming_healing_orb_projectile",
			EntityType.Builder.<NohomingHealingOrbProjectileEntity>of(NohomingHealingOrbProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(NohomingHealingOrbProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceShardProjectileEntity>> ICE_SHARD_PROJECTILE = register("projectile_ice_shard_projectile", EntityType.Builder.<IceShardProjectileEntity>of(IceShardProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(IceShardProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FriendlyPoisonousThornProjectileEntity>> FRIENDLY_POISONOUS_THORN_PROJECTILE = register("projectile_friendly_poisonous_thorn_projectile",
			EntityType.Builder.<FriendlyPoisonousThornProjectileEntity>of(FriendlyPoisonousThornProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FriendlyPoisonousThornProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FierySlashProjectileEntity>> FIERY_SLASH_PROJECTILE = register("projectile_fiery_slash_projectile", EntityType.Builder.<FierySlashProjectileEntity>of(FierySlashProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FierySlashProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CrystalShardProjectileEntity>> CRYSTAL_SHARD_PROJECTILE = register("projectile_crystal_shard_projectile",
			EntityType.Builder.<CrystalShardProjectileEntity>of(CrystalShardProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CrystalShardProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlazingFeatherProjectileEntity>> BLAZING_FEATHER_PROJECTILE = register("projectile_blazing_feather_projectile",
			EntityType.Builder.<BlazingFeatherProjectileEntity>of(BlazingFeatherProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(BlazingFeatherProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HealingBlossomProjectileEntity>> HEALING_BLOSSOM_PROJECTILE = register("projectile_healing_blossom_projectile",
			EntityType.Builder.<HealingBlossomProjectileEntity>of(HealingBlossomProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(HealingBlossomProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EarthboundRockProjectileEntity>> EARTHBOUND_ROCK_PROJECTILE = register("projectile_earthbound_rock_projectile",
			EntityType.Builder.<EarthboundRockProjectileEntity>of(EarthboundRockProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(EarthboundRockProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EarthShattererProjectileProjectileEntity>> EARTH_SHATTERER_PROJECTILE_PROJECTILE = register("projectile_earth_shatterer_projectile_projectile",
			EntityType.Builder.<EarthShattererProjectileProjectileEntity>of(EarthShattererProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(EarthShattererProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EarthboundRockShardProjectileEntity>> EARTHBOUND_ROCK_SHARD_PROJECTILE = register("projectile_earthbound_rock_shard_projectile",
			EntityType.Builder.<EarthboundRockShardProjectileEntity>of(EarthboundRockShardProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(EarthboundRockShardProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LifedrainArrowProjectileEntity>> LIFEDRAIN_ARROW_PROJECTILE = register("projectile_lifedrain_arrow_projectile",
			EntityType.Builder.<LifedrainArrowProjectileEntity>of(LifedrainArrowProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(LifedrainArrowProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VeinStrikerProjectileProjectileEntity>> VEIN_STRIKER_PROJECTILE_PROJECTILE = register("projectile_vein_striker_projectile_projectile",
			EntityType.Builder.<VeinStrikerProjectileProjectileEntity>of(VeinStrikerProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(VeinStrikerProjectileProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VeinStrikerBloodKnifeProjectileProjectileEntity>> VEIN_STRIKER_BLOOD_KNIFE_PROJECTILE_PROJECTILE = register("projectile_vein_striker_blood_knife_projectile_projectile",
			EntityType.Builder.<VeinStrikerBloodKnifeProjectileProjectileEntity>of(VeinStrikerBloodKnifeProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(VeinStrikerBloodKnifeProjectileProjectileEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloodKnifeProjectileEntity>> BLOOD_KNIFE_PROJECTILE = register("projectile_blood_knife_projectile", EntityType.Builder.<BloodKnifeProjectileEntity>of(BloodKnifeProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BloodKnifeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FieryRoundProjectileEntity>> FIERY_ROUND_PROJECTILE = register("projectile_fiery_round_projectile", EntityType.Builder.<FieryRoundProjectileEntity>of(FieryRoundProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FieryRoundProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrozenShieldIceSpikeProjectileEntity>> FROZEN_SHIELD_ICE_SPIKE_PROJECTILE = register("projectile_frozen_shield_ice_spike_projectile",
			EntityType.Builder.<FrozenShieldIceSpikeProjectileEntity>of(FrozenShieldIceSpikeProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FrozenShieldIceSpikeProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlizzardProjectileEntity>> BLIZZARD_PROJECTILE = register("projectile_blizzard_projectile", EntityType.Builder.<BlizzardProjectileEntity>of(BlizzardProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BlizzardProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AnglerfishEntity>> ANGLERFISH = register("anglerfish",
			EntityType.Builder.<AnglerfishEntity>of(AnglerfishEntity::new, MobCategory.UNDERGROUND_WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AnglerfishEntity::new)

					.sized(0.8f, 0.6f));
	public static final RegistryObject<EntityType<AccursedDaggerEntity>> ACCURSED_DAGGER = register("projectile_accursed_dagger",
			EntityType.Builder.<AccursedDaggerEntity>of(AccursedDaggerEntity::new, MobCategory.MISC).setCustomClientFactory(AccursedDaggerEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ElectricSparkProjectileEntity>> ELECTRIC_SPARK_PROJECTILE = register("projectile_electric_spark_projectile",
			EntityType.Builder.<ElectricSparkProjectileEntity>of(ElectricSparkProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ElectricSparkProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HuntsmanKnifeProjectileEntity>> HUNTSMAN_KNIFE_PROJECTILE = register("projectile_huntsman_knife_projectile",
			EntityType.Builder.<HuntsmanKnifeProjectileEntity>of(HuntsmanKnifeProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(HuntsmanKnifeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CactusNeedleEntity>> CACTUS_NEEDLE = register("projectile_cactus_needle",
			EntityType.Builder.<CactusNeedleEntity>of(CactusNeedleEntity::new, MobCategory.MISC).setCustomClientFactory(CactusNeedleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HauntedMirrorEntityEntity>> HAUNTED_MIRROR_ENTITY = register("haunted_mirror_entity", EntityType.Builder.<HauntedMirrorEntityEntity>of(HauntedMirrorEntityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HauntedMirrorEntityEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<AccursedSoulEntity>> ACCURSED_SOUL = register("projectile_accursed_soul",
			EntityType.Builder.<AccursedSoulEntity>of(AccursedSoulEntity::new, MobCategory.MISC).setCustomClientFactory(AccursedSoulEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StarlitLacewingEntity>> STARLIT_LACEWING = register("starlit_lacewing",
			EntityType.Builder.<StarlitLacewingEntity>of(StarlitLacewingEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StarlitLacewingEntity::new)

					.sized(0.4f, 0.2f));
	public static final RegistryObject<EntityType<DiamondDetonationBombEntity>> DIAMOND_DETONATION_BOMB = register("diamond_detonation_bomb", EntityType.Builder.<DiamondDetonationBombEntity>of(DiamondDetonationBombEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DiamondDetonationBombEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<GiantIsopodEntity>> GIANT_ISOPOD = register("giant_isopod",
			EntityType.Builder.<GiantIsopodEntity>of(GiantIsopodEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GiantIsopodEntity::new)

					.sized(0.8f, 0.8f));
	public static final RegistryObject<EntityType<ElectrifiedSwordProjectileEntity>> ELECTRIFIED_SWORD_PROJECTILE = register("electrified_sword_projectile",
			EntityType.Builder.<ElectrifiedSwordProjectileEntity>of(ElectrifiedSwordProjectileEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(ElectrifiedSwordProjectileEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<ForceMissileEntity>> FORCE_MISSILE = register("projectile_force_missile",
			EntityType.Builder.<ForceMissileEntity>of(ForceMissileEntity::new, MobCategory.MISC).setCustomClientFactory(ForceMissileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SeaCrystalShardProjectileEntity>> SEA_CRYSTAL_SHARD_PROJECTILE = register("projectile_sea_crystal_shard_projectile",
			EntityType.Builder.<SeaCrystalShardProjectileEntity>of(SeaCrystalShardProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(SeaCrystalShardProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SeaCrystalRiptideProjectileEntity>> SEA_CRYSTAL_RIPTIDE_PROJECTILE = register("sea_crystal_riptide_projectile",
			EntityType.Builder.<SeaCrystalRiptideProjectileEntity>of(SeaCrystalRiptideProjectileEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(SeaCrystalRiptideProjectileEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<VoltbladeEntity>> VOLTBLADE = register("voltblade",
			EntityType.Builder.<VoltbladeEntity>of(VoltbladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoltbladeEntity::new).fireImmune().sized(0.7f, 2f));
	public static final RegistryObject<EntityType<FriendlySwordOrbitEntity>> FRIENDLY_SWORD_ORBIT = register("friendly_sword_orbit", EntityType.Builder.<FriendlySwordOrbitEntity>of(FriendlySwordOrbitEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FriendlySwordOrbitEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<ElectrifiedLightningEntity>> ELECTRIFIED_LIGHTNING = register("electrified_lightning", EntityType.Builder.<ElectrifiedLightningEntity>of(ElectrifiedLightningEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ElectrifiedLightningEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<ArcStrikerEntity>> ARC_STRIKER = register("arc_striker", EntityType.Builder.<ArcStrikerEntity>of(ArcStrikerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(ArcStrikerEntity::new).fireImmune().sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<SurgeBreakerEntity>> SURGE_BREAKER = register("surge_breaker", EntityType.Builder.<SurgeBreakerEntity>of(SurgeBreakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SurgeBreakerEntity::new).fireImmune().sized(0.9f, 2.2f));
	public static final RegistryObject<EntityType<AccursedWitchEntity>> ACCURSED_WITCH = register("accursed_witch",
			EntityType.Builder.<AccursedWitchEntity>of(AccursedWitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AccursedWitchEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RustyScrapProjectileEntity>> RUSTY_SCRAP_PROJECTILE = register("projectile_rusty_scrap_projectile", EntityType.Builder.<RustyScrapProjectileEntity>of(RustyScrapProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(RustyScrapProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AccursedArrowProjectileEntity>> ACCURSED_ARROW_PROJECTILE = register("projectile_accursed_arrow_projectile",
			EntityType.Builder.<AccursedArrowProjectileEntity>of(AccursedArrowProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(AccursedArrowProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NailgunNailEntity>> NAILGUN_NAIL = register("projectile_nailgun_nail",
			EntityType.Builder.<NailgunNailEntity>of(NailgunNailEntity::new, MobCategory.MISC).setCustomClientFactory(NailgunNailEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ScrapRoundProjectileEntity>> SCRAP_ROUND_PROJECTILE = register("projectile_scrap_round_projectile", EntityType.Builder.<ScrapRoundProjectileEntity>of(ScrapRoundProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ScrapRoundProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CopperRoundProjectileEntity>> COPPER_ROUND_PROJECTILE = register("projectile_copper_round_projectile",
			EntityType.Builder.<CopperRoundProjectileEntity>of(CopperRoundProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CopperRoundProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FieryBoltEntity>> FIERY_BOLT = register("projectile_fiery_bolt",
			EntityType.Builder.<FieryBoltEntity>of(FieryBoltEntity::new, MobCategory.MISC).setCustomClientFactory(FieryBoltEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NightReaperEntity>> NIGHT_REAPER = register("night_reaper",
			EntityType.Builder.<NightReaperEntity>of(NightReaperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NightReaperEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<StarlitLacewingMinionEntity>> STARLIT_LACEWING_MINION = register("starlit_lacewing_minion", EntityType.Builder.<StarlitLacewingMinionEntity>of(StarlitLacewingMinionEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StarlitLacewingMinionEntity::new).fireImmune().sized(0.4f, 0.2f));
	public static final RegistryObject<EntityType<StormsmithEntity>> STORMSMITH = register("stormsmith", EntityType.Builder.<StormsmithEntity>of(StormsmithEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(StormsmithEntity::new).fireImmune().sized(2f, 3.5f));
	public static final RegistryObject<EntityType<TideSlashProjectileEntity>> TIDE_SLASH_PROJECTILE = register("tide_slash_projectile", EntityType.Builder.<TideSlashProjectileEntity>of(TideSlashProjectileEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TideSlashProjectileEntity::new).fireImmune().sized(0.4f, 0.4f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TiaDashEntity.init();
			ThornInfestedArmorEntity.init();
			MineralWraithEntity.init();
			SwordspinEntity.init();
			WraithDashEntity.init();
			SwordSpinDashEntity.init();
			SwordDashEntity.init();
			HermitCrabEntity.init();
			LightningBladeEntity.init();
			SporeZombieEntity.init();
			ThornTentacleEntity.init();
			CalicoStagBeetleEntity.init();
			ShadeEntity.init();
			SepulcherEntity.init();
			ShadowflameSpearsEntity.init();
			CharredSkeletonGuardEntity.init();
			NettleEntity.init();
			BlazingPhoenixEntity.init();
			EarthboundWraithEntity.init();
			EarthShockwaveEntity.init();
			CharredMantisEntity.init();
			NightfallsDemiseProjectileEntity.init();
			CrystalSpearStabEntity.init();
			OceanicSplashEntity.init();
			RipsawSawbladeEntity.init();
			FirebrandSlashEntity.init();
			SilkMothEntity.init();
			AtlanticSeaNettleEntity.init();
			AnglerfishEntity.init();
			HauntedMirrorEntityEntity.init();
			StarlitLacewingEntity.init();
			DiamondDetonationBombEntity.init();
			GiantIsopodEntity.init();
			ElectrifiedSwordProjectileEntity.init();
			SeaCrystalRiptideProjectileEntity.init();
			VoltbladeEntity.init();
			FriendlySwordOrbitEntity.init();
			ElectrifiedLightningEntity.init();
			ArcStrikerEntity.init();
			SurgeBreakerEntity.init();
			AccursedWitchEntity.init();
			NightReaperEntity.init();
			StarlitLacewingMinionEntity.init();
			StormsmithEntity.init();
			TideSlashProjectileEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TIA_DASH.get(), TiaDashEntity.createAttributes().build());
		event.put(THORN_INFESTED_ARMOR.get(), ThornInfestedArmorEntity.createAttributes().build());
		event.put(MINERAL_WRAITH.get(), MineralWraithEntity.createAttributes().build());
		event.put(SWORDSPIN.get(), SwordspinEntity.createAttributes().build());
		event.put(WRAITH_DASH.get(), WraithDashEntity.createAttributes().build());
		event.put(SWORD_SPIN_DASH.get(), SwordSpinDashEntity.createAttributes().build());
		event.put(SWORD_DASH.get(), SwordDashEntity.createAttributes().build());
		event.put(HERMIT_CRAB.get(), HermitCrabEntity.createAttributes().build());
		event.put(LIGHTNING_BLADE.get(), LightningBladeEntity.createAttributes().build());
		event.put(SPORE_ZOMBIE.get(), SporeZombieEntity.createAttributes().build());
		event.put(THORN_TENTACLE.get(), ThornTentacleEntity.createAttributes().build());
		event.put(CALICO_STAG_BEETLE.get(), CalicoStagBeetleEntity.createAttributes().build());
		event.put(SHADE.get(), ShadeEntity.createAttributes().build());
		event.put(SEPULCHER.get(), SepulcherEntity.createAttributes().build());
		event.put(SHADOWFLAME_SPEARS.get(), ShadowflameSpearsEntity.createAttributes().build());
		event.put(CHARRED_SKELETON_GUARD.get(), CharredSkeletonGuardEntity.createAttributes().build());
		event.put(NETTLE.get(), NettleEntity.createAttributes().build());
		event.put(BLAZING_PHOENIX.get(), BlazingPhoenixEntity.createAttributes().build());
		event.put(EARTHBOUND_WRAITH.get(), EarthboundWraithEntity.createAttributes().build());
		event.put(EARTH_SHOCKWAVE.get(), EarthShockwaveEntity.createAttributes().build());
		event.put(CHARRED_MANTIS.get(), CharredMantisEntity.createAttributes().build());
		event.put(NIGHTFALLS_DEMISE_PROJECTILE.get(), NightfallsDemiseProjectileEntity.createAttributes().build());
		event.put(CRYSTAL_SPEAR_STAB.get(), CrystalSpearStabEntity.createAttributes().build());
		event.put(OCEANIC_SPLASH.get(), OceanicSplashEntity.createAttributes().build());
		event.put(RIPSAW_SAWBLADE.get(), RipsawSawbladeEntity.createAttributes().build());
		event.put(FIREBRAND_SLASH.get(), FirebrandSlashEntity.createAttributes().build());
		event.put(SILK_MOTH.get(), SilkMothEntity.createAttributes().build());
		event.put(ATLANTIC_SEA_NETTLE.get(), AtlanticSeaNettleEntity.createAttributes().build());
		event.put(ANGLERFISH.get(), AnglerfishEntity.createAttributes().build());
		event.put(HAUNTED_MIRROR_ENTITY.get(), HauntedMirrorEntityEntity.createAttributes().build());
		event.put(STARLIT_LACEWING.get(), StarlitLacewingEntity.createAttributes().build());
		event.put(DIAMOND_DETONATION_BOMB.get(), DiamondDetonationBombEntity.createAttributes().build());
		event.put(GIANT_ISOPOD.get(), GiantIsopodEntity.createAttributes().build());
		event.put(ELECTRIFIED_SWORD_PROJECTILE.get(), ElectrifiedSwordProjectileEntity.createAttributes().build());
		event.put(SEA_CRYSTAL_RIPTIDE_PROJECTILE.get(), SeaCrystalRiptideProjectileEntity.createAttributes().build());
		event.put(VOLTBLADE.get(), VoltbladeEntity.createAttributes().build());
		event.put(FRIENDLY_SWORD_ORBIT.get(), FriendlySwordOrbitEntity.createAttributes().build());
		event.put(ELECTRIFIED_LIGHTNING.get(), ElectrifiedLightningEntity.createAttributes().build());
		event.put(ARC_STRIKER.get(), ArcStrikerEntity.createAttributes().build());
		event.put(SURGE_BREAKER.get(), SurgeBreakerEntity.createAttributes().build());
		event.put(ACCURSED_WITCH.get(), AccursedWitchEntity.createAttributes().build());
		event.put(NIGHT_REAPER.get(), NightReaperEntity.createAttributes().build());
		event.put(STARLIT_LACEWING_MINION.get(), StarlitLacewingMinionEntity.createAttributes().build());
		event.put(STORMSMITH.get(), StormsmithEntity.createAttributes().build());
		event.put(TIDE_SLASH_PROJECTILE.get(), TideSlashProjectileEntity.createAttributes().build());
	}
}

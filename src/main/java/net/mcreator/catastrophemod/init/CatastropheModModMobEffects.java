
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.potion.VulnerabilityMobEffect;
import net.mcreator.catastrophemod.potion.StunnedMobEffect;
import net.mcreator.catastrophemod.potion.RepulsionMobEffect;
import net.mcreator.catastrophemod.potion.PrickedMobEffect;
import net.mcreator.catastrophemod.potion.PhaseDashCooldownMobEffect;
import net.mcreator.catastrophemod.potion.ManaSicknessMobEffect;
import net.mcreator.catastrophemod.potion.IntelligenceMobEffect;
import net.mcreator.catastrophemod.potion.IncinerationMobEffect;
import net.mcreator.catastrophemod.potion.ImpedanceMobEffect;
import net.mcreator.catastrophemod.potion.FallDamageImmunityMobEffect;
import net.mcreator.catastrophemod.potion.ElectrifiedMobEffect;
import net.mcreator.catastrophemod.potion.DashCooldownMobEffect;
import net.mcreator.catastrophemod.potion.BullseyeMobEffect;
import net.mcreator.catastrophemod.potion.BrassSpeedMobEffect;
import net.mcreator.catastrophemod.potion.BrassAttackSpeedMobEffect;
import net.mcreator.catastrophemod.potion.BossDashMobEffect;
import net.mcreator.catastrophemod.potion.BleedingMobEffect;
import net.mcreator.catastrophemod.potion.ArmorShredMobEffect;
import net.mcreator.catastrophemod.potion.AmatoxinMobEffect;
import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CatastropheModMod.MODID);
	public static final RegistryObject<MobEffect> DASH_COOLDOWN = REGISTRY.register("dash_cooldown", () -> new DashCooldownMobEffect());
	public static final RegistryObject<MobEffect> FALL_DAMAGE_IMMUNITY = REGISTRY.register("fall_damage_immunity", () -> new FallDamageImmunityMobEffect());
	public static final RegistryObject<MobEffect> BOSS_DASH = REGISTRY.register("boss_dash", () -> new BossDashMobEffect());
	public static final RegistryObject<MobEffect> INCINERATION = REGISTRY.register("incineration", () -> new IncinerationMobEffect());
	public static final RegistryObject<MobEffect> ELECTRIFIED = REGISTRY.register("electrified", () -> new ElectrifiedMobEffect());
	public static final RegistryObject<MobEffect> VULNERABILITY = REGISTRY.register("vulnerability", () -> new VulnerabilityMobEffect());
	public static final RegistryObject<MobEffect> BULLSEYE = REGISTRY.register("bullseye", () -> new BullseyeMobEffect());
	public static final RegistryObject<MobEffect> INTELLIGENCE = REGISTRY.register("intelligence", () -> new IntelligenceMobEffect());
	public static final RegistryObject<MobEffect> AMATOXIN = REGISTRY.register("amatoxin", () -> new AmatoxinMobEffect());
	public static final RegistryObject<MobEffect> PRICKED = REGISTRY.register("pricked", () -> new PrickedMobEffect());
	public static final RegistryObject<MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final RegistryObject<MobEffect> MANA_SICKNESS = REGISTRY.register("mana_sickness", () -> new ManaSicknessMobEffect());
	public static final RegistryObject<MobEffect> PHASE_DASH_COOLDOWN = REGISTRY.register("phase_dash_cooldown", () -> new PhaseDashCooldownMobEffect());
	public static final RegistryObject<MobEffect> ARMOR_SHRED = REGISTRY.register("armor_shred", () -> new ArmorShredMobEffect());
	public static final RegistryObject<MobEffect> REPULSION = REGISTRY.register("repulsion", () -> new RepulsionMobEffect());
	public static final RegistryObject<MobEffect> IMPEDANCE = REGISTRY.register("impedance", () -> new ImpedanceMobEffect());
	public static final RegistryObject<MobEffect> STUNNED = REGISTRY.register("stunned", () -> new StunnedMobEffect());
	public static final RegistryObject<MobEffect> BRASS_SPEED = REGISTRY.register("brass_speed", () -> new BrassSpeedMobEffect());
	public static final RegistryObject<MobEffect> BRASS_ATTACK_SPEED = REGISTRY.register("brass_attack_speed", () -> new BrassAttackSpeedMobEffect());
}

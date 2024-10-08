
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.catastrophemod.enchantment.WizardryEnchantment;
import net.mcreator.catastrophemod.enchantment.SwiftStepEnchantment;
import net.mcreator.catastrophemod.enchantment.SpikedEnchantment;
import net.mcreator.catastrophemod.enchantment.SpellcastingEnchantment;
import net.mcreator.catastrophemod.enchantment.ResilienceEnchantment;
import net.mcreator.catastrophemod.enchantment.PreservationEnchantment;
import net.mcreator.catastrophemod.enchantment.NourishmentEnchantment;
import net.mcreator.catastrophemod.enchantment.MagnetismEnchantment;
import net.mcreator.catastrophemod.enchantment.ImpalementEnchantment;
import net.mcreator.catastrophemod.enchantment.GravitationalRefluxEnchantment;
import net.mcreator.catastrophemod.enchantment.FrostbiteEnchantment;
import net.mcreator.catastrophemod.enchantment.FrostAspectEnchantment;
import net.mcreator.catastrophemod.enchantment.CounterattackEnchantment;
import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, CatastropheModMod.MODID);
	public static final RegistryObject<Enchantment> FROST_ASPECT = REGISTRY.register("frost_aspect", () -> new FrostAspectEnchantment());
	public static final RegistryObject<Enchantment> MAGNETISM = REGISTRY.register("magnetism", () -> new MagnetismEnchantment());
	public static final RegistryObject<Enchantment> FROSTBITE = REGISTRY.register("frostbite", () -> new FrostbiteEnchantment());
	public static final RegistryObject<Enchantment> RESILIENCE = REGISTRY.register("resilience", () -> new ResilienceEnchantment());
	public static final RegistryObject<Enchantment> IMPALEMENT = REGISTRY.register("impalement", () -> new ImpalementEnchantment());
	public static final RegistryObject<Enchantment> SPELLCASTING = REGISTRY.register("spellcasting", () -> new SpellcastingEnchantment());
	public static final RegistryObject<Enchantment> WIZARDRY = REGISTRY.register("wizardry", () -> new WizardryEnchantment());
	public static final RegistryObject<Enchantment> COUNTERATTACK = REGISTRY.register("counterattack", () -> new CounterattackEnchantment());
	public static final RegistryObject<Enchantment> SPIKED = REGISTRY.register("spiked", () -> new SpikedEnchantment());
	public static final RegistryObject<Enchantment> SWIFT_STEP = REGISTRY.register("swift_step", () -> new SwiftStepEnchantment());
	public static final RegistryObject<Enchantment> NOURISHMENT = REGISTRY.register("nourishment", () -> new NourishmentEnchantment());
	public static final RegistryObject<Enchantment> PRESERVATION = REGISTRY.register("preservation", () -> new PreservationEnchantment());
	public static final RegistryObject<Enchantment> GRAVITATIONAL_REFLUX = REGISTRY.register("gravitational_reflux", () -> new GravitationalRefluxEnchantment());
}

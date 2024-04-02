
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, CatastropheModMod.MODID);
	public static final RegistryObject<Potion> BULLSEYE_POTION = REGISTRY.register("bullseye_potion", () -> new Potion(new MobEffectInstance(CatastropheModModMobEffects.BULLSEYE.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> BULLSEYE_POTION_LONG = REGISTRY.register("bullseye_potion_long", () -> new Potion(new MobEffectInstance(CatastropheModModMobEffects.BULLSEYE.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> BULLSEYE_POTION_STRONG = REGISTRY.register("bullseye_potion_strong", () -> new Potion(new MobEffectInstance(CatastropheModModMobEffects.BULLSEYE.get(), 1800, 1, false, true)));
	public static final RegistryObject<Potion> INTELLIGENCE_POTION = REGISTRY.register("intelligence_potion", () -> new Potion(new MobEffectInstance(CatastropheModModMobEffects.INTELLIGENCE.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> INTELLIGENCE_LONG = REGISTRY.register("intelligence_long", () -> new Potion(new MobEffectInstance(CatastropheModModMobEffects.INTELLIGENCE.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> INTELLIGENCE_STRONG = REGISTRY.register("intelligence_strong", () -> new Potion(new MobEffectInstance(CatastropheModModMobEffects.INTELLIGENCE.get(), 1800, 1, false, true)));
}

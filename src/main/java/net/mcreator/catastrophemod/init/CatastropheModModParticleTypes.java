
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CatastropheModMod.MODID);
	public static final RegistryObject<SimpleParticleType> POISON_TRAIL = REGISTRY.register("poison_trail", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DASH_INDICATOR = REGISTRY.register("dash_indicator", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ELECTRIFIED_SPARK = REGISTRY.register("electrified_spark", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> WHIRLPOOL = REGISTRY.register("whirlpool", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> FLAME_EXPLOSION = REGISTRY.register("flame_explosion", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> HEALING_SPARK = REGISTRY.register("healing_spark", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> AMATOXIN_GAS = REGISTRY.register("amatoxin_gas", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLOOD_DROP = REGISTRY.register("blood_drop", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CRYSTAL_SPARK = REGISTRY.register("crystal_spark", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SNOWFLAKE = REGISTRY.register("snowflake", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PURPLE_CURSED_SPARK = REGISTRY.register("purple_cursed_spark", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GREEN_CURSED_SPARK = REGISTRY.register("green_cursed_spark", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLIZZARD_WIND = REGISTRY.register("blizzard_wind", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ELECTRIFIED_TRAIL = REGISTRY.register("electrified_trail", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PHANTOM_BLAST = REGISTRY.register("phantom_blast", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PHANTOM_BLAST_GLOW = REGISTRY.register("phantom_blast_glow", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SPARK = REGISTRY.register("spark", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CRYSTAL_BLAST = REGISTRY.register("crystal_blast", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ACCURSED_SHIMMER = REGISTRY.register("accursed_shimmer", () -> new SimpleParticleType(true));
}

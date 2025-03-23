
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.catastrophemod.world.features.ManaRosePlantFeatureFeature;
import net.mcreator.catastrophemod.CatastropheModMod;

@Mod.EventBusSubscriber
public class CatastropheModModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, CatastropheModMod.MODID);
	public static final RegistryObject<Feature<?>> MANA_ROSE_PLANT_FEATURE = REGISTRY.register("mana_rose_plant_feature", ManaRosePlantFeatureFeature::new);
}

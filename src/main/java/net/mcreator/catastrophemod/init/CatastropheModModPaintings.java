
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, CatastropheModMod.MODID);
	public static final RegistryObject<PaintingVariant> ALEXS_MOD_LOGO = REGISTRY.register("alexs_mod_logo", () -> new PaintingVariant(16, 16));
}

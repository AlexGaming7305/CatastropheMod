
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.catastrophemod.world.inventory.BackPackScreenMenu;
import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CatastropheModMod.MODID);
	public static final RegistryObject<MenuType<BackPackScreenMenu>> BACK_PACK_SCREEN = REGISTRY.register("back_pack_screen", () -> IForgeMenuType.create(BackPackScreenMenu::new));
}

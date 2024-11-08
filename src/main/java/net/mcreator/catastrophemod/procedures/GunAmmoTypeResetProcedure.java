package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.item.ItemStack;

public class GunAmmoTypeResetProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("ammo") == 0) {
			itemstack.getOrCreateTag().putBoolean("copper_round", false);
			itemstack.getOrCreateTag().putBoolean("scrap_round", false);
			itemstack.getOrCreateTag().putBoolean("crystal_round", false);
			itemstack.getOrCreateTag().putBoolean("electrified_round", false);
			itemstack.getOrCreateTag().putBoolean("venomous_round", false);
		}
	}
}

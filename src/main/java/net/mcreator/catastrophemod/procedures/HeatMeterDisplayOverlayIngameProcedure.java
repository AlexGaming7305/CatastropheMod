package net.mcreator.catastrophemod.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

public class HeatMeterDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.BURNACE.get(), lv).isPresent() : false) {
			return true;
		}
		return false;
	}
}

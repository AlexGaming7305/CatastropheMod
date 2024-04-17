package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class AnglerfishOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).getBaseValue() != 3.5) {
			((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(3.5);
		}
	}
}

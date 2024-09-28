package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class JellyfishPendantBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).getBaseValue() + 1));
	}
}

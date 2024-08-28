package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

public class CrystalBallBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAXMANA.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAXMANA.get()).getBaseValue() + 40));
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).getBaseValue() + 12));
	}
}

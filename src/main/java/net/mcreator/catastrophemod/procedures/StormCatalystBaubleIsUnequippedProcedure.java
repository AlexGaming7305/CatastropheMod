package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

public class StormCatalystBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAGICDAMAGE.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAGICDAMAGE.get()).getBaseValue() - 5));
	}
}

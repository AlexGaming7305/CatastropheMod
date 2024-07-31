package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

public class BarbedArrowheadBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()).getBaseValue() - 5));
	}
}

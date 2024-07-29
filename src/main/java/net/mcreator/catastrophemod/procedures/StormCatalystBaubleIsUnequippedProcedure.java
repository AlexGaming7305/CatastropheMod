package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StormCatalystBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAGICDAMAGE.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAGICDAMAGE.get()).getBaseValue() - 5));
	}
}

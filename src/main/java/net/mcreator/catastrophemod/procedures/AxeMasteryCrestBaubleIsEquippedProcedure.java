package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AxeMasteryCrestBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.AXEDAMAGE.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.AXEDAMAGE.get()).getBaseValue() + 5));
	}
}

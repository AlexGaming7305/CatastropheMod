package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SpearMasteryCrestBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.SPEARDAMAGE.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.SPEARDAMAGE.get()).getBaseValue() - 5));
	}
}

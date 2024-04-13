package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class RingOfResilienceBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.DAMAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.DAMAGEREDUCTION.get()).getBaseValue() - 5));
	}
}

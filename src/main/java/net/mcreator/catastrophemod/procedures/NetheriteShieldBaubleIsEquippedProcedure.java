package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

public class NetheriteShieldBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
				.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue() + 2));
		((LivingEntity) entity).getAttribute(CatastropheModModAttributes.DAMAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.DAMAGEREDUCTION.get()).getBaseValue() + 10));
	}
}

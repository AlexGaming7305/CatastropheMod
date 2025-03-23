package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

public class SpiritInABottleBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).spirit_in_a_bottle_equipped == false) {
			{
				boolean _setval = true;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.spirit_in_a_bottle_equipped = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MINIONSLOTS.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MINIONSLOTS.get()).getBaseValue() + 1));
		}
	}
}

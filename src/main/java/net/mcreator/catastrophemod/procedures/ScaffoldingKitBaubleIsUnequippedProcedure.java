package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

public class ScaffoldingKitBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).scaffolding_kit_equipped == true) {
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.scaffolding_kit_equipped = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()).getBaseValue() - 1));
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaUsageReductionProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).mana_cost_accursed_tome != 6
				- Math.ceil((6 * ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).getBaseValue()) / 100)) {
			{
				double _setval = 6 - Math.ceil((6 * ((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).getBaseValue()) / 100);
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mana_cost_accursed_tome = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

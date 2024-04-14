package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AccessorySlotsNotEquipedProcedure {
	@SubscribeEvent
	public static void onCurioUnequip(CurioChangeEvent event) {
		execute(event, event.getEntity(), event.getFrom());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == CatastropheModModItems.POCKET_SHIELD_GENERATOR.get()) {
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.pocketshield = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (itemstack.getItem() == CatastropheModModItems.STORM_SHIELD.get()) {
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stormshield = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

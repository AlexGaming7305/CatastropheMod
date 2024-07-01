package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RingOfResilienceFixProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.RING_OF_RESILIENCE.get(), lv).isPresent() : false) {
			((LivingEntity) entity).getAttribute(CatastropheModModAttributes.DAMAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.DAMAGEREDUCTION.get()).getBaseValue() - 5));
		}
	}
}

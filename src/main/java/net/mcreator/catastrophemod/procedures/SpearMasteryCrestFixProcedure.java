package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpearMasteryCrestFixProcedure {
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
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.SPEAR_MASTERY_CREST.get(), lv).isPresent() : false) {
			((LivingEntity) entity).getAttribute(CatastropheModModAttributes.SPEARDAMAGE.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.SPEARDAMAGE.get()).getBaseValue() - 5));
			((LivingEntity) entity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()).getBaseValue() - 5));
		}
	}
}

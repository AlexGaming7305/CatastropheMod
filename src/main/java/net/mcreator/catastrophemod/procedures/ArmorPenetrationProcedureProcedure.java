package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ArmorPenetrationProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		Entity entity = event.getEntity();
		if (event != null && entity != null) {
			execute(event, entity, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()) != null) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > ((LivingEntity) sourceentity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()).getBaseValue()) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + ((LivingEntity) sourceentity).getAttribute(CatastropheModModAttributes.ARMORPENETRATION.get()).getBaseValue() / 2;
				event2.setAmount((float) damage);
			} else {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 2;
				event2.setAmount((float) damage);
			}
		}
	}
}

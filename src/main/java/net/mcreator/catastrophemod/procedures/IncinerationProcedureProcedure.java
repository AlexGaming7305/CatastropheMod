package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IncinerationProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double damage = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.INCINERATION.get()) && entity.isOnFire()) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + 1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.INCINERATION.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.INCINERATION.get()).getAmplifier() : 0) + 1);
			event2.setAmount((float) damage);
		}
	}
}

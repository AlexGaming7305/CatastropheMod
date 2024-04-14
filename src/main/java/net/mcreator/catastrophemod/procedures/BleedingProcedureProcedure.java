package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BleedingProcedureProcedure {
	@SubscribeEvent
	public static void onEntityHealed(LivingHealEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CatastropheModModMobEffects.BLEEDING.get())) {
			if (Math.random() < 0.15 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.BLEEDING.get()).getAmplifier() : 0) + 1)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}

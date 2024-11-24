package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DamageViolentProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if (entity instanceof Player && sourceentity instanceof LivingEntity && !(sourceentity instanceof Player) && CatastropheModModVariables.WorldVariables.get(world).violent_difficulty == true) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + (amount * 25) / 100;
			event2.setAmount((float) damage);
		}
	}
}

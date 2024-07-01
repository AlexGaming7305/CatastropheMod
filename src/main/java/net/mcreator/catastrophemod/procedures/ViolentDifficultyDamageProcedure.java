package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ViolentDifficultyDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

private static void execute(
@Nullable Event event,
Entity entity,
Entity sourceentity,
double amount
) {
if(
entity == null ||
sourceentity == null
) return ;
double damage = 0;
if (entity instanceof Player&&sourceentity instanceof LivingEntity&&==true) {LivingHurtEvent event2 = (LivingHurtEvent) event;
damage = amount+(amount*25)/ 100;event2.setAmount((float) damage);
if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("hit in violent"), false);}
}
}

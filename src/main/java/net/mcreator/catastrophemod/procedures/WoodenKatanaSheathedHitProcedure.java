package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WoodenKatanaSheathedHitProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

private static void execute(
@Nullable Event event,
Entity sourceentity,
double amount
) {
if(
sourceentity == null
) return ;
double damage = 0;
if (sourceentity instanceof Player) {if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == CatastropheModModItems.WOODEN_KATANA.get()&&==true) {LivingHurtEvent event2 = (LivingHurtEvent) event;
damage = amount+(amount*50)/ 100;event2.setAmount((float) damage);
}}
}
}

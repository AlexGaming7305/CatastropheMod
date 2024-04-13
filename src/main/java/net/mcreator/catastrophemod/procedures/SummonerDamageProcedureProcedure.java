package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SummonerDamageProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		Entity entity = event.getEntity();
		if (event != null && entity != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double damage = 0;
		if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
				|| sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons")))) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + (amount * ((LivingEntity) (sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)).getAttribute(CatastropheModModAttributes.SUMMONERDAMAGE.get()).getBaseValue()) / 100;
			event2.setAmount((float) damage);
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaSicknessProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
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
		Entity projectile = null;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.MANA_SICKNESS.get())) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount
						- (amount * ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.MANA_SICKNESS.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.MANA_SICKNESS.get()).getDuration() : 0) / 4))
								/ 100;
				event2.setAmount((float) damage);
			}
		}
	}
}

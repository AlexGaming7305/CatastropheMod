package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UnparriableProcedureProcedure {
	@SubscribeEvent
	public static void whenEntityBlocksWithShield(ShieldBlockEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getDamageSource(), event.getEntity(), event.getDamageSource().getDirectEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		execute(null, damagesource, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		if (damagesource == null || entity == null || immediatesourceentity == null)
			return;
		ItemStack shield_held = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) {
			shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) {
			shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		}
		if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:unparriable_damage")))
				|| immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:unparriable_projectiles")))) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}

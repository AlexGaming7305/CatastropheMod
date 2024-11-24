package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UnparriableProcedureProcedure {
	@SubscribeEvent
	public static void whenEntityBlocksWithShield(ShieldBlockEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getDamageSource(), event.getDamageSource().getDirectEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity immediatesourceentity) {
		execute(null, damagesource, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity immediatesourceentity) {
		if (damagesource == null || immediatesourceentity == null)
			return;
		if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:unparriable_damage")))) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		} else if (immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:unparriable_projectiles")))) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiantIsopodEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GiantIsopodEntity) {
			if (entity.getPersistentData().getBoolean("isopodpanicked") == false) {
				if (entity instanceof GiantIsopodEntity) {
					((GiantIsopodEntity) entity).setAnimation("animation.giant_isopod.roll_up");
				}
				entity.getPersistentData().putBoolean("isopodpanicked", true);
			}
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaSicknessAboveTenSecondsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.MANA_SICKNESS.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.MANA_SICKNESS.get()).getDuration() : 0) > 200) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(CatastropheModModMobEffects.MANA_SICKNESS.get());
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.MANA_SICKNESS.get(), 200, 0));
		}
	}
}

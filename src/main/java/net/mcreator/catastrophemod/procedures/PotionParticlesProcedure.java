package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PotionParticlesProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.ELECTRIFIED.get())) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.ELECTRIFIED_SPARK.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, (entity.getBbWidth() / 2),
						(entity.getBbHeight() / 4), (entity.getBbWidth() / 2), 0);
		}
		if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(CatastropheModModMobEffects.BLEEDING.get())) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.BLOOD_DROP.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, (entity.getBbWidth() / 2), (entity.getBbHeight() / 4),
						(entity.getBbWidth() / 2), 0);
		}
		if (entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(CatastropheModModMobEffects.OILED.get())) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DELETED_MOD_ELEMENT.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 2, (entity.getBbWidth() / 2),
						(entity.getBbHeight() / 4), (entity.getBbWidth() / 2), 0);
		}
	}
}

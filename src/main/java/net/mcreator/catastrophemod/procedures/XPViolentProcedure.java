package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class XPViolentProcedure {
	@SubscribeEvent
	public static void onLivingDropXp(LivingExperienceDropEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getOriginalExperience());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double originalexperience) {
		execute(null, world, x, y, z, entity, originalexperience);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double originalexperience) {
		if (entity == null)
			return;
		if (CatastropheModModVariables.WorldVariables.get(world).violent_difficulty == true) {
			if (!(entity instanceof Player)) {
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, (int) (originalexperience * 0.5)));
			}
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShootingStarSpawningProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.dayTime() >= 13000 && world.dayTime() <= 24000 && (entity.level().dimension()) == Level.OVERWORLD) {
			if (Math.random() < 0.005) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CatastropheModModEntities.DELETED_MOD_ELEMENT.get().spawn(_level, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -80, 80),
							world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) + 80, entity.getZ() + Mth.nextInt(RandomSource.create(), -80, 80)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}

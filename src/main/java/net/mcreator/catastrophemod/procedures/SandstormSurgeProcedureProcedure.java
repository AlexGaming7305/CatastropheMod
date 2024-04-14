package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SandstormSurgeProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.SANDSTORM_SURGE.get(), lv).isPresent() : false) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).sandstorm_surge_cooldown == false) {
				if (entity.isShiftKeyDown()) {
					{
						boolean _setval = true;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sandstorm_surge_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					CatastropheModMod.queueServerWork(30, () -> {
						{
							boolean _setval = false;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sandstorm_surge_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
						entity.setDeltaMovement(
								new Vec3(((entity.getDeltaMovement().x() * 7 - entity.getDeltaMovement().x() * 6) * 3.5), (entity.getDeltaMovement().y() + 0.15), ((entity.getDeltaMovement().z() * 7 - entity.getDeltaMovement().z() * 6) * 3.5)));
					}
					if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) == false) {
						entity.setDeltaMovement(
								new Vec3(((entity.getDeltaMovement().x() * 7 - entity.getDeltaMovement().x() * 6) * 5), (entity.getDeltaMovement().y() + 0.15), ((entity.getDeltaMovement().z() * 7 - entity.getDeltaMovement().z() * 6) * 5)));
					}
				}
			}
		}
	}
}

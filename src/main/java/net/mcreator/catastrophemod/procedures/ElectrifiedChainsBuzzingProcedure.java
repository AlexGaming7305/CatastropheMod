package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ElectrifiedChainsBuzzingProcedure {
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
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double raytrace_distance = 0;
		double damage_distance = 0;
		sx = -5;
		found = false;
		for (int index0 = 0; index0 < 10; index0++) {
			sy = -5;
			for (int index1 = 0; index1 < 10; index1++) {
				sz = -5;
				for (int index2 = 0; index2 < 10; index2++) {
					if ((world.getBlockState(BlockPos.containing(entity.getX() + sx, entity.getY() + sy, entity.getZ() + sz))).getBlock() == CatastropheModModBlocks.ELECTRIFIED_CHAIN.get()) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			if (entity.getPersistentData().getDouble("electrifiedchains") == 10) {
				entity.getPersistentData().putBoolean("activate", true);
				entity.getPersistentData().putDouble("electrifiedchains", 0);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound catastrophe_mod:electric_buzzing block @s");
					}
				}
			} else {
				entity.getPersistentData().putDouble("electrifiedchains", (entity.getPersistentData().getDouble("electrifiedchains") + 1));
			}
		}
	}
}

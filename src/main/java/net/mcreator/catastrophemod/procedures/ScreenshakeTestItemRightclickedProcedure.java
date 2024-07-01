package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.CatastropheModMod;

public class ScreenshakeTestItemRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 3;
			entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.intensity_timer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.screenshake = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		CatastropheModMod.queueServerWork(20, () -> {
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.screenshake = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
		if (CatastropheModModVariables.WorldVariables.get(world).violent_difficulty == false) {
			CatastropheModModVariables.WorldVariables.get(world).violent_difficulty = true;
			CatastropheModModVariables.WorldVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7aviolent is yes"), false);
		} else if (CatastropheModModVariables.WorldVariables.get(world).violent_difficulty == true) {
			CatastropheModModVariables.WorldVariables.get(world).violent_difficulty = false;
			CatastropheModModVariables.WorldVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cviolent is no"), false);
		}
	}
}

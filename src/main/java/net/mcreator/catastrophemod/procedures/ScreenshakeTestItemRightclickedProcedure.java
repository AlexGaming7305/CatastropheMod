package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

public class ScreenshakeTestItemRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double lightninghitbox = 0;
		{
			double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 3;
			entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.intensity_timer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 60;
			entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.screenshake_time = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
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

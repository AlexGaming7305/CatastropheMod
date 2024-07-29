package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DamageDisplayStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("DamageDisplay") == false) {
			entity.getPersistentData().putBoolean("DamageDisplay", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Damage display has been enabled"), false);
		} else if (entity.getPersistentData().getBoolean("DamageDisplay") == true) {
			entity.getPersistentData().putBoolean("DamageDisplay", false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Damage display has been disabled"), false);
		}
	}
}

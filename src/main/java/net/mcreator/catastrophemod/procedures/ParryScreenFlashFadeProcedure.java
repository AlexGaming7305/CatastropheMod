package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ParryScreenFlashFadeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
if (==true) {{
double _setval = Math.min((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new CatastropheModModVariables.PlayerVariables())).parry_screen_flash+0.25,1);
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.parry_screen_flash = _setval;
capability.syncPlayerVariables(entity);
});
}
}else{{
double _setval = Math.max((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new CatastropheModModVariables.PlayerVariables())).parry_screen_flash-0.25,0);
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.parry_screen_flash = _setval;
capability.syncPlayerVariables(entity);
});
}
}
}
}

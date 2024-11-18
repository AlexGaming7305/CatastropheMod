package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ElectrifiedLightningSkyVisualsTransparencyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level());
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals == true) {
			CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals_transparency = CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals_transparency + 15;
			CatastropheModModVariables.MapVariables.get(world).syncData(world);
		} else if (CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals == false) {
			CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals_transparency = 255;
			CatastropheModModVariables.MapVariables.get(world).syncData(world);
		}
	}
}

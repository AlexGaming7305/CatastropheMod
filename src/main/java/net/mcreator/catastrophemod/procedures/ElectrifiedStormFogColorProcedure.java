package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ElectrifiedStormFogColorProcedure {
	private static ViewportEvent.ComputeFogColor _provider = null;

	private static void setColor(int color) {
		_provider.setRed((color >> 16 & 255) / 255.0F);
		_provider.setGreen((color >> 8 & 255) / 255.0F);
		_provider.setBlue((color & 255) / 255.0F);
	}

	@SubscribeEvent
	public static void computeFogcolor(ViewportEvent.ComputeFogColor event) {
		_provider = event;
		ClientLevel level = Minecraft.getInstance().level;
		Entity entity = _provider.getCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 entPos = entity.getPosition((float) _provider.getPartialTick());
			execute(_provider, level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (CatastropheModModVariables.MapVariables.get(world).electrified_storm == true) {
			setColor((int) (255 << 24 | 68 << 16 | 68 << 8 | 68));
		}
	}
}

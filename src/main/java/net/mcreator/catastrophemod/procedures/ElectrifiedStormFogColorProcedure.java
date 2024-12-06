package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

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
			execute(_provider);
		}
	}

	public static void execute() {
		execute(null);
	}

private static void execute(
@Nullable Event event
) {
if (==true) {setColor((int)(255 << 24 | 60 << 16 | 60 << 8 | 70));}
}
}

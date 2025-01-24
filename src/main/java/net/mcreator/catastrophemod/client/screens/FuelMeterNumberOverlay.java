
package net.mcreator.catastrophemod.client.screens;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class FuelMeterNumberOverlay {

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();

		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;

		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}

		if (

		FuelMeterDisplayOverlayIngameProcedure.execute(entity)

		) {

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					FuelMeterValueProcedure.execute(entity), w / 2 + 109, h - 15, -11727220, false);

		}

	}

}

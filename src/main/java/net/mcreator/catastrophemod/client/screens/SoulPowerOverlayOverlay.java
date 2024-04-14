
package net.mcreator.catastrophemod.client.screens;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SoulPowerOverlayOverlay {

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

		if (true) {

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					SoulPowerOverlayValueProcedure.execute(entity), w / 2 + 103, h / 2 + 100, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MaxSoulPowerOverlayValueProcedure.execute(entity), w / 2 + 116, h / 2 + 100, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.catastrophe_mod.soul_power_overlay.label_empty"), w / 2 + 109, h / 2 + 100, -10066330, false);

		}

	}

}

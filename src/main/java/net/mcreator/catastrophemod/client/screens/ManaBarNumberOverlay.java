
package net.mcreator.catastrophemod.client.screens;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ManaBarNumberOverlay {

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

			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.catastrophe_mod.mana_bar_number.label_mana1"), w - 220, h - 39, -16711681, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ManaBarValueProcedure.execute(entity), w - 193, h - 39, -16711681, false);

		}

	}

}

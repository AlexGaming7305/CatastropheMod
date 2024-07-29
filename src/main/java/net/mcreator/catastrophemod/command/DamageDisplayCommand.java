
package net.mcreator.catastrophemod.command;

@Mod.EventBusSubscriber
public class DamageDisplayCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("damagedisplay")

		);
	}

}


package net.mcreator.catastrophemod.command;

@Mod.EventBusSubscriber
public class EventCommandsCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("event").requires(s -> s.hasPermission(4)).then(Commands.literal("dreadmoon")));
	}

}

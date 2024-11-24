
package net.mcreator.catastrophemod.network;

import net.mcreator.catastrophemod.CatastropheModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShieldParryMessage {

	int type, pressedms;

	public ShieldParryMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public ShieldParryMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(ShieldParryMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(ShieldParryMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			ShieldParryOnKeyPressedProcedure.execute();
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CatastropheModMod.addNetworkMessage(ShieldParryMessage.class, ShieldParryMessage::buffer, ShieldParryMessage::new, ShieldParryMessage::handler);
	}

}

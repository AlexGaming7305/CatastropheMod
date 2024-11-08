
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.catastrophemod.network.ReloadMessage;
import net.mcreator.catastrophemod.network.ParryMessage;
import net.mcreator.catastrophemod.network.DoubleJumpKeyMessage;
import net.mcreator.catastrophemod.network.DashMessage;
import net.mcreator.catastrophemod.network.ArmorSetBonusMessage;
import net.mcreator.catastrophemod.CatastropheModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CatastropheModModKeyMappings {
	public static final KeyMapping DOUBLE_JUMP_KEY = new KeyMapping("key.catastrophe_mod.double_jump_key", GLFW.GLFW_KEY_SPACE, "key.categories.catastrophe") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CatastropheModMod.PACKET_HANDLER.sendToServer(new DoubleJumpKeyMessage(0, 0));
				DoubleJumpKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ARMOR_SET_BONUS = new KeyMapping("key.catastrophe_mod.armor_set_bonus", GLFW.GLFW_KEY_Y, "key.categories.catastrophe") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CatastropheModMod.PACKET_HANDLER.sendToServer(new ArmorSetBonusMessage(0, 0));
				ArmorSetBonusMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DASH = new KeyMapping("key.catastrophe_mod.dash", GLFW.GLFW_KEY_LEFT_CONTROL, "key.categories.catastrophe") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CatastropheModMod.PACKET_HANDLER.sendToServer(new DashMessage(0, 0));
				DashMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PARRY = new KeyMapping("key.catastrophe_mod.parry", GLFW.GLFW_KEY_R, "key.categories.catastrophe") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CatastropheModMod.PACKET_HANDLER.sendToServer(new ParryMessage(0, 0));
				ParryMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping RELOAD = new KeyMapping("key.catastrophe_mod.reload", GLFW.GLFW_KEY_X, "key.categories.catastrophe") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CatastropheModMod.PACKET_HANDLER.sendToServer(new ReloadMessage(0, 0));
				ReloadMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DOUBLE_JUMP_KEY);
		event.register(ARMOR_SET_BONUS);
		event.register(DASH);
		event.register(PARRY);
		event.register(RELOAD);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DOUBLE_JUMP_KEY.consumeClick();
				ARMOR_SET_BONUS.consumeClick();
				DASH.consumeClick();
				PARRY.consumeClick();
				RELOAD.consumeClick();
			}
		}
	}
}

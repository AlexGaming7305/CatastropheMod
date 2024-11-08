package net.mcreator.catastrophemod.init;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.catastrophemod.item.RustgunItem;
import net.mcreator.catastrophemod.item.RipsawItem;
import net.mcreator.catastrophemod.item.NailgunItem;
import net.mcreator.catastrophemod.item.FlamestrikeItem;

@Mod.EventBusSubscriber
public class ItemAnimationFactory {
	public static void disableUseAnim() {
		try {
			ItemInHandRenderer renderer = Minecraft.getInstance().gameRenderer.itemInHandRenderer;
			if (renderer != null) {
				renderer.mainHandHeight = 1F;
				renderer.oMainHandHeight = 1F;
				renderer.offHandHeight = 1F;
				renderer.oOffHandHeight = 1F;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public static void animatedItems(TickEvent.PlayerTickEvent event) {
		String animation = "";
		if (event.phase == TickEvent.Phase.START && (event.player.getMainHandItem().getItem() instanceof GeoItem || event.player.getOffhandItem().getItem() instanceof GeoItem)) {
			if (!event.player.getMainHandItem().getOrCreateTag().getString("geckoAnim").equals("") && !(event.player.getMainHandItem().getItem() instanceof ArmorItem)) {
				animation = event.player.getMainHandItem().getOrCreateTag().getString("geckoAnim");
				event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
				if (event.player.getMainHandItem().getItem() instanceof FlamestrikeItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof RipsawItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof RustgunItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof NailgunItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
			}
			if (!event.player.getOffhandItem().getOrCreateTag().getString("geckoAnim").equals("") && !(event.player.getOffhandItem().getItem() instanceof ArmorItem)) {
				animation = event.player.getOffhandItem().getOrCreateTag().getString("geckoAnim");
				event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
				if (event.player.getOffhandItem().getItem() instanceof FlamestrikeItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof RipsawItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof RustgunItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof NailgunItem animatable)
					if (event.player.level().isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
			}
		}
	}
}

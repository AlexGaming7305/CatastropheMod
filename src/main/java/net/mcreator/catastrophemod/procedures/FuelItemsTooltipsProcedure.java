package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class FuelItemsTooltipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == CatastropheModModItems.WIRESAW.get()) {
			tooltip.add(3, Component.literal(""));
			tooltip.add(4, Component.literal(("\u00A75Fuel: " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("fuel")) + "\u00A75/" + 50)));
			if (Screen.hasShiftDown()) {
				tooltip.add(5, Component.literal("\u00A7dCan only be used if fueled, \u00A7aShift-Right-Click \u00A7dwith a filled Gasoline Canister in your off-hand"));
			} else {
				tooltip.add(5, Component.literal("\u00A77Hold Shift for more info"));
			}
		}
		if (itemstack.getItem() == CatastropheModModItems.GASOLINE_CANISTER.get()) {
			tooltip.add(2, Component.literal(""));
			tooltip.add(3, Component.literal(("\u00A75Fuel: " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("fuel")) + "\u00A75/" + 100)));
		}
	}
}

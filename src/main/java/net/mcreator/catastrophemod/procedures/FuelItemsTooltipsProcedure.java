package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

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
				tooltip.add(5, Component.literal("\u00A7dItems that use fuel will display the fuel meter and can only be used if fueled, to refuel an item, \u00A7aShift-Right-Click \u00A7dwith a filled Gasoline Canister in your off-hand"));
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

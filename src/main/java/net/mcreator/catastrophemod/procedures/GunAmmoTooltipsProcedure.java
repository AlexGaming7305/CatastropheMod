package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class GunAmmoTooltipsProcedure {
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
		if (itemstack.getItem() == CatastropheModModItems.RUSTGUN.get()) {
			if (itemstack.getOrCreateTag().getBoolean("copper_round") == true) {
				tooltip.add(Component.literal(("Projectile: [Copper Round] " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("ammo")) + "/" + 8)));
			} else if (itemstack.getOrCreateTag().getBoolean("scrap_round") == true) {
				tooltip.add(Component.literal(("Projectile: [Scrap Round] " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("ammo")) + "/" + 8)));
			} else if (itemstack.getOrCreateTag().getBoolean("crystal_round") == true) {
				tooltip.add(Component.literal(("Projectile: [\u00A7dCrystal Round\u00A7f] " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("ammo")) + "/" + 8)));
			} else if (itemstack.getOrCreateTag().getBoolean("electrified_round") == true) {
				tooltip.add(Component.literal(("Projectile: [\u00A7bElectrified Round\u00A7f] " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("ammo")) + "/" + 8)));
			} else if (itemstack.getOrCreateTag().getBoolean("venomous_round") == true) {
				tooltip.add(Component.literal(("Projectile: [\u00A72Venomous Round\u00A7f] " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("ammo")) + "/" + 8)));
			}
		}
	}
}

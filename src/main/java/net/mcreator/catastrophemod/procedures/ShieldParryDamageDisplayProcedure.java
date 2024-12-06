package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.init.CatastropheModModEnchantments;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ShieldParryDamageDisplayProcedure {
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
		double shield_parry_damage = 0;
		double naturite_shield_parry_damage = 0;
		if (itemstack.getItem() == Items.SHIELD) {
			if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get(), itemstack) != 0) {
				shield_parry_damage = 8 + 0.5 * itemstack.getEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get()) + 0.5;
			} else {
				shield_parry_damage = 8;
			}
			tooltip.add(1, Component.literal(""));
			tooltip.add(2, Component.literal("\u00A77When Held:"));
			tooltip.add(3, Component.literal((" \u00A72" + new java.text.DecimalFormat("##.##").format(shield_parry_damage) + " Parry Damage")));
		}
		if (itemstack.getItem() == CatastropheModModItems.NATURITE_SHIELD.get()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get(), itemstack) != 0) {
				naturite_shield_parry_damage = 7.5 + 0.5 * itemstack.getEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get()) + 0.5;
			} else {
				naturite_shield_parry_damage = 7.5;
			}
			tooltip.add(2, Component.literal(""));
			tooltip.add(3, Component.literal("\u00A77When Held:"));
			tooltip.add(4, Component.literal((" \u00A72" + new java.text.DecimalFormat("##.##").format(naturite_shield_parry_damage) + " Parry Damage")));
		}
	}
}


package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.procedures.StormCatalystBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.StormCatalystBaubleIsEquippedProcedure;

import java.util.List;

public class StormCatalystItem extends Item implements ICurioItem {
	public StormCatalystItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Magic Attacks inflict \u00A7cElectrified"));
		list.add(Component.literal("\u00A79+5% Magic Damage"));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		StormCatalystBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		StormCatalystBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}

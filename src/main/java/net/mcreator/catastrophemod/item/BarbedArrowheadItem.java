
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.procedures.BarbedArrowheadBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.BarbedArrowheadBaubleIsEquippedProcedure;

import java.util.List;

public class BarbedArrowheadItem extends Item implements ICurioItem {
	public BarbedArrowheadItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Arrows inflict \u00A7cBleeding"));
		list.add(Component.literal("\u00A79+5 Armor Penetration"));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		BarbedArrowheadBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		BarbedArrowheadBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}
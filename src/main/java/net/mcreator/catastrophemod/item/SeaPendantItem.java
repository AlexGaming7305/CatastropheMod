
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.procedures.SeaPendantBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.SeaPendantBaubleIsEquippedProcedure;

import java.util.List;

public class SeaPendantItem extends Item implements ICurioItem {
	public SeaPendantItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A79+1 Swim Speed"));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		SeaPendantBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		SeaPendantBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}

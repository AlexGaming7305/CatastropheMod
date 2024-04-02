
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.catastrophemod.procedures.ReinforcedShieldBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.ReinforcedShieldBaubleIsEquippedProcedure;

public class ReinforcedShieldItem extends Item implements ICurioItem {
	public ReinforcedShieldItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		ReinforcedShieldBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		ReinforcedShieldBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}

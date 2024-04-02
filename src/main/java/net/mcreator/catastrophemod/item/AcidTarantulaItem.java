
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.catastrophemod.procedures.AcidTarantulaBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.AcidTarantulaBaubleIsEquippedProcedure;

public class AcidTarantulaItem extends Item implements ICurioItem {
	public AcidTarantulaItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		AcidTarantulaBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		AcidTarantulaBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}

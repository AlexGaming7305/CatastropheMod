
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.catastrophemod.procedures.AmuletOfVitalityBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.AmuletOfVitalityBaubleIsEquippedProcedure;

public class AmuletOfVitalityItem extends Item implements ICurioItem {
	public AmuletOfVitalityItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		AmuletOfVitalityBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		AmuletOfVitalityBaubleIsUnequippedProcedure.execute(slotContext.entity().level(), slotContext.entity());
	}
}

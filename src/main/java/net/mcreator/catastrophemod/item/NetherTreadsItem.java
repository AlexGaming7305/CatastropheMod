
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.catastrophemod.procedures.NetherTreadsBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.NetherTreadsBaubleIsEquippedProcedure;

public class NetherTreadsItem extends Item implements ICurioItem {
	public NetherTreadsItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		NetherTreadsBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		NetherTreadsBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}

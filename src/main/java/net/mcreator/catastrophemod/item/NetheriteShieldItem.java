
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.catastrophemod.procedures.NetheriteShieldBaubleIsUnequippedProcedure;
import net.mcreator.catastrophemod.procedures.NetheriteShieldBaubleIsEquippedProcedure;

public class NetheriteShieldItem extends Item implements ICurioItem {
	public NetheriteShieldItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		NetheriteShieldBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		NetheriteShieldBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}
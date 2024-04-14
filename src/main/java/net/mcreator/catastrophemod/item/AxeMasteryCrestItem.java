
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class AxeMasteryCrestItem extends Item implements ICurioItem {

	public AxeMasteryCrestItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Grants axes the ability to \u00A74Rend Targets Apart"));
		list.add(Component.literal("\u00A77Inflicts \u00A7cArmor Shred \u00A77which can stack 5 times"));
		list.add(Component.literal("\u00A79+5% Axe Damage"));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		AxeMasteryCrestBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		AxeMasteryCrestBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}

}

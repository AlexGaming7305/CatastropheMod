
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class SpearMasteryCrestItem extends Item implements ICurioItem {

	public SpearMasteryCrestItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Grants spears the ability to \u00A74Puncture Targets"));
		list.add(Component.literal("\u00A77Consecutive Puncture Strikes will increase armor penetration by 1, up to a max of 5"));
		list.add(Component.literal("\u00A79+5% Spear Damage"));
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		SpearMasteryCrestBaubleIsEquippedProcedure.execute();
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		SpearMasteryCrestBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}

}

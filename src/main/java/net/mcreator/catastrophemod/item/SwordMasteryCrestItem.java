
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class SwordMasteryCrestItem extends Item implements ICurioItem {

	public SwordMasteryCrestItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Grants swords the ability to \u00A74Gash Targets"));
		list.add(Component.literal("\u00A77Inflicts \u00A7cBleeding \u00A77if the armor of the target is less than 6"));
		list.add(Component.literal("\u00A79+5% Sword Damage \u00A77to bleeding targets"));
	}

}

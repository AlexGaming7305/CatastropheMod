
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class LifepiercerItem extends Item {
	public LifepiercerItem() {
		super(new Item.Properties().durability(1490).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Inflicts \u00A7cBleeding and \u00A77has a \u00A7a25% chance \u00A77to shoot out a Homing Lifedrain arrow on hit that heals you for half a heart."));
	}
}
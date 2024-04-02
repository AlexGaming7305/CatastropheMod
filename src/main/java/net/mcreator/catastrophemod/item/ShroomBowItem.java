
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ShroomBowItem extends BowItem {
	public ShroomBowItem() {
		super(new Item.Properties().durability(951).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 11;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Has a \u00A7a25% \u00A77chance for arrows to release amatoxin gas."));
	}
}

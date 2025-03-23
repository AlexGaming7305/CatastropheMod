
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;
import net.minecraft.network.chat.Component;

import java.util.List;

public class StormBowItem extends BowItem {
	public StormBowItem() {
		super(new Item.Properties().durability(120).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 12;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Inflicts \u00A7cElectrified"));
		list.add(Component.literal("\u00A77Fully charged shots spawn lightning around the target"));
	}
}

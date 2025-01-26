
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BurnaceItem extends Item implements ICurioItem {
	public BurnaceItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A76Heat \u00A77generates over time when not attacking, increasing damage"));
		list.add(Component.literal("\u00A77Having over \u00A7660% Heat \u00A77will set targets on fire"));
		list.add(Component.literal("\u00A76Heat \u00A77depletes when attacking"));
	}
}

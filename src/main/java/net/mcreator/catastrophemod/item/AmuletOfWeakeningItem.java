
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AmuletOfWeakeningItem extends Item implements ICurioItem {
	public AmuletOfWeakeningItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}

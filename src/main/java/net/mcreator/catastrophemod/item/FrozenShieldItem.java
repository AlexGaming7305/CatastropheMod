
package net.mcreator.catastrophemod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FrozenShieldItem extends Item implements ICurioItem {
	public FrozenShieldItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}


package net.mcreator.catastrophemod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class NourishmentEnchantment extends Enchantment {
	public NourishmentEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}
}

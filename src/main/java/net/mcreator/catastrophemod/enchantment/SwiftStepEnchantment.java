
package net.mcreator.catastrophemod.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class SwiftStepEnchantment extends Enchantment {
	public SwiftStepEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_LEGS, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.SWIFT_SNEAK).contains(ench);
	}
}

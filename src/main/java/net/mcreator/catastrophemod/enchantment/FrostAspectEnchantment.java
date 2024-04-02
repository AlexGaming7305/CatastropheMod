
package net.mcreator.catastrophemod.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.catastrophemod.init.CatastropheModModEnchantments;

import java.util.List;

public class FrostAspectEnchantment extends Enchantment {
	public FrostAspectEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.FIRE_ASPECT, CatastropheModModEnchantments.FROST_ASPECT.get()).contains(ench);
	}
}

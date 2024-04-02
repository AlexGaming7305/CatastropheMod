
package net.mcreator.catastrophemod.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.catastrophemod.init.CatastropheModModEnchantments;

import java.util.List;

public class FrostbiteEnchantment extends Enchantment {
	public FrostbiteEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.FLAMING_ARROWS, CatastropheModModEnchantments.FROST_ASPECT.get()).contains(ench);
	}
}

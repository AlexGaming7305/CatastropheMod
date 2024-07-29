
package net.mcreator.catastrophemod.enchantment;

public class GravitationalRefluxEnchantment extends Enchantment {

	public GravitationalRefluxEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, slots);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

}


package net.mcreator.catastrophemod.enchantment;

public class PreservationEnchantment extends Enchantment {

	public PreservationEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.MENDING).contains(ench);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

}

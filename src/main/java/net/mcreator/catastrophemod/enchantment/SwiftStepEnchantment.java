
package net.mcreator.catastrophemod.enchantment;

public class SwiftStepEnchantment extends Enchantment {

	public SwiftStepEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_LEGS, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.SWIFT_SNEAK).contains(ench);
	}

}

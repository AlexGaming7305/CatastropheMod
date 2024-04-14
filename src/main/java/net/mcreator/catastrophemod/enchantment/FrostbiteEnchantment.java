
package net.mcreator.catastrophemod.enchantment;

public class FrostbiteEnchantment extends Enchantment {

	public FrostbiteEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.FLAMING_ARROWS, CatastropheModModEnchantments.FROST_ASPECT.get()).contains(ench);
	}

}

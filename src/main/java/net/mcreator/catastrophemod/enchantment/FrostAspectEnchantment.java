
package net.mcreator.catastrophemod.enchantment;

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

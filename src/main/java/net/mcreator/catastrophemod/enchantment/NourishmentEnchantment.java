
package net.mcreator.catastrophemod.enchantment;

public class NourishmentEnchantment extends Enchantment {

	public NourishmentEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

}

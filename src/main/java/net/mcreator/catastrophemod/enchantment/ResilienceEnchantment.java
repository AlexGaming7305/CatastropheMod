
package net.mcreator.catastrophemod.enchantment;

public class ResilienceEnchantment extends Enchantment {

	public ResilienceEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

}

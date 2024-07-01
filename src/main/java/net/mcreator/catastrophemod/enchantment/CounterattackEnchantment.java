
package net.mcreator.catastrophemod.enchantment;

public class CounterattackEnchantment extends Enchantment {

	public CounterattackEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(Items.SHIELD)).test(itemstack);
	}

}

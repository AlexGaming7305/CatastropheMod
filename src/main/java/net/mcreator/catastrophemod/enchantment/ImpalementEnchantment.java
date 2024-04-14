
package net.mcreator.catastrophemod.enchantment;

public class ImpalementEnchantment extends Enchantment {

	public ImpalementEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(ItemTags.create(new ResourceLocation("catastrophe_mod:spears"))).test(itemstack);
	}

}


package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class SeaAxeItem extends AxeItem {
	public SeaAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 285;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(CatastropheModModItems.SEA_CRYSTAL_SHARD.get()));
			}
		}, 1, -3.1f, new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Deals \u00A7a50% \u00A77more damage while submerged"));
		list.add(Component.literal("\u00A77Doubled \u00A7aMining Speed \u00A77while submerged"));
	}
}

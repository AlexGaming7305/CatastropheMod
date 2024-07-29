
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class BrassColoredPickaxeItem extends PickaxeItem {
	public BrassColoredPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 240;
			}

			public float getSpeed() {
				return 11f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(CatastropheModModItems.COPPER_SHARD.get()));
			}
		}, 1, -2.8f, new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Critical hits increase \u00A79Attack Speed \u00A77by \u00A790.3"));
		list.add(Component.literal("\u00A7aRight-Click: \u00A77Performs a Mine Blast with the \u00A7eBrass Colored Shovel \u00A77in the other hand"));
		list.add(Component.literal("\u00A77\"Let's dig up!\""));
	}
}

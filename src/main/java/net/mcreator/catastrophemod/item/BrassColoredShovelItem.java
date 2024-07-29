
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

import java.util.List;

public class BrassColoredShovelItem extends ShovelItem {
	public BrassColoredShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 240;
			}

			public float getSpeed() {
				return 11f;
			}

			public float getAttackDamageBonus() {
				return 4.5f;
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
		}, 1, -3f, new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Critical hits increase \u00A79Speed \u00A77by \u00A7910%"));
		list.add(Component.literal("\u00A7aRight-Click: \u00A77Performs a Mine Blast with the \u00A7eBrass Colored Pickaxe \u00A77in the other hand "));
		list.add(Component.literal("\u00A77\"Let's dig up!\""));
	}
}

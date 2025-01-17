
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.AccursedArrowProjectileEntity;

import java.util.Stack;
import java.util.List;

public class AccursedArrowItem extends ArrowItem {
	public AccursedArrowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Homes into a nearby target"));
	}

	@Override
	public AbstractArrow createArrow(Level world, ItemStack Stack, LivingEntity shooter) {
		return new AccursedArrowProjectileEntity(CatastropheModModEntities.ACCURSED_ARROW_PROJECTILE.get(), shooter, world);
	}
}

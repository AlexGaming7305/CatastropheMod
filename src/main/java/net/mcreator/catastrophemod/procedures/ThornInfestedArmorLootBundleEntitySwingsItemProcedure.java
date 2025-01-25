package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.init.CatastropheModModBlocks;

public class ThornInfestedArmorLootBundleEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double drop = 0;
		double accessory_drop = 0;
		drop = Math.round(Math.random() * 2);
		accessory_drop = Math.round(Math.random() * 1);
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(CatastropheModModItems.THORN_INFESTED_ARMOR_LOOT_BUNDLE.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (drop == 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.THORN_SWORD.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.REINFORCED_AXE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 2) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.THORN_BOW.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (accessory_drop == 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModBlocks.MOLTEN_CHARRED_BRICKS.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (accessory_drop == 1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModBlocks.MOLTEN_CHARRED_BRICKS.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (Math.random() < 0.1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.MUSIC_DISC_VINES_OF_VENOM.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(CatastropheModModItems.REINFORCED_PLATES.get());
			_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 1, 4));
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(CatastropheModModItems.POISONED_VINES.get());
			_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 5, 15));
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}

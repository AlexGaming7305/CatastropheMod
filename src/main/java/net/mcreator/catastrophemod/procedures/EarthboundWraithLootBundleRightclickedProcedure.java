package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

public class EarthboundWraithLootBundleRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double drop = 0;
		drop = Math.round(Math.random() * 2);
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(CatastropheModModItems.EARTHBOUND_WRAITH_LOOT_BUNDLE.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (drop == 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.EARTH_BREAKER.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.EARTH_SHATTERER.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 2) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.EARTHBOUND_STAFF.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (Math.random() < 0.1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.MUSIC_DISC_BATTLE_OF_STONE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}

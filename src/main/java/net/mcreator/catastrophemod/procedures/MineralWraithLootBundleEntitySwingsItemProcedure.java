package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

public class MineralWraithLootBundleEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double drop = 0;
		drop = Math.round(Math.random() * 3);
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(CatastropheModModItems.MINERAL_WRAITH_LOOT_BUNDLE.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (drop == 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.ELECTRIFIED_SWORD.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.STORM_BOW.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 2) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.SPELLOF_LIGHTNING.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 3) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.LIGHTNING_BLADE_STAFF.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (Math.random() < 0.25) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.STORM_SHIELD.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (Math.random() < 0.1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.MUSIC_DISC_STRIKE_YOU_DOWN.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(CatastropheModModItems.COPPER_SHARD.get());
			_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 3, 11));
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

public class SepulcherLootBundleRightclickedOnBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double drop = 0;
		drop = Math.round(Math.random() * 2);
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(CatastropheModModItems.SEPULCHER_LOOT_BUNDLE.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (drop == 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.SHADOWFLAME_BURSTER.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.SHADOWFLAME_WHISPER.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (drop == 2) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.SHADOWFLAME_SCEPTER.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (Math.random() < 0.1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CatastropheModModItems.MUSIC_DISC_SPARK_OF_A_SHADOW.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(CatastropheModModItems.SHADOWFLAME_FRAGMENT.get());
			_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 2, 6));
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}


/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CatastropheModModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12),

					new ItemStack(Blocks.ANVIL), 3, 15, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12),

					new ItemStack(Blocks.ANVIL), 3, 15, 0.05f));
		}
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12),

					new ItemStack(Blocks.ANVIL), 3, 15, 0.05f));
		}
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.OAK_LOG, 8), 10, 1, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.BIRCH_LOG, 8), 10, 1, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(CatastropheModModItems.TWIG.get(), 8),

					new ItemStack(Items.EMERALD), 10, 2, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.DARK_OAK_LOG, 8), 10, 10, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.SPRUCE_LOG, 8), 10, 10, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.JUNGLE_LOG, 8), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.ACACIA_LOG, 8), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

					new ItemStack(CatastropheModModItems.FIREBRAND.get()), 3, 20, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.CHERRY_LOG, 8), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.MANGROVE_LOG, 8), 10, 25, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.CRIMSON_STEM, 8), 10, 30, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.WARPED_STEM, 8), 10, 30, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Blocks.SHROOMLIGHT, 4),

					new ItemStack(Items.EMERALD), 10, 30, 0.05f));
		}
	}
}

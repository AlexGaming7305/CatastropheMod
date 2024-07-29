
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CatastropheModModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.FLETCHER) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(CatastropheModModItems.QUIVER.get()),

					new ItemStack(Items.EMERALD, 12), 3, 25, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(CatastropheModModItems.AXE_MASTERY_CREST.get()), 3, 25, 0.02f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(CatastropheModModItems.SWORD_MASTERY_CREST.get()), 3, 25, 0.02f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(CatastropheModModItems.SPEAR_MASTERY_CREST.get()), 3, 25, 0.02f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(CatastropheModModItems.ROTTEN_HEART.get()),

					new ItemStack(Items.EMERALD, 12), 3, 25, 0.05f));
		}
	}
}

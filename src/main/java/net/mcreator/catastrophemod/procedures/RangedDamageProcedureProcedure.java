package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RangedDamageProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double damage = 0;
		if (sourceentity instanceof Player
				&& ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof BowItem
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof BowItem
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof CrossbowItem
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof CrossbowItem
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:ranged_weapons")))
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:ranged_weapons"))))
				&& ((LivingEntity) sourceentity).getAttribute(CatastropheModModAttributes.RANGEDDAMAGE.get()).getBaseValue() != 0) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + (amount * ((LivingEntity) sourceentity).getAttribute(CatastropheModModAttributes.RANGEDDAMAGE.get()).getBaseValue()) / 100;
			event2.setAmount((float) damage);
		}
	}
}

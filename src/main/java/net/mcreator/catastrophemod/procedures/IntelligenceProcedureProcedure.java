package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IntelligenceProcedureProcedure {
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
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.INTELLIGENCE.get())) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + 3 * ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.INTELLIGENCE.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.INTELLIGENCE.get()).getAmplifier() : 0) + 1);
				event2.setAmount((float) damage);
			}
		}
	}
}

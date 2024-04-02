package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
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
		Entity entity = event.getEntity();
		if (event != null && entity != null) {
			execute(event, event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		double damage = 0;
		Entity projectile = null;
		projectile = immediatesourceentity;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CatastropheModModMobEffects.INTELLIGENCE.get())) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))) {
				if (projectile instanceof Projectile) {
					LivingHurtEvent event2 = (LivingHurtEvent) event;
					damage = amount
							+ 3 * ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.INTELLIGENCE.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.INTELLIGENCE.get()).getAmplifier() : 0) + 1);
					event2.setAmount((float) damage);
				}
			}
		}
	}
}

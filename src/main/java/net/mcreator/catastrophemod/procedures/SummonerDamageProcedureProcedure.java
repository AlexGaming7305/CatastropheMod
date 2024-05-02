package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SummonerDamageProcedureProcedure {
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
		if (sourceentity instanceof Player) {
			if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:summons")))
					|| sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:accessory_summons")))) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + (amount * ((LivingEntity) (sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)).getAttribute(CatastropheModModAttributes.SUMMONERDAMAGE.get()).getBaseValue()) / 100;
				event2.setAmount((float) damage);
			}
		}
	}
}

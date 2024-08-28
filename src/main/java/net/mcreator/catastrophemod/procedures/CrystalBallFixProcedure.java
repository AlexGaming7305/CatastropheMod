package net.mcreator.catastrophemod.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CrystalBallFixProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.CRYSTAL_BALL.get(), lv).isPresent() : false) {
			((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAXMANA.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MAXMANA.get()).getValue() - 40));
			((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.CASTINGSPEED.get()).getValue() - 12));
		}
	}
}

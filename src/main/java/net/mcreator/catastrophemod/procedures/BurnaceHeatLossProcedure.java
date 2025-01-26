package net.mcreator.catastrophemod.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BurnaceHeatLossProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if (sourceentity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.BURNACE.get(), lv).isPresent() : false) {
			LivingHurtEvent event2 = (LivingHurtEvent) event;
			damage = amount + amount * ((0.35 * (sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).burnace_heat) / 100);
			event2.setAmount((float) damage);
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).burnace_heat >= 60) {
				entity.setSecondsOnFire(3);
			}
			if (!sourceentity.isOnFire()) {
				{
					double _setval = (sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).burnace_heat - 10;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.burnace_heat = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).burnace_heat_cooldown == false) {
					{
						boolean _setval = true;
						sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.burnace_heat_cooldown = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					CatastropheModMod.queueServerWork(20, () -> {
						{
							boolean _setval = false;
							sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.burnace_heat_cooldown = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					});
				}
			}
		}
	}
}

package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PocketShieldGeneratorItemInInventoryTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).pocketshield == true) {
			if (entity.getPersistentData().getDouble("alexs_mod:Pocket_Shield_Generator") == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 0));
			}
			if (entity.getPersistentData().getDouble("alexs_mod:Pocket_Shield_Generator") == 0) {
				entity.getPersistentData().putDouble("alexs_mod:Pocket_Shield_Generator", 200);
			} else {
				entity.getPersistentData().putDouble("alexs_mod:Pocket_Shield_Generator", (entity.getPersistentData().getDouble("alexs_mod:Pocket_Shield_Generator") - 1));
			}
		}
	}
}

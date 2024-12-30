package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.GiantIsopodEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiantIsopodEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GiantIsopodEntity) {
			if (entity.getPersistentData().getBoolean("isopodpanicked") == false) {
				entity.getPersistentData().putBoolean("isopodpanicked", true);
				if (entity instanceof GiantIsopodEntity) {
					((GiantIsopodEntity) entity).setAnimation("animation.giant_isopod.roll_up");
				}
				CatastropheModMod.queueServerWork(15, () -> {
					if (entity instanceof GiantIsopodEntity) {
						((GiantIsopodEntity) entity).setAnimation("animation.giant_isopod.rolled_up");
					}
				});
				CatastropheModMod.queueServerWork(115, () -> {
					if (entity instanceof GiantIsopodEntity) {
						((GiantIsopodEntity) entity).setAnimation("animation.giant_isopod.unroll");
					}
				});
				CatastropheModMod.queueServerWork(135, () -> {
					entity.getPersistentData().putBoolean("isopodpanicked", false);
				});
			}
		}
	}
}

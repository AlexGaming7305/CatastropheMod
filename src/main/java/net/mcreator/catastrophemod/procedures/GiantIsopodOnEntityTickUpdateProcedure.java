package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class GiantIsopodOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity nightfallsdemiseowner = null;
		boolean isopod_unroll_animation = false;
		double lifetime = 0;
		double panictime = 0;
		double rolltime = 0;
		if (entity.getPersistentData().getBoolean("isopodpanicked") == true) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y() - 0.03), 0));
			((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(0);
		} else {
			((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(2.5);
		}
		if (entity.getPersistentData().getBoolean("isopodcooldown") == true) {
			if (entity.getPersistentData().getDouble("isopodtimer") == 2400) {
				entity.getPersistentData().putDouble("isopodtimer", 0);
				entity.getPersistentData().putBoolean("isopodcooldown", false);
			} else {
				entity.getPersistentData().putDouble("isopodtimer", (entity.getPersistentData().getDouble("isopodtimer") + 1));
			}
		}
	}
}

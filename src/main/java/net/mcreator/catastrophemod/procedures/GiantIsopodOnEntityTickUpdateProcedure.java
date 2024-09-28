package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.entity.GiantIsopodEntity;

public class GiantIsopodOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity nightfallsdemiseowner = null;
		boolean isopod_unroll_animation = false;
		double lifetime = 0;
		double panictime = 0;
		double rolltime = 0;
		if (entity.getPersistentData().getBoolean("isopodpanicked") == true) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y() - 0.03), 0));
			if (entity.getPersistentData().getDouble("rolledup") > 15) {
				if (entity instanceof GiantIsopodEntity) {
					((GiantIsopodEntity) entity).setAnimation("animation.giant_isopod.rolled_up");
				}
				entity.getPersistentData().putDouble("rolledup", 0);
			} else {
				entity.getPersistentData().putDouble("rolledup", (entity.getPersistentData().getDouble("rolledup") + 1));
			}
			if (entity.getPersistentData().getDouble("panictime") > 100) {
				if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty())) {
					if (entity instanceof GiantIsopodEntity) {
						((GiantIsopodEntity) entity).setAnimation("animation.giant_isopod.unroll");
					}
					entity.getPersistentData().putBoolean("isopodpanicked", false);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
					entity.getPersistentData().putDouble("panictime", 0);
				}
			} else {
				entity.getPersistentData().putDouble("panictime", (entity.getPersistentData().getDouble("panictime") + 1));
			}
		}
		if (entity.getPersistentData().getBoolean("isopodpanicked") == false) {
			entity.getPersistentData().putDouble("panictime", 0);
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

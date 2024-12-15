package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;

public class OiledOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean burning_oil = false;
		if (entity.isOnFire() && burning_oil == false) {
			entity.setSecondsOnFire((int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.OILED.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.OILED.get()).getDuration() : 0) / 20));
			burning_oil = true;
		}
	}
}

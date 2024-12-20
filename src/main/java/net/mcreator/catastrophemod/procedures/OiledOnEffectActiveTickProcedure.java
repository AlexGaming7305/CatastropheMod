package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class OiledOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean burning_oil = false;
		if (entity.isOnFire() && burning_oil == false) {
			entity.setSecondsOnFire(
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.DELETED_MOD_ELEMENT.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.DELETED_MOD_ELEMENT.get()).getDuration() : 0) / 20));
			burning_oil = true;
		}
	}
}

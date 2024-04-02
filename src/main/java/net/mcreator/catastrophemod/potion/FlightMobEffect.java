
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.FlightEffectStartedappliedProcedure;

public class FlightMobEffect extends MobEffect {
	public FlightMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13382401);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.flight";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FlightEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

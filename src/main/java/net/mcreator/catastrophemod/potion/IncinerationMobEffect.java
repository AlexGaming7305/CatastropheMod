
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.IncinerationOnEffectActiveTickProcedure;

public class IncinerationMobEffect extends MobEffect {
	public IncinerationMobEffect() {
		super(MobEffectCategory.HARMFUL, -33024);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.incineration";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		IncinerationOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}


package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.PrickedOnEffectActiveTickProcedure;

public class PrickedMobEffect extends MobEffect {
	public PrickedMobEffect() {
		super(MobEffectCategory.HARMFUL, -12425698);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.pricked";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PrickedOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
